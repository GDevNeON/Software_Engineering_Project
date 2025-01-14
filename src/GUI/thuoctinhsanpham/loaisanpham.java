/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.thuoctinhsanpham;

import DTO.LoaiSanPhamDTO;
import BUS.LoaiSanPhamBUS;
import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import security.Authorization;

/**
 *
 * @author Bao Phan
 */
public class loaisanpham extends javax.swing.JDialog {

    DefaultTableModel tblModel = new DefaultTableModel();
    ArrayList<LoaiSanPhamDTO> list = new ArrayList<LoaiSanPhamDTO>();
    LoaiSanPhamBUS lspBUS = new LoaiSanPhamBUS();
    ArrayList<SanPhamDTO> listSP = new SanPhamBUS().getAll();

    public loaisanpham(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initTable();
        setModal(modal);
        setLocationRelativeTo(null);
        list = lspBUS.lspDAO.selectAll();
        loadDataToTable(list);
        Authorization authorization = new Authorization(btnThem, btnXoa);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã thương hiệu", "Tên Thương Hiệu"};
        tblModel.setColumnIdentifiers(headerTbl);
        tablelsp.setModel(tblModel);
        tablelsp.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablelsp.getColumnModel().getColumn(1).setPreferredWidth(10);

    }

    public void loadDataToTable(ArrayList<LoaiSanPhamDTO> result) {
        tblModel.setRowCount(0);
        for (LoaiSanPhamDTO lsp : result) {

            tblModel.addRow(new Object[]{
                lsp.getMaloai(), lsp.getTenloai()
            });
        }

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablelsp = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtloaisp = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 580));

        jPanel2.setBackground(new java.awt.Color(77, 158, 209));

        jLabel1.setBackground(new java.awt.Color(77, 158, 209));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                                              PHÂN LOẠI SẢN PHẨM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        tablelsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablelsp.setRowHeight(50);
        tablelsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablelspMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablelsp);

        btnXoa.setBackground(new java.awt.Color(255, 0, 51));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nhập tên loại sản phẩm");

        btnThem.setBackground(new java.awt.Color(51, 255, 51));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtloaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(btnClear))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtloaisp, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtloaisp.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            list = lspBUS.lspDAO.selectAll();
            String tenloai = txtloaisp.getText();
            int maloai = lspBUS.lspDAO.getAutoIncrement();
            if (!"".equals(tenloai)) {
                for(LoaiSanPhamDTO x : list) {
                    if(x.getTenloai().equalsIgnoreCase(tenloai)) {
                        JOptionPane.showMessageDialog(null, "Loại sản phẩm này đã tốn tại");
                        return;
                    }
                }
                LoaiSanPhamDTO lsp = new LoaiSanPhamDTO(maloai, tenloai, 1);
                lspBUS.add(lsp);
                JOptionPane.showMessageDialog(this, "Thêm Thành Công !");
                loadDataToTable(lspBUS.lspDAO.selectAll());
            } else {
                JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Tên Loại Sản Phẩm !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thất bại !");
        }
    }//GEN-LAST:event_btnThemActionPerformed
    public LoaiSanPhamDTO getLoaiSanPhamSelect() {
        int i_row = tablelsp.getSelectedRow();
        LoaiSanPhamDTO lsp = lspBUS.lspDAO.selectAll().get(i_row);
        return lsp;
    }

    private void tablelspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablelspMouseClicked
        LoaiSanPhamDTO a = getLoaiSanPhamSelect();
        txtloaisp.setText("  " + a.getTenloai());
    }//GEN-LAST:event_tablelspMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//        if (tablelsp.getSelectedRow() == -1) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sản phẩm muốn xoá");
//        } else {
//            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá loại sản phẩm", "Xác nhận xoá loại san phẩm", JOptionPane.YES_NO_OPTION);
//            if (output == JOptionPane.YES_OPTION) {
//                for(SanPhamDTO x : listSP) {
//                if(x.getMaloai()==getLoaiSanPhamSelect().getMaloai()) {
//                    JOptionPane.showMessageDialog(null, "Loại sản phẩm này đang được sử dụng bởi sản phẩm *"+x.getTensp()+"* nên không thể xóa!");
//                    return;
//                }
//            }
//                lspBUS.lspDAO.delete(getLoaiSanPhamSelect());
//                JOptionPane.showMessageDialog(this, "Xóa thành công !");
//                loadDataToTable(lspBUS.lspDAO.selectAll());
//            }
//        }
    }//GEN-LAST:event_btnXoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loaisanpham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loaisanpham dialog = new loaisanpham(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablelsp;
    private javax.swing.JTextField txtloaisp;
    // End of variables declaration//GEN-END:variables
}
