package GUI;

import BUS.ChucNangBUS;
import BUS.NhomQuyenBUS;
import DAO.NhomQuyenDAO;
import DTO.ChiTietQuyenDTO;
import DTO.ChucNangDTO;
import DTO.NhomQuyenDTO;
import static GUI.admin.panel_load;
import helper.Validation;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class QuyenDialog extends javax.swing.JDialog {

    JCheckBox[][] checkBoxList;
    String[] maHanhDong = {"view", "add", "edit", "delete"};
    String[] hanhDong = {"Xem", "Thêm", "Sửa", "Xóa"};
    private int sizeCN, sizeHD, newQuyenId;
    private ChucNangBUS cnBUS = new ChucNangBUS();
    private NhomQuyenBUS qBUS = new NhomQuyenBUS();
    private ArrayList<ChucNangDTO> cnList = cnBUS.getAll();
    private NhomQuyenDTO quyen;
    private ArrayList<ChiTietQuyenDTO> ctQuyenList;
    private String mode;

    public QuyenDialog(java.awt.Frame parent, boolean modal, NhomQuyenDTO quyen, ArrayList<ChiTietQuyenDTO> ctQuyenList, String mode) {
        super(parent, modal);
        initComponents();
        initComponentsCustom();
        this.mode = mode;
        if (mode.equals("detail")) {
            this.quyen = quyen;
            this.ctQuyenList = ctQuyenList;
            initDetailMode();
        }
        if (mode.equals("edit")) {
            this.quyen = quyen;
            this.ctQuyenList = ctQuyenList;
            initEditMode();
        }
        if (mode.equals("add")) {
            initAddMode();
        }
    }

    public void initComponentsCustom() {
        setLocationRelativeTo(null);
        newQuyenId = NhomQuyenDAO.getInstance().getAutoIncrement();
        sizeCN = this.cnList.size();
        sizeHD = maHanhDong.length;
        this.checkBoxList = new JCheckBox[sizeCN][sizeHD];

        JLabel tenCN = new JLabel("Tên chức năng");
        tenCN.setHorizontalAlignment(SwingConstants.CENTER);
        tenCN.setFont(new Font("Segoe UI", Font.BOLD, 12));
        pnl_hanhdong.add(tenCN);

        for (int i = 0; i < sizeHD; i++) {
            JLabel jlb = new JLabel(hanhDong[i]);
            jlb.setHorizontalAlignment(SwingConstants.CENTER);
            jlb.setFont(new Font("Segoe UI", Font.BOLD, 12));
            pnl_hanhdong.add(jlb);
        }

        // Tạo GridLayout cho jPanel2: 1 cột cho tên chức năng và 4 cột cho checkbox (Xem, Thêm, Sửa, Xóa)
        jPanel2.setLayout(new GridLayout(0, sizeHD + 1, 20, 10)); // 1 cột tên + 4 cột checkbox

        // Thêm tên chức năng và các checkbox vào jPanel2
        for (int i = 0; i < sizeCN; i++) {
            // Thêm tên chức năng (label)
            JLabel jlb = new JLabel(cnList.get(i).getTenchucnang());
            jlb.setHorizontalAlignment(SwingConstants.CENTER);
            jlb.setFont(new Font("Segoe UI", Font.BOLD, 12));
            jPanel2.add(jlb); // Thêm label vào jPanel2

            // Thêm 4 checkbox tương ứng với chức năng
            for (int j = 0; j < sizeHD; j++) {
                checkBoxList[i][j] = new JCheckBox();
                checkBoxList[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                jPanel2.add(checkBoxList[i][j]); // Thêm checkbox vào jPanel2
            }
        }

        // Kiểm tra và vô hiệu hóa checkbox dựa trên điều kiện
        for (int i = 0; i < sizeCN; i++) {
            for (int j = 0; j < sizeHD; j++) {
                if (cnList.get(i).getTenchucnang().equals("Hóa đơn")) {
                    if (maHanhDong[j].equals("edit")) {
                        checkBoxList[i][j].setEnabled(false);
                    }
                }
                if (cnList.get(i).getTenchucnang().equals("Thống kê")) {
                    if (maHanhDong[j].equals("add") || maHanhDong[j].equals("edit") || maHanhDong[j].equals("delete")) {
                        checkBoxList[i][j].setEnabled(false);
                    }
                }
            }
        }

        // Sau khi thêm checkbox và label vào jPanel2, cần cập nhật lại UI
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    public void initDetailMode() {
        txtTenQuyen.setText(quyen.getTennhomquyen());
        txtTenQuyen.setFocusable(false);
        for (int i = 0; i < sizeCN; i++) {
            for (int j = 0; j < sizeHD; j++) {
                checkBoxList[i][j].setEnabled(false);
            }
        }
        for (ChiTietQuyenDTO k : ctQuyenList) {
            for (int i = 0; i < sizeCN; i++) {
                for (int j = 0; j < sizeHD; j++) {
                    if (k.getMachucnang() == cnList.get(i).getMachucnang() && k.getHanhdong().equals(maHanhDong[j])) {
                        checkBoxList[i][j].setSelected(true);
                    }
                }
            }
        }
        btn_themQuyen.setText("Xác nhận");
    }

    public void initEditMode() {
        txtTenQuyen.setText(quyen.getTennhomquyen());
        for (ChiTietQuyenDTO k : ctQuyenList) {
            for (int i = 0; i < sizeCN; i++) {
                for (int j = 0; j < sizeHD; j++) {
                    if (k.getMachucnang() == cnList.get(i).getMachucnang() && k.getHanhdong().equals(maHanhDong[j])) {
                        checkBoxList[i][j].setSelected(true);
                    }
                }
            }
        }
        btn_themQuyen.setText("Lưu thay đổi");
    }

    public void initAddMode() {
//           initComponentsCustom();

    }

    public ArrayList<ChiTietQuyenDTO> getCTQuyenList(int quyenId) {
        ArrayList<ChiTietQuyenDTO> result = new ArrayList<>();
        for (int i = 0; i < sizeCN; i++) {
            for (int j = 0; j < sizeHD; j++) {
                if (checkBoxList[i][j].isSelected()) {
                    ChiTietQuyenDTO ctq = new ChiTietQuyenDTO(quyenId, cnList.get(i).getMachucnang(), maHanhDong[j]);
                    result.add(ctq);
                }
            }
        }
        return result;
    }

    public boolean Validate() {
        if (Validation.isEmpty(txtTenQuyen.getText())) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenQuyen = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnl_center = new javax.swing.JPanel();
        pnl_hanhdong = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_themQuyen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên quyền");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        pnl_center.setLayout(new java.awt.BorderLayout());

        pnl_hanhdong.setBackground(new java.awt.Color(255, 255, 255));
        pnl_hanhdong.setPreferredSize(new java.awt.Dimension(780, 50));
        pnl_hanhdong.setLayout(new java.awt.GridLayout(1, 4));
        pnl_center.add(pnl_hanhdong, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        pnl_center.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.add(pnl_center, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(900, 50));

        jButton1.setBackground(new java.awt.Color(255, 107, 107));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Hủy");
        jButton1.setBorder(null);
        jButton1.setPreferredSize(new java.awt.Dimension(120, 40));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        btn_themQuyen.setBackground(new java.awt.Color(102, 204, 255));
        btn_themQuyen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_themQuyen.setForeground(new java.awt.Color(255, 255, 255));
        btn_themQuyen.setText("Thêm quyền");
        btn_themQuyen.setBorder(null);
        btn_themQuyen.setPreferredSize(new java.awt.Dimension(120, 40));
        btn_themQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_themQuyenMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(btn_themQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themQuyenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themQuyenMousePressed
        if (mode.equals("detail")) {
            dispose();
            return;
        }
        if (mode.equals("edit")) {
            this.quyen.setTennhomquyen(txtTenQuyen.getText());
            this.ctQuyenList = getCTQuyenList(quyen.getManhomquyen());
            if (qBUS.update(this.quyen, this.ctQuyenList)) {
                JOptionPane.showMessageDialog(this, "Lưu thay đổi thành công");
                dispose();
            }
        }
        if (mode.equals("add")) {
            if (!Validate()) {
                JOptionPane.showMessageDialog(this, "Tên quyền không được rỗng");
                return;
            }
            NhomQuyenDTO newQuyen = new NhomQuyenDTO(newQuyenId, txtTenQuyen.getText(), 1);
            ArrayList<ChiTietQuyenDTO> newCTQList = getCTQuyenList(newQuyenId);

            if (qBUS.add(newQuyen, newCTQList)) {
                JpanelLoader jpload = new JpanelLoader();
                PhanQuyen pn = new PhanQuyen(admin.parent, null);
                jpload.jPanelLoader(panel_load, pn);
                JOptionPane.showMessageDialog(this, "Thêm quyền mới thành công");
                dispose();
            }
        }
    }//GEN-LAST:event_btn_themQuyenMousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        dispose();
    }//GEN-LAST:event_jButton1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_themQuyen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_center;
    private javax.swing.JPanel pnl_hanhdong;
    private javax.swing.JTextField txtTenQuyen;
    // End of variables declaration//GEN-END:variables
}
