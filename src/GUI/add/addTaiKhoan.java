package GUI.add;

import BUS.TaiKhoanBUS;
import DAO.NhanVienDAO;
import DAO.NhomQuyenDAO;
import DAO.TaiKhoanDAO;
import DTO.NhanVienDTO;
import DTO.NhomQuyenDTO;
import DTO.TaiKhoanDTO;
import GUI.login;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author babib
 */
public class addTaiKhoan extends javax.swing.JDialog {

      private TaiKhoanBUS tkbus = new TaiKhoanBUS();

      public addTaiKhoan(javax.swing.JFrame parent, boolean modal) {
            super(parent, modal);
            setModal(modal);
            initComponents();
            settkcbx();
            setnhcbx();
            cbxnh.setSelectedIndex(0);
            setLocationRelativeTo(null);
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        cbxnh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxtk = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(78, 158, 209));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÊM TÀI KHOẢN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(84, 84, 84))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Huỷ");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Mật Khẩu");

        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        cbxnh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxnh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Vai trò");

        cbxtk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Mã Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxtk, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxnh, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxtk, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxnh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton1MouseClicked
            try {
                  String MANV = cbxtk.getSelectedItem().toString();
                  int manv = Integer.parseInt(MANV);
                  String matkhau = txtpassword.getText();
                  String selectedValue = cbxnh.getSelectedItem().toString();
                  int manhomquyen = NhomQuyenDAO.getInstance().selectByName(selectedValue).getManhomquyen();

                  if (matkhau.equals("") || manhomquyen == 0) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Cảnh báo ",
                                JOptionPane.WARNING_MESSAGE);
                  } else if (tkbus.checkPasswordLength(matkhau)) {
                        JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 6 đến 30 kí tự !", "Cảnh báo ",
                                JOptionPane.WARNING_MESSAGE);
                  } else {
                        if ((selectedValue.equalsIgnoreCase("admin") || selectedValue.equalsIgnoreCase("Quản lí") || selectedValue.equalsIgnoreCase("Quản lý"))
                                && !login.t.getTennhomquyenaccount().equalsIgnoreCase("admin")) {
                              JOptionPane.showMessageDialog(this, "Không được phép thêm quyền của quản lý !", "Cảnh báo",
                                      JOptionPane.WARNING_MESSAGE);
                        } else {
                              // Kiểm tra xem tên đăng nhập đã tồn tại trong cơ sở dữ liệu hay chưa
                              TaiKhoanDTO existingAccount = TaiKhoanDAO.getInstance().selectById(MANV);
                              if (existingAccount != null) {
                                    JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại !", "Cảnh báo",
                                            JOptionPane.WARNING_MESSAGE);
                              } else {
                                    // Tiếp tục xử lý thêm tài khoản mới
                                    TaiKhoanDTO tk = new TaiKhoanDTO(manv, matkhau, manhomquyen, 1);

                                    // TaiKhoanDAO.getInstance().insert(tk);
                                    tkbus.add(tk);
                                    this.dispose();

                                    JOptionPane.showMessageDialog(this, "Thêm thành công !");
                              }
                        }
                  }
            } catch (NullPointerException e) {
                  JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !", "Cảnh báo ",
                          JOptionPane.WARNING_MESSAGE);
            }
      }// GEN-LAST:event_jButton1MouseClicked

      public final void settkcbx() {
            ArrayList<NhanVienDTO> listNv = NhanVienDAO.getInstance().selectAll();
            ArrayList<TaiKhoanDTO> listTaiKhoan = tkbus.getTaiKhoanAll();
            if (listNv != null) {
                  for (NhanVienDTO nv : listNv) {
                        int check = 1;
                        for (TaiKhoanDTO tk : listTaiKhoan) {
                              if (tk.getManv() == nv.getManv() || tk.getManv() == 5) {
                                    check = 0;
                              }
                        }
                        if (check == 1) {
                              cbxtk.addItem(nv.getManv() + "");
                        }
                  }
            } else {
                  System.out.println("Lỗi");
            }
      }

      public final void setnhcbx() {
            ArrayList<NhomQuyenDTO> listNq = NhomQuyenDAO.getInstance().selectAll();
            cbxnh.removeAll();
            if (listNq != null) {
                  for (NhomQuyenDTO nq : listNq) {
                        if (!login.t.getTennhomquyenaccount().equalsIgnoreCase("admin")
                                && (!login.t.getTennhomquyenaccount().equalsIgnoreCase("Quản lý")
                                || !login.t.getTennhomquyenaccount().equalsIgnoreCase("Quản lí"))) {
                              if (!nq.getTennhomquyen().equalsIgnoreCase("admin")
                                      && (!nq.getTennhomquyen().equalsIgnoreCase("Quản lý")
                                      || !nq.getTennhomquyen().equalsIgnoreCase("Quản lí"))) {
                                    cbxnh.addItem(nq.getTennhomquyen() + "");
                              }
                        } else {
                              cbxnh.addItem(nq.getTennhomquyen() + "");
                        }
                  }
            } else {
                  System.out.println("Lỗi");
            }
      }

      private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

      }// GEN-LAST:event_jButton1ActionPerformed

      private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
            // TODO add your handling code here:
            this.dispose();
      }// GEN-LAST:event_jButton2ActionPerformed

      private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtpasswordActionPerformed
            // TODO add your handling code here:

      }// GEN-LAST:event_txtpasswordActionPerformed

      private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtusernameActionPerformed
            // TODO add your handling code here:
      }// GEN-LAST:event_txtusernameActionPerformed

      public static boolean isValidEmail(String email) {
            String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            return email.matches(regex);
      }

      /**
       * @param args the command line arguments
       */
      public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
            // (optional) ">
            /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
                              break;
                        }
                  }
            } catch (ClassNotFoundException ex) {
                  java.util.logging.Logger.getLogger(addTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null,
                          ex);
            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(addTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null,
                          ex);
            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(addTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null,
                          ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(addTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null,
                          ex);
            }
            // </editor-fold>

            /* Create and display the dialog */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        addTaiKhoan dialog = new addTaiKhoan(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbxnh;
    private javax.swing.JComboBox<String> cbxtk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables

}
