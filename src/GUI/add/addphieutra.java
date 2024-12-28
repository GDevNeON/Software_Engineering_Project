/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.add;

import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.PhieuTraBUS;
import BUS.SanPhamBUS;
import BUS.KhoHangBUS;
import BUS.LoHangBUS;
import BUS.NhanVienBUS;

import DTO.ChiTietPhieuTraDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.PhieuTraDTO;
import DTO.SanPhamDTO;

import DTO.NhanVienDTO;
import GUI.login;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NeON
 */
public class addphieutra extends javax.swing.JPanel {

        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        ArrayList<NhaCungCapDTO> listTenncc = new ArrayList<NhaCungCapDTO>();
        ArrayList<NhanVienDTO> listTennv = new ArrayList<NhanVienDTO>();
        KhoHangBUS khBUS = new KhoHangBUS();
        SanPhamBUS spBUS = new SanPhamBUS();
        PhieuNhapBUS pnBUS = new PhieuNhapBUS();
        PhieuTraBUS ptBUS = new PhieuTraBUS();
        NhaCungCapBUS nccBUS = new NhaCungCapBUS();
        NhanVienBUS nvBUS = new NhanVienBUS();

        int current = 0;
        String mapn;

        public addphieutra() {
                initComponents();

                // cbkvkDisplay();
                loadPhieuNhap();
                listTennv = nvBUS.nvDAO.selectAll();
                displaytoTxttennvnhap(listTennv);
                list = spBUS.spDAO.selectAll();
                // displayInfo();
                listTenncc = nccBUS.nccDAO.selectAll();
                displaytoCbtenncc(listTenncc);

                txttenncc.setEditable(false);
                txttennvnhap.setEditable(false);
                // txttenkho.setEditable(false);
                tblphieutrain.setDefaultEditor(Object.class, null);
                tblphieutraout.setDefaultEditor(Object.class, null);

        }

        private void displayInfo(String mapn) {
                this.mapn = mapn;
                PhieuNhapDTO pn = new PhieuNhapDTO();
                pn = pnBUS.getPhieuNhapById(Integer.parseInt(mapn));

                txttenncc.setText(pn.getTenncc());

                ArrayList<PhieuNhapDTO> ctpns = new ArrayList<>();
                ctpns = pnBUS.phieunhapDAO.selectAllDetailsCtpn();

                displaytoTable1(mapn, ctpns);
        }

        public void cbkvkDisplay() {
                // combomakhuvuc.addItem("Chọn khu vực kho");
                // ArrayList<String> listncc = pnBUS.phieunhapDAO.selectAllKvkCtpn();
                // int count = listncc.size();
                // for (int i = 0; i < count; i++) {
                // combomakhuvuc.addItem("" + listncc.get(i));
                // }
        }

        private void displaytoTxttennvnhap(ArrayList<NhanVienDTO> listTennv) {
                for (NhanVienDTO j : listTennv) {
                        if (login.t.getMaaccount() == j.getManv()) {
                                txttennvnhap.setText("" + j.getHoten());
                                break;
                        }
                }
        }

        private void loadPhieuNhap() {
                ArrayList<PhieuNhapDTO> phieuNhapList = pnBUS.getAll(); // Fetch the list of import invoices

                // Clear existing items in the combo box
                comboboxPhieuNhap.removeAllItems();

                // Populate the combo box with the fetched data
                for (PhieuNhapDTO pn : phieuNhapList) {
                        comboboxPhieuNhap.addItem(String.valueOf(pn.getMaphieunhap())); // Customize the display text as
                        // needed
                }
        }

        private void displaytoCbtenncc(ArrayList<NhaCungCapDTO> list) {
                // try {
                // cbtenncc.removeAllItems();
                // for (NhaCungCapDTO i : list) {
                // cbtenncc.addItem("" + i.getTenncc());
                // }
                // } catch (Exception e) {
                // System.out.println(e);
                // }
        }

        private void displaytoTable1(String mapn, ArrayList<PhieuNhapDTO> list) {
                try {
                        DefaultTableModel dt = (DefaultTableModel) tblphieutrain.getModel();
                        dt.setRowCount(0);

                        int index = 1;
                        LoHangBUS lhBUS = new LoHangBUS();
                        int soluongton;

                        for (PhieuNhapDTO i : list) {
                                if (i.getMaphieunhap() == Integer.parseInt(mapn)) {
                                        soluongton = lhBUS.lhDAO.getSoLuongTon(Integer.parseInt(mapn), i.getMasp());
                                        dt.addRow(new Object[] {
                                                        i.getMasp(), i.getTensp(), i.getSoluong(), i.getDongia(),
                                                        soluongton
                                        });
                                        index++;
                                }
                        }
                } catch (Exception e) {
                        System.out.println(e);
                }
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            jLabel11 = new javax.swing.JLabel();
            jScrollPane3 = new javax.swing.JScrollPane();
            tblphieutrain = new javax.swing.JTable();
            btnthemsp = new javax.swing.JButton();
            txttenncc = new javax.swing.JTextField();
            comboboxPhieuNhap = new javax.swing.JComboBox<>();
            jLabel6 = new javax.swing.JLabel();
            txttennvnhap = new javax.swing.JTextField();
            jLabel9 = new javax.swing.JLabel();
            btnxoasp = new javax.swing.JButton();
            jLabel2 = new javax.swing.JLabel();
            txtsoluongtra = new javax.swing.JTextField();
            jPanel6 = new javax.swing.JPanel();
            btntrahang = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            tblphieutraout = new javax.swing.JTable();
            jLabel1 = new javax.swing.JLabel();
            lblTongcong = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();

            setPreferredSize(new java.awt.Dimension(1100, 471));

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));

            jLabel11.setText("Nhà cung cấp");

            tblphieutrain.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                  },
                  new String [] {
                        "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Số lượng tồn"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            tblphieutrain.setRowHeight(50);
            tblphieutrain.setSelectionBackground(new java.awt.Color(176, 212, 235));
            tblphieutrain.setSelectionForeground(new java.awt.Color(10, 0, 0));
            jScrollPane3.setViewportView(tblphieutrain);

            btnthemsp.setBackground(new java.awt.Color(102, 204, 0));
            btnthemsp.setForeground(new java.awt.Color(255, 255, 255));
            btnthemsp.setText("Thêm sản phẩm");
            btnthemsp.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnthemspActionPerformed(evt);
                  }
            });

            txttenncc.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txttennccActionPerformed(evt);
                  }
            });
            txttenncc.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyReleased(java.awt.event.KeyEvent evt) {
                        txttennccKeyReleased(evt);
                  }
            });

            comboboxPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        comboboxPhieuNhapActionPerformed(evt);
                  }
            });

            jLabel6.setText("Phiếu nhập");

            jLabel9.setText("Nhân viên nhập");

            btnxoasp.setBackground(new java.awt.Color(184, 0, 31));
            btnxoasp.setForeground(new java.awt.Color(255, 255, 255));
            btnxoasp.setText("Xoá sản phẩm");
            btnxoasp.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnxoaspActionPerformed(evt);
                  }
            });

            jLabel2.setText("Số lượng trả");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtsoluongtra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnxoasp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
                              .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(jLabel6)
                                          .addComponent(comboboxPhieuNhap, 0, 121, Short.MAX_VALUE))
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(txttenncc, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                          .addComponent(jLabel11))
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(jLabel9)
                                          .addComponent(txttennvnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                  jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel11)
                              .addComponent(jLabel6)
                              .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(comboboxPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(txttenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(txttennvnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(btnxoasp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel2)
                              .addComponent(txtsoluongtra, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                        .addContainerGap())
            );

            jPanel6.setBackground(new java.awt.Color(255, 255, 255));

            btntrahang.setBackground(new java.awt.Color(102, 204, 0));
            btntrahang.setForeground(new java.awt.Color(255, 255, 255));
            btntrahang.setText("Trả hàng");
            btntrahang.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btntrahangActionPerformed(evt);
                  }
            });

            tblphieutraout.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
                  }
            ));
            tblphieutraout.setRowHeight(50);
            tblphieutraout.setSelectionBackground(new java.awt.Color(176, 212, 235));
            tblphieutraout.setSelectionForeground(new java.awt.Color(10, 0, 0));
            jScrollPane2.setViewportView(tblphieutraout);

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel1.setText("Tổng cộng:");

            lblTongcong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            lblTongcong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            lblTongcong.setText("0");

            jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(255, 51, 51));
            jLabel4.setText("đ");

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                  jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                              .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblTongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                    .addComponent(btntrahang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
            );
            jPanel6Layout.setVerticalGroup(
                  jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(btntrahang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(lblTongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel4)
                              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
      }// </editor-fold>//GEN-END:initComponents

        private void btnxoaspActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnxoaspActionPerformed
                DefaultTableModel pniModel = (DefaultTableModel) tblphieutrain.getModel();
                DefaultTableModel pnoModel = (DefaultTableModel) tblphieutraout.getModel();

                int selectedRow = tblphieutraout.getSelectedRow();
                if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm từ bảng 2.", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }

                Object[] rowData = new Object[4];
                for (int i = 0; i < 4; i++) {
                        rowData[i] = tblphieutraout.getValueAt(selectedRow, i);
                }

                pniModel.addRow(rowData);
                pnoModel.removeRow(selectedRow);

                updateTotal();
        }// GEN-LAST:event_btnxoaspActionPerformed

        private void updateTotal() {
                DefaultTableModel model = (DefaultTableModel) tblphieutraout.getModel();
                int rowCount = model.getRowCount();

                int totalQuantity = 0;
                long totalPrice = 0;

                for (int i = 0; i < rowCount; i++) {
                        int quantity = (int) model.getValueAt(i, 2);
                        long price = (long) model.getValueAt(i, 3);
                        totalQuantity += quantity;
                        totalPrice += quantity * price;
                }

                // System.out.println(totalPrice);
                // Cập nhật giá trị tổng cộng vào trường văn bản
                lblTongcong.setText(String.valueOf(totalPrice));
        }

        private ArrayList<NhaCungCapDTO> searchTenncc(String text) {
                ArrayList<NhaCungCapDTO> result = new ArrayList<>();
                for (NhaCungCapDTO i : listTenncc) {
                        // Tìm kiếm không phân biệt hoa thường
                        if (i.getTenncc().toLowerCase().contains(text.toLowerCase())) {
                                result.add(i);
                        }
                }
                return result;
        }

        private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnthemspActionPerformed
                // Lấy dòng được chọn từ bảng 1
                int selectedRow = tblphieutrain.getSelectedRow();
                if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm từ bảng 1.", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }

                int masp = (int) tblphieutrain.getValueAt(selectedRow, 0);

                SanPhamBUS spBUS = new SanPhamBUS();
                SanPhamDTO sanpham = spBUS.spDAO.selectById(String.valueOf(masp));

                // Lấy dữ liệu sản phẩm từ dòng được chọn
                Object[] rowData = new Object[4];
                for (int i = 0; i < 4; i++) {
                        rowData[i] = tblphieutrain.getValueAt(selectedRow, i);
                }

                int soluongtra = 0;

                if (txtsoluongtra.getText().isBlank()) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng!", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }

                try {
                        soluongtra = Integer.parseInt(txtsoluongtra.getText());
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Số lượng trả phải là số!", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }

                if (Integer.parseInt(txtsoluongtra.getText()) <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn hoặc bằng 0!", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }

                int soluongton =  (int) tblphieutrain.getValueAt(selectedRow, 4);

                if (Integer.parseInt(txtsoluongtra.getText()) > soluongton) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải nhỏ hơn số lượng tồn!", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        return;
                }

                DefaultTableModel model = (DefaultTableModel) tblphieutrain.getModel();
                // model.removeRow(selectedRow);

                model.setValueAt(soluongton - soluongtra, selectedRow, 4);

                // Thêm thông tin sản phẩm vào bảng 2
                DefaultTableModel dt2 = (DefaultTableModel) tblphieutraout.getModel();
                rowData[2] = soluongtra; // Cập nhật số lượng
                // rowData[3] = gianhap;
                // rowData[4] = giaban;
                dt2.addRow(rowData);

                // Cập nhật tổng cộng và các tính toán khác nếu cần
                updateTotal();

                // Xóa số lượng đã nhập
                txtsoluongtra.setText("");
                // txtloinhuan.setText("");
                // txtgianhap.setText("");
        }// GEN-LAST:event_btnthemspActionPerformed

        private void btntrahangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnnhaphangActionPerformed
                try {
                        PhieuNhapDTO pn = new PhieuNhapDTO();
                        pn = pnBUS.phieunhapDAO.selectById(this.mapn);

                        System.out.println(pn);
                        DefaultTableModel model = (DefaultTableModel) tblphieutraout.getModel();
                        if (model.getRowCount() <= 0) {
                                // Hiển thị thông báo chưa chọn sản phẩm
                                JOptionPane.showMessageDialog(this, "Vui lòng nhập sản phẩm!", "Thông báo",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }

                        int mapt = ptBUS.phieuTraDAO.getAutoIncrement();
                        int mapn = Integer.parseInt(this.mapn);
                        int mancc = pn.getMancc();
                        int manv = pn.getManv();
                        Date thoigian = new Date(System.currentTimeMillis());
                        java.sql.Date sqlDate = new java.sql.Date(thoigian.getTime());

                        long tongtien = Long.parseLong(lblTongcong.getText());

                        PhieuTraDTO ptAll = new PhieuTraDTO(mapt, mapn, mancc, manv, sqlDate,
                                        tongtien);
                        ptBUS.phieuTraDAO.insert(ptAll);

                        int rowCount = model.getRowCount();
                        // Lặp qua các dòng trong bảng 2 (tblphieunhapout)
                        for (int i = 0; i < rowCount; i++) {
                                // Lấy mã sản phẩm và số lượng từ bảng 2
                                int masp = (int) model.getValueAt(i, 0);
                                int soluong = (int) model.getValueAt(i, 2);
                                long dongia = (long) model.getValueAt(i, 3);

                                SanPhamDTO sp = new SanPhamDTO();
                                // sp.setSoluongton(sp.getSoluongton() + soluong);
                                LoHangBUS lhBUS = new LoHangBUS();
                                lhBUS.lhDAO.UpdateForPhieuTra(mapn, masp, soluong);

                                ChiTietPhieuTraDTO ctpt = new ChiTietPhieuTraDTO(mapt, masp, soluong,
                                                dongia);
                                ptBUS.ChiTietPhieuTraDAO.insert(ctpt);
                        }

                        // pnAll = new PhieuNhapDTO(mapn, mancc, makhuvuc, manv, sqlDate, tongtien);
                        // pnBUS.phieunhapDAO.update(pnAll);
                        // Reset bảng 2 (tblphieunhapout)
                        model.setRowCount(0);

                        // Hiển thị thông báo thành công
                        JOptionPane.showMessageDialog(this, "Trả hàng thành công!", "Thông báo",
                                        JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Cập nhật không thành công.", "Lỗi",
                                        JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(addphieutra.class.getName()).log(Level.SEVERE, "Cập nhật không thành công.",
                                        e);
                }

                // displaytoTable1(spBUS.spDAO.selectAll());
        }// GEN-LAST:event_btnnhaphangActionPerformed

        private void txttennccKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txttennccKeyReleased
                // // TODO add your handling code here:
                // String text = txttenncc.getText().trim();
                // ArrayList<NhaCungCapDTO> result = new ArrayList<>();
                // if (!text.isEmpty()) {
                // result = searchTenncc(text);
                // displaytoCbtenncc(result);
                // } else {
                // // Nếu không có gì nhập, xóa tất cả trong JComboBox
                // displaytoCbtenncc(listTenncc);
                // }
        }// GEN-LAST:event_txttennccKeyReleased

        private void comboboxPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_comboboxPhieuNhapActionPerformed
                // TODO add your handling code here:
                String selectedPhieuNhap = (String) comboboxPhieuNhap.getSelectedItem();

                if (selectedPhieuNhap != null) {
                        // System.out.println(selectedPhieuNhap);
                        // Fetch the corresponding PhieuNhapDTO based on the selected item
                        // PhieuNhapDTO selectedPhieuNhapDTO =
                        // pnBUS.phieunhapDAO.selectById(selectedPhieuNhap);
                        // System.out.println(selectedPhieuNhapDTO);
                        // Assuming you have a method to display the products related to the selected
                        // PhieuNhapDTO
                        displayInfo(selectedPhieuNhap);

                        DefaultTableModel model = (DefaultTableModel) tblphieutraout.getModel();
                        model.setRowCount(0);
                }
        }// GEN-LAST:event_comboboxPhieuNhapActionPerformed

        private void txttennccActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txttennccActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_txttennccActionPerformed

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JButton btnthemsp;
      private javax.swing.JButton btntrahang;
      private javax.swing.JButton btnxoasp;
      private javax.swing.JComboBox<String> comboboxPhieuNhap;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel11;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JLabel jLabel9;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JPanel jPanel6;
      private javax.swing.JScrollPane jScrollPane2;
      private javax.swing.JScrollPane jScrollPane3;
      private javax.swing.JLabel lblTongcong;
      private javax.swing.JTable tblphieutrain;
      private javax.swing.JTable tblphieutraout;
      private javax.swing.JTextField txtsoluongtra;
      private javax.swing.JTextField txttenncc;
      private javax.swing.JTextField txttennvnhap;
      // End of variables declaration//GEN-END:variables
}
