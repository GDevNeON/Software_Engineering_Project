/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.details;

import BUS.CTPhieuXuatBUS;
import helper.writePDF;
import BUS.PhieuXuatBUS;
import DTO.PhieuXuatDTO;
import BUS.SanPhamBUS;
import DTO.ChiTietPhieuXuatDTO;
import DTO.SanPhamDTO;
import GUI.phieuxuat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NeON
 */
public class cancelphieuxuat extends javax.swing.JDialog {

    private phieuxuat parent;
    PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    SanPhamBUS spBUS = new SanPhamBUS();

    public cancelphieuxuat(phieuxuat parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.parent = (phieuxuat) parent;
        initComponents();
        setModal(modal);
        setLocationRelativeTo(null);
        initTable();
        displayInfo();
    }

    public final void initTable() {
        DefaultTableModel tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT", "Mã sp", "Tên sản phẩm ", "Số lượng ", "Đơn giá"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblctsanpham.setModel(tblModel);
        tblctsanpham.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblctsanpham.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblctsanpham.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblctsanpham.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblctsanpham.getColumnModel().getColumn(0).setPreferredWidth(5);
    }
//bao

    public cancelphieuxuat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public cancelphieuxuat(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void displayInfo() {
        PhieuXuatDTO kh = parent.getPhieuXuatSelect();
        txtmapx.setText("" + kh.getMaphieuxuat());
        txttenkh.setText("" + kh.getTenkhachhang());
        txttennvnhap.setText("" + kh.getTennvnhap());
        txtthoigian.setText("" + kh.getThoigian());
        ArrayList<PhieuXuatDTO> listctpx = pxBUS.phieuXuatDAO.selectAllCtpx();
        displaytoTable(kh, listctpx);
        tblctsanpham.setDefaultEditor(Object.class, null);
    }

    public void displaytoTable(PhieuXuatDTO kh, ArrayList<PhieuXuatDTO> list) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblctsanpham.getModel();
            ArrayList<SanPhamDTO> listsp = spBUS.spDAO.selectAll();
            int index = 1;
            dt.setRowCount(0);
            for (PhieuXuatDTO i : list) {
                if (i.getMaphieuxuat() == kh.getMaphieuxuat()) {
                    String tenSanPham = findProductName(i.getMasp(), listsp);
                    dt.addRow(new Object[]{
                        index, i.getMasp(), tenSanPham, i.getSoluong(), i.getDongia()
                    });
                    index++; // Tăng chỉ số sau mỗi lần thêm hàng
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi nếu có bất kỳ ngoại lệ nào xảy ra
        }
    }

    private String findProductName(int maSanPham, ArrayList<SanPhamDTO> listsp) {
        for (SanPhamDTO sanPham : listsp) {
            if (sanPham.getMasp() == maSanPham) {
                return sanPham.getTensp();
            }
        }
        return ""; // Trả về chuỗi rỗng nếu không tìm thấy tên sản phẩm
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmapx = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttenkh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttennvnhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtthoigian = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblctsanpham = new javax.swing.JTable();
        btnHuy = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 450));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 450));

        jPanel2.setBackground(new java.awt.Color(77, 158, 209));

        jLabel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHI TIẾT PHIẾU XUẤT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        txtmapx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmapxActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã phiếu xuất");

        jLabel3.setText("Chi tiết sản phẩm xuất");

        jLabel4.setText("Khách hàng");

        txttenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenkhActionPerformed(evt);
            }
        });

        jLabel5.setText("Nhân viên nhập");

        txttennvnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttennvnhapActionPerformed(evt);
            }
        });

        jLabel6.setText("Thời gian tạo");

        txtthoigian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthoigianActionPerformed(evt);
            }
        });

        tblctsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phiếu nhập", "Mã sp", "Tên sp", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblctsanpham);

        btnHuy.setBackground(new java.awt.Color(255, 0, 51));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("XÁC NHẬN HỦY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtmapx, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttennvnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtthoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHuy)
                .addGap(331, 331, 331))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtthoigian))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttennvnhap))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttenkh))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmapx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtmapxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmapxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmapxActionPerformed

    private void txttenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenkhActionPerformed

    private void txttennvnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttennvnhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttennvnhapActionPerformed

    private void txtthoigianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthoigianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtthoigianActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tblctsanpham.getModel();
            int rowCount = model.getRowCount();

            int mapx = Integer.parseInt(txtmapx.getText());
            ArrayList<SanPhamDTO> listsp = spBUS.spDAO.selectAll();

            // Lặp qua các dòng trong bảng
            for (int i = 0; i < rowCount; i++) {
                // Lấy mã sản phẩm và số lượng
                int masp = Integer.parseInt(model.getValueAt(i, 1) + "");
                int soluong = Integer.parseInt(model.getValueAt(i, 3) + "");

                // Trừ số lượng tồn kho của sản phẩm
                boolean updateSuccess = spBUS.updateQuantity(masp, soluong);
                if (!updateSuccess) {
                    JOptionPane.showMessageDialog(this, "Cập nhật số lượng tồn kho không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Xóa phiếu nhập
            pxBUS.delete(mapx);
            this.dispose();
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Hủy phiếu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thực hiện hủy phiếu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cancelphieuxuat dialog = new cancelphieuxuat(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblctsanpham;
    private javax.swing.JTextField txtmapx;
    private javax.swing.JTextField txttenkh;
    private javax.swing.JTextField txttennvnhap;
    private javax.swing.JTextField txtthoigian;
    // End of variables declaration//GEN-END:variables
}