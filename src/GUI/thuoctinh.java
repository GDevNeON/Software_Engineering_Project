package GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import GUI.thuoctinhsanpham.thuonghieu;
import GUI.thuoctinhsanpham.xuatxu;
import GUI.thuoctinhsanpham.dungtich;
import GUI.thuoctinhsanpham.giamgia;

public class thuoctinh extends javax.swing.JPanel {

    /**
     *
     */
    public thuoctinh() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        btnThuonghieu = new javax.swing.JButton();
        btnLoaisanpham = new javax.swing.JButton();
        btnXuatxu = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 900));
        setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1100, 500));

        btnThuonghieu.setBackground(new java.awt.Color(153, 255, 153));
        btnThuonghieu.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnThuonghieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/brand_100px.png"))); // NOI18N
        btnThuonghieu.setText("           Thương hiệu");
        btnThuonghieu.setAlignmentX(0.5F);
        btnThuonghieu.setBorder(null);
        btnThuonghieu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThuonghieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuonghieuActionPerformed(evt);
            }
        });

        btnLoaisanpham.setBackground(new java.awt.Color(204, 204, 255));
        btnLoaisanpham.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnLoaisanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/classification (1).png"))); // NOI18N
        btnLoaisanpham.setText("Dung tích");
        btnLoaisanpham.setBorder(null);
        btnLoaisanpham.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLoaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaisanphamActionPerformed(evt);
            }
        });

        btnXuatxu.setBackground(new java.awt.Color(255, 204, 204));
        btnXuatxu.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnXuatxu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/factory_100px.png"))); // NOI18N
        btnXuatxu.setText("             Xuất xứ");
        btnXuatxu.setBorder(null);
        btnXuatxu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnXuatxu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatxuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThuonghieu, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnXuatxu, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(btnLoaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLoaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
        jPanel5.getAccessibleContext().setAccessibleName("Thuộc tính sản phẩm");
    }// </editor-fold>//GEN-END:initComponents

    private void btnThuonghieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuonghieuActionPerformed
        thuonghieu th = new thuonghieu((JFrame) SwingUtilities.getWindowAncestor(this), true);
        th.setVisible(true);


    }//GEN-LAST:event_btnThuonghieuActionPerformed

    private void btnXuatxuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatxuActionPerformed
        xuatxu xx = new xuatxu((JFrame) SwingUtilities.getWindowAncestor(this), true);
        xx.setVisible(true);
    }//GEN-LAST:event_btnXuatxuActionPerformed

    private void btnLoaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaisanphamActionPerformed
        // TODO add your handling code here:
        dungtich lsp = new dungtich((JFrame) SwingUtilities.getWindowAncestor(this), true);
        lsp.setVisible(true);
    }//GEN-LAST:event_btnLoaisanphamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoaisanpham;
    private javax.swing.JButton btnThuonghieu;
    private javax.swing.JButton btnXuatxu;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
