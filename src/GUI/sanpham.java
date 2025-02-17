/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CTKMTheoSpBUS;
import BUS.SanPhamBUS;
import BUS.ThuongHieuBUS;
import BUS.XuatXuBUS;
import BUS.DungTichBUS;
import DTO.ChiTietKMTheoSPDTO;
import BUS.CTKMTheoSpBUS;
import BUS.NhomQuyenBUS;
import Controler.SearchSanPham;
import DTO.ChiTietKMTheoSPDTO;
import javax.swing.table.DefaultTableModel;
import DTO.SanPhamDTO;
import DTO.ChiTietQuyenDTO;
import GUI.add.addsanpham;
import GUI.update.updatesanpham;
import GUI.details.dtsanpham;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class sanpham extends javax.swing.JPanel {

      private DefaultTableModel tblModel;
      ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
      ArrayList<ChiTietQuyenDTO> listct = login.t.getCtquyenaccount();
      SanPhamBUS spBUS = new SanPhamBUS();
      DungTichBUS dtBUS = new DungTichBUS();
      XuatXuBUS xxBUS = new XuatXuBUS();
      ThuongHieuBUS thBUS = new ThuongHieuBUS();
      NhomQuyenBUS nqBUS = new NhomQuyenBUS();

      public sanpham() {
            initComponents();
            list = spBUS.spDAO.selectAll();
            tablesp.setDefaultEditor(Object.class, null);
            initTable();
            loadDataToTable(list);
//        changeTextFind();
            //ẩn chức năng sửa sản phẩm
            btnSua.setVisible(true);
      }

      public final void initTable() {
            tblModel = new DefaultTableModel();
            String[] headerTbl = new String[]{"Mã sản phẩm", "Tên Sản Phẩm", "Dung tích", "Xuất xứ ", "Thương Hiệu", "Giá nhập", "Giá bán", "Giá KM", "Số lượng Tồn"};
            tblModel.setColumnIdentifiers(headerTbl);
            tablesp.setModel(tblModel);
            tablesp.getColumnModel().getColumn(0).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(1).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(2).setPreferredWidth(10);
            tablesp.getColumnModel().getColumn(3).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(4).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(4).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(4).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(4).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(4).setPreferredWidth(5);
            tablesp.getColumnModel().getColumn(5).setPreferredWidth(10);
            tablesp.getColumnModel().getColumn(5).setPreferredWidth(10);
            tablesp.getColumnModel().getColumn(6).setPreferredWidth(5);
      }

      public void loadDataToTable(ArrayList<SanPhamDTO> sp) {
            try {
                  tblModel.setRowCount(0);
                  for (SanPhamDTO i : sp) {
                        setGiaKhuyenMai(i);
                        setGiaKhuyenMai(i);
                        if (i.getTrangthai() == 1) {
                              tblModel.addRow(new Object[]{
                                    i.getMasp(), i.getTensp(), dtBUS.dtDAO.selectById(i.getDungtich() + "").getTendungtich(),
                                    i.getXuatxu().getTenxuatxu(),
                                    i.getThuonghieu().getTenthuonghieu(),
                                    i.getGianhap(), i.getGiaban(), i.getGiaKM(), i.getSoluongton()
                              });

                        }
                  }
            } catch (Exception e) {

            }
      }

      public void setGiaKhuyenMai(SanPhamDTO sp) {
            CTKMTheoSpBUS ctkmBus = new CTKMTheoSpBUS();
            ArrayList<ChiTietKMTheoSPDTO> listctkm = ctkmBus.getAll();
            Date now = new Date();
            int giaKM = sp.getGiaban();

            for (ChiTietKMTheoSPDTO ctkm : listctkm) {
                  if (!ctkm.getTgKetThuc().before(now) && ctkm.getMaSP() == sp.getMasp()) {
                        int phanTramGiam = ctkm.getPhanTramGiam();
                        giaKM = sp.getGiaban() - (sp.getGiaban() * phanTramGiam / 100);
                        break;
                  }
            }
            sp.setGiaKM(giaKM);
      }

      /**
       * This method is called from within the constructor to initialize the
       * form. WARNING: Do NOT modify this code. The content of this method is
       * always regenerated by the Form Editor.
       */
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablesp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cbxChoose = new javax.swing.JComboBox<>();
        jToolBar2 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        exportExcel = new javax.swing.JButton();
        importExcel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 700));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tablesp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablesp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablesp.setRowHeight(60);
        tablesp.setSelectionBackground(new java.awt.Color(176, 212, 235));
        tablesp.setSelectionForeground(new java.awt.Color(20, 0, 0));
        jScrollPane1.setViewportView(tablesp);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setPreferredSize(new java.awt.Dimension(1110, 90));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtSearch.setText("Nhập nội dung tìm kiếm...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cbxChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã Sản Phẩm", "Dung Tích", "Tên Sản Phẩm", "Xuất Xứ", "Thương Hiệu", "Giá", "Số Lượng Tồn", " " }));
        cbxChoose.setToolTipText("");

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setFocusable(false);
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jToolBar2.add(btnThem);

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setFocusable(false);
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setFocusable(false);
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnXoa);

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        btnView.setText("XEM CHI TIẾT");
        btnView.setFocusable(false);
        btnView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jToolBar2.add(btnView);
        jToolBar2.add(jSeparator2);

        exportExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import_excel.png"))); // NOI18N
        exportExcel.setText("XUẤT EXCEL");
        exportExcel.setFocusable(false);
        exportExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelActionPerformed(evt);
            }
        });
        jToolBar2.add(exportExcel);

        importExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        importExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import_excel.png"))); // NOI18N
        importExcel.setText("NHẬP EXCEL");
        importExcel.setFocusable(false);
        importExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importExcelActionPerformed(evt);
            }
        });
        jToolBar2.add(importExcel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(cbxChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
          if (!nqBUS.checkQuyen(listct, 7, "add")) {
                btnThem.setBackground(Color.gray);
                JOptionPane.showMessageDialog(this, "Bạn không có đủ quyền hạn để sử dụng chức năng này !");
          } else {
                addsanpham a = new addsanpham((JFrame) SwingUtilities.getWindowAncestor(this), true);
                a.setVisible(true);
                loadDataToTable(spBUS.spDAO.selectAll());
          }
    }//GEN-LAST:event_btnThemActionPerformed

      public SanPhamDTO getSanPhamSelect() {
            int i_row = tablesp.getSelectedRow();
            SanPhamDTO sp = spBUS.spDAO.selectAll().get(i_row);
            return sp;
      }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
          if (!nqBUS.checkQuyen(listct, 7, "delete")) {
                btnXoa.setBackground(Color.gray);
                JOptionPane.showMessageDialog(this, "Bạn không có đủ quyền hạn để sử dụng chức năng này !");
          } else {
                if (tablesp.getSelectedRow() == -1) {
                      JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn xoá");
                } else {
                      int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá sản phẩm", "Xác nhận xoá sản phẩm", JOptionPane.YES_NO_OPTION);
                      if (output == JOptionPane.YES_OPTION) {
                            SanPhamDTO sp = getSanPhamSelect();
                            if (sp.getSoluongton() != 0) {
                                  JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm vẫn còn hàng!");
                                  return;
                            }
                            spBUS.spDAO.delete(sp);

                            JOptionPane.showMessageDialog(this, "Xóa thành công !");
                            loadDataToTable(spBUS.spDAO.selectAll());
                      }
                }
          }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
          txtSearch.setText("");
          cbxChoose.setSelectedIndex(0);
          loadDataToTable(spBUS.spDAO.selectAll());
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
          if (!nqBUS.checkQuyen(listct, 7, "view")) {
                btnView.setBackground(Color.gray);
                JOptionPane.showMessageDialog(this, "Bạn không có đủ quyền hạn để sử dụng chức năng này !");
          } else {
                if (tablesp.getSelectedRow() == -1) {
                      JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xem");
                } else {
                      dtsanpham a = new dtsanpham(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
                      a.setVisible(true);
                }
          }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
          if (!nqBUS.checkQuyen(listct, 7, "edit")) {
                btnSua.setBackground(Color.gray);
                JOptionPane.showMessageDialog(this, "Bạn không có đủ quyền hạn để sử dụng chức năng này !");
          } else {
                if (tablesp.getSelectedRow() == -1) {
                      JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm muốn sửa");
                } else {
                      updatesanpham up = new updatesanpham(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
                      up.setVisible(true);
                }
          }
    }//GEN-LAST:event_btnSuaActionPerformed

      private void openFile(String file) {
            try {
                  File path = new File(file);
                  Desktop.getDesktop().open(path);
            } catch (IOException e) {
                  System.out.println(e);
            }
      }

    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelActionPerformed
          try {
                if (tablesp.getRowCount() > 0) {
                      JFileChooser jFileChooser = new JFileChooser();
                      jFileChooser.showSaveDialog(this);
                      File saveFile = jFileChooser.getSelectedFile();
                      if (saveFile != null) {
                            saveFile = new File(saveFile.toString() + ".xlsx");
                            Workbook wb = new XSSFWorkbook();
                            Sheet sheet = wb.createSheet("Product");

                            // Định nghĩa các cột cố định
                            String[] columnHeaders = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Dung tích", "Xuất Xứ", "Thương Hiệu", "Giá nhập", "Giá bán", "Giá KM", "Số Lượng Tồn", "Hình ảnh"};

                            // Tạo dòng đầu tiên cho các cột
                            Row headerRow = sheet.createRow(0);
                            for (int i = 0; i < columnHeaders.length; i++) {
                                  Cell cell = headerRow.createCell(i);
                                  cell.setCellValue(columnHeaders[i]);
                            }

                            String[] imageData = new String[list.size()];
                            int start = 0;
                            for (SanPhamDTO i : list) {

                                  imageData[start] = "" + i.getHinhanh();
                                  start++;
                            }

                            // Thêm dữ liệu từ bảng vào các dòng tiếp theo
                            for (int j = 0; j < Math.min(tablesp.getRowCount(), list.size()); j++) {
                                  Row row = sheet.createRow(j + 1);

                                  // Thêm dữ liệu từ bảng vào các cột
                                  for (int k = 0; k < tablesp.getColumnCount(); k++) {
                                        Cell cell = row.createCell(k);
                                        if (tablesp.getValueAt(j, k) != null) {
                                              cell.setCellValue(tablesp.getValueAt(j, k).toString());
                                        }
                                  }

                                  Cell imageCell = row.createCell(tablesp.getColumnCount());
                                  imageCell.setCellValue(imageData[j]);
                            }
                            FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                            wb.write(out);
                            wb.close();
                            out.close();
                            openFile(saveFile.toString());
                      }
                } else {
                      JOptionPane.showMessageDialog(this, "Danh sách sản phẩm trống, không thể xuất!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
          } catch (Exception e) {
                e.printStackTrace();
          }

    }//GEN-LAST:event_exportExcelActionPerformed

      public void loadDataToTableSearch(ArrayList<SanPhamDTO> result) {
            try {
                  tblModel.setRowCount(0);
                  for (SanPhamDTO i : result) {
                        if (i.getTrangthai() == 1) {
                              tblModel.addRow(new Object[]{
                                    i.getMasp(), i.getDungtich(), i.getTensp(), i.getXuatxu().getTenxuatxu(), i.getThuonghieu().getTenthuonghieu(), i.getGianhap(), i.getGiaban(), i.getSoluongton()});
                        }
                  }
            } catch (Exception e) {
            }
      }

//    public void setGiaKhuyenMai(SanPhamDTO sp) {
//    ChiTietKMTheoSPDTO ctkmSP = ctkmSPDAO.getKhuyenMaiTheoSP(sp.getMaSP());
//    if (ctkmSP != null) {
//        int giaGoc = sp.getGia(); // Giả sử `getGia()` là giá gốc
//        int phanTramGiam = ctkmSP.getPhanTramGiam();
//        int giaKM = giaGoc - (giaGoc * phanTramGiam / 100);
//        sp.setGiaKM(giaKM);
//    } else {
//        sp.setGiaKM(sp.getGia()); // Không có khuyến mãi, giá khuyến mãi là giá gốc
//    }
//}
    private void importExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importExcelActionPerformed
          File excelFile;
          FileInputStream excelFIS = null;
          BufferedInputStream excelBIS = null;
          XSSFWorkbook excelJTableImport = null;
          ArrayList<SanPhamDTO> listAccExcel = new ArrayList<SanPhamDTO>();
          JFileChooser jf = new JFileChooser();
          jf.setCurrentDirectory(new File(System.getProperty("user.dir"), "src/Excel"));
          int result = jf.showOpenDialog(null);
          jf.setDialogTitle("Open file");
          Workbook workbook = null;
          if (result == JFileChooser.APPROVE_OPTION) {
                try {
                      excelFile = jf.getSelectedFile();
                      excelFIS = new FileInputStream(excelFile);
                      excelBIS = new BufferedInputStream(excelFIS);
                      excelJTableImport = new XSSFWorkbook(excelBIS);
                      XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                      // Khởi tạo một DataFormatter

                      String outputFail = "";
                      for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                            XSSFRow excelRow = excelSheet.getRow(row);

                            int newMasp = spBUS.spDAO.getAutoIncrement();
                            String tensp = (excelRow.getCell(0)).getStringCellValue();
                            String tendungtich = excelRow.getCell(1).getStringCellValue();
                            int dungtich = dtBUS.dtDAO.selectByName(tendungtich).getMadungtich();
                            String tenxuatxu = (excelRow.getCell(2)).getStringCellValue();
                            int maxuatxu = xxBUS.xxDAO.selectByName(tenxuatxu).getMaxuatxu();
                            String tenthuonghieu = (excelRow.getCell(3)).getStringCellValue();
                            int mathuonghieu = thBUS.thDAO.selectByName(tenthuonghieu).getMathuonghieu();
                            int gianhap = (int) excelRow.getCell(4).getNumericCellValue();
                            int giaban = (int) excelRow.getCell(5).getNumericCellValue();
                            int giakm = (int) excelRow.getCell(6).getNumericCellValue();
                            int slton = (int) excelRow.getCell(7).getNumericCellValue();

                            // sp để check
                            SanPhamDTO sp = new SanPhamDTO(tensp, dungtich, maxuatxu, mathuonghieu, gianhap, giaban, giakm, slton);

                            if (!spBUS.spDAO.checkExistingData(sp)) {
                                  // sp để insert vào db
                                  sp = new SanPhamDTO(newMasp, dungtich, tensp, null, maxuatxu, mathuonghieu, gianhap, giaban, slton, 1, giakm);
                                  spBUS.add(sp);
                            } else {
                                  outputFail = outputFail + "\n" + tensp + " - " + tendungtich + " - " + tenxuatxu + " - " + tenthuonghieu;
                            }
                      }
                      // In log trùng file
                      if (!outputFail.isBlank()) {
                            System.out.println(outputFail);
                      }
                      JOptionPane.showMessageDialog(this, "File Excel đang nhập có dữ liệu trùng: \""
                              + outputFail + "\"", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                      // Xóa hết bảng sp và cập nhật lại
                      DefaultTableModel table_acc = (DefaultTableModel) tablesp.getModel();
                      table_acc.setRowCount(0);
                      loadDataToTable(spBUS.spDAO.selectAll());
                } catch (FileNotFoundException ex) {
                      JOptionPane.showMessageDialog(this, "Không tìm thấy file Excel để nhập liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                      Logger.getLogger(sanpham.class.getName()).log(Level.SEVERE, null, ex);
                      JOptionPane.showMessageDialog(this, "Luồng đọc ghi dữ liệu gặp lỗi", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException ex) {
                      JOptionPane.showMessageDialog(this, "File được chọn không phải là file .xlsx", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (java.lang.IllegalStateException ex) {
                      ex.printStackTrace();
                      JOptionPane.showMessageDialog(this, "File Excel đang nhập có chứa dữ liệu sai định dạng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (java.lang.NullPointerException ex) {
                      ex.printStackTrace();
                      JOptionPane.showMessageDialog(this, "Không tồn tại thuộc tính sản phẩm trong hệ thống, hãy kiểm tra lại dữ liệu nhập", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
          }
          for (int i = 0; i < listAccExcel.size(); i++) {

                SanPhamDTO sp = listAccExcel.get(i);
                SanPhamDTO newsp;
                newsp = new SanPhamDTO(sp.getMasp(), sp.getDungtich(), sp.getTensp(), sp.getHinhanh(), sp.getMaxuatxu(), sp.getMathuonghieu(), sp.getSoluongton(), sp.getGianhap(), sp.getGiaban(), sp.getTrangthai());

                spBUS.spDAO.insert(newsp);

          }
    }//GEN-LAST:event_importExcelActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
          String luachon = (String) cbxChoose.getSelectedItem();
          String searchContent = txtSearch.getText();
          ArrayList<SanPhamDTO> result = new ArrayList<>();
          switch (luachon) {
                case "Tất cả":
                      result = SearchSanPham.getInstance().searchTatCa(searchContent);
                      break;
                case "Mã Sản Phẩm":
                      result = SearchSanPham.getInstance().searchMaSP(searchContent);
                      break;
                case "Tên Sản Phẩm":
                      result = SearchSanPham.getInstance().searchTenSP(searchContent);
                      break;
                case "Dung Tích":
                      result = SearchSanPham.getInstance().searchDugnTich(searchContent);
                      break;
                case "Xuất Xứ":
                      result = SearchSanPham.getInstance().searchXuatxu(searchContent);
                      break;
                case "Thương Hiệu":
                      result = SearchSanPham.getInstance().searchThuongHieu(searchContent);
                      break;
                case "Số Lượng Tồn":
                      result = SearchSanPham.getInstance().searchSoluongton(searchContent);
                      break;
                case "Giá":
                      result = SearchSanPham.getInstance().searchGia(searchContent);
                      break;

          }
          loadDataToTable(result);

    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
          // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

      private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
            // TODO add your handling code here:
            if (txtSearch.getText().equals("Nhập nội dung tìm kiếm...")) {
                  txtSearch.setText("");
            }
      }//GEN-LAST:event_txtSearchFocusGained

      public JButton getBtnSua() {
            return btnSua;
      }

      public JButton getBtnThem() {
            return btnThem;
      }

      public JButton getBtnXoa() {
            return btnXoa;
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxChoose;
    private javax.swing.JButton exportExcel;
    private javax.swing.JButton importExcel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable tablesp;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
