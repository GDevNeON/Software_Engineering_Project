/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DungTichDTO;
import DTO.SanPhamDTO;
import DTO.ThuongHieuDTO;
import DTO.XuatXuDTO;
import config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Phan
 */
public class SanPhamDAO implements DAOinterface<SanPhamDTO> {

    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }

    @Override
    public int insert(SanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "INSERT INTO sanpham  VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMasp());
            pst.setInt(2, t.getDungtich());
            pst.setString(3, t.getTensp());
            pst.setString(4, t.getHinhanh());
            pst.setInt(5, t.getMaxuatxu());           
            pst.setInt(6, t.getMathuonghieu());
            pst.setInt(7, t.getGianhap());
            pst.setInt(8, t.getGiaban());
            pst.setInt(9, t.getSoluongton());
            pst.setInt(10, 1);
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Không thêm được sản phẩm "
                    + t.getMasp(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(SanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE sanpham SET  dungtich=?, tensp=?, hinhanh=?, xuatxu=?,thuonghieu=? WHERE masp=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getDungtich());
            pst.setString(2, t.getTensp());
            pst.setString(3, t.getHinhanh());
            pst.setInt(4, t.getMaxuatxu());           
            pst.setInt(5, t.getMathuonghieu());
            pst.setInt(6, t.getMasp());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<SanPhamDTO> selectALL() {
        ArrayList<SanPhamDTO> ketQua = new ArrayList<SanPhamDTO>();
        try (Connection con = JDBC.getConnection(); Statement s = con.createStatement(); ResultSet rs = s.executeQuery("SELECT sanpham.masp,\n"
                + "       sanpham.dungtich, \n"
                + "       sanpham.tensp, \n"
                + "       sanpham.hinhanh, \n"
                + "       sanpham.xuatxu,\n"               
                + "       sanpham.thuonghieu, \n"
                + "       ctpn.gianhap, \n"
                + "       ctpn.soluong, \n"
                + "       sanpham.trangthai,\n"               
                + "       thuonghieu.tenthuonghieu, \n"
                + "       xuatxu.tenxuatxu, \n"
                + "       xuatxu.trangthai AS xuatxuTrangThai, \n"
                + "       thuonghieu.mathuonghieu\n"
                + "FROM sanpham\n"
                + "INNER JOIN dungtich ON sanpham.madungtich = dungtich.madungtich\n"
                + "INNER JOIN thuonghieu ON sanpham.thuonghieu = thuonghieu.mathuonghieu\n"
                + "INNER JOIN xuatxu ON sanpham.xuatxu = xuatxu.maxuatxu\n"
                + "JOIN ctphieunhap ctpn ON sanpham.masp = ctpn.masp \n"
                + "WHERE sanpham.trangthai = 1 \n"
                + "AND ctpn.soluong > 0\n"
                + "ORDER BY ctpn.maphieunhap ASC, sanpham.masp;")) {

            while (rs.next()) {
                
                XuatXuDTO xx = new XuatXuDTO(rs.getInt("xuatxu"), rs.getString("tenxuatxu"));
                ThuongHieuDTO th = new ThuongHieuDTO(rs.getInt("thuonghieu"), rs.getString("tenthuonghieu"));

                SanPhamDTO sp = new SanPhamDTO();
                sp.setMasp(rs.getInt("masp"));
                sp.setDungtich(rs.getInt("dungtich"));
                sp.setTensp(rs.getString("tensp"));
                sp.setHinhanh(rs.getString("hinhanh"));               
                sp.setGianhap(rs.getInt("gianhap"));
                sp.setSoluongton(rs.getInt("soluong"));
                sp.setTrangthai(rs.getInt("trangthai"));
                
                sp.setThuonghieu(th);
                sp.setXuatxu(xx);

                ketQua.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    
    // public ArrayList<SanPhamDTO> selectAll() {
    //     ArrayList<SanPhamDTO> ketQua = new ArrayList<SanPhamDTO>();
    //     try (Connection con = JDBC.getConnection(); Statement s = con.createStatement(); ResultSet rs = s.executeQuery("SELECT sp.masp, sp.dungtich, sp.tensp, sp.hinhanh, sp.xuatxu,\n"
    //             + "      sp.thuonghieu, dt_min.giaban AS giaban, \n"
    //             + "       dt_min.gianhap AS gianhap, SUM(dt.soluong) AS soluongton, sp.trangthai, \n"
    //             + "      thuonghieu.tenthuonghieu, xuatxu.tenxuatxu, \n"
    //             + "      xuatxu.trangthai AS trangthai_xuatxu, \n"
    //             + "       thuonghieu.mathuonghieu\n"
    //             + "FROM sanpham sp\n"
    //             + "LEFT JOIN losanpham dt ON sp.masp = dt.masp\n"                
    //             + "INNER JOIN thuonghieu ON sp.thuonghieu = thuonghieu.mathuonghieu\n"
    //             + "INNER JOIN xuatxu ON sp.xuatxu = xuatxu.maxuatxu\n"
    //             + "LEFT JOIN (\n"
    //             + "    SELECT masp, gianhap, giaban\n"
    //             + "    FROM losanpham dt1\n"
    //             + "    WHERE maphieunhap = (\n"
    //             + "        SELECT MIN(maphieunhap) \n"
    //             + "        FROM losanpham \n"
    //             + "        WHERE masp = dt1.masp\n"
    //             + "    )\n"
    //             + ") AS dt_min ON sp.masp = dt_min.masp\n"
    //             + "WHERE sp.trangthai = 1\n"
    //             + "GROUP BY sp.masp, sp.dungtich, sp.tensp, sp.hinhanh, sp.xuatxu, sp.thuonghieu, sp.trangthai,\n"
    //             + "         thuonghieu.tenthuonghieu, xuatxu.tenxuatxu, xuatxu.trangthai, \n"
    //             + "         thuonghieu.mathuonghieu, dt_min.giaban, dt_min.gianhap\n"
    //             + "ORDER BY sp.masp;");) {

    //         while (rs.next()) {
              
    //             XuatXuDTO xx = new XuatXuDTO(rs.getInt("xuatxu"), rs.getString("tenxuatxu"));
    //             ThuongHieuDTO th = new ThuongHieuDTO(rs.getInt("thuonghieu"), rs.getString("tenthuonghieu"));

    //             SanPhamDTO sp = new SanPhamDTO();
    //             sp.setMasp(rs.getInt("masp"));
    //             sp.setDungtich(rs.getInt("dungtich"));
    //             sp.setTensp(rs.getString("tensp"));
    //             sp.setHinhanh(rs.getString("hinhanh"));
    //             sp.setGianhap(rs.getInt("gianhap"));
    //             sp.setGiaban(rs.getInt("giaban"));
    //             sp.setSoluongton(rs.getInt("soluongton"));
    //             sp.setTrangthai(rs.getInt("trangthai"));               
    //             sp.setThuonghieu(th);
    //             sp.setXuatxu(xx);

    //             ketQua.add(sp);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return ketQua;
//    }
    @Override
    public ArrayList<SanPhamDTO> selectAll() {
        ArrayList<SanPhamDTO> ketQua = new ArrayList<SanPhamDTO>();
        try (Connection con = JDBC.getConnection(); Statement s = con.createStatement(); ResultSet rs = s.executeQuery("SELECT sanpham.masp, sanpham.tensp, sanpham.hinhanh, sanpham.xuatxu,\n"
                + "       sanpham.thuonghieu,sanpham.dungtich, sanpham.giaban, sanpham.gianhap, sanpham.soluongton, sanpham.trangthai,\n"
                + "       dungtich.tendungtich, thuonghieu.tenthuonghieu, xuatxu.tenxuatxu, dungtich.trangthai, xuatxu.trangthai, thuonghieu.mathuonghieu\n"
                + "FROM sanpham\n"
                + "INNER JOIN dungtich ON sanpham.dungtich = dungtich.madungtich\n"
                + "INNER JOIN thuonghieu ON sanpham.thuonghieu = thuonghieu.mathuonghieu\n"
                + "INNER JOIN xuatxu ON sanpham.xuatxu = xuatxu.maxuatxu\n"
                + "WHERE sanpham.trangthai = 1\n"
                + "ORDER BY sanpham.masp;")) {

            while (rs.next()) {
                XuatXuDTO xx = new XuatXuDTO(rs.getInt("xuatxu"), rs.getString("tenxuatxu"));
                ThuongHieuDTO th = new ThuongHieuDTO(rs.getInt("thuonghieu"), rs.getString("tenthuonghieu"));

                SanPhamDTO sp = new SanPhamDTO();
                sp.setMasp(rs.getInt("masp"));
                sp.setDungtich(rs.getInt("dungtich"));
                sp.setTensp(rs.getString("tensp"));
                sp.setHinhanh(rs.getString("hinhanh"));
                sp.setGianhap(rs.getInt("gianhap"));
                sp.setGiaban(rs.getInt("giaban"));
                sp.setSoluongton(rs.getInt("soluongton"));
                sp.setTrangthai(rs.getInt("trangthai"));               
                sp.setThuonghieu(th);
                sp.setXuatxu(xx);

                ketQua.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public SanPhamDTO selectById(String t) {
        SanPhamDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM sanpham WHERE masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int masp = rs.getInt("masp");
                int dungtich = rs.getInt("dungtich");
                String tensp = rs.getString("tensp");
                String hinhanh = rs.getString("hinhanh");
                int maxuatxu = rs.getInt("xuatxu");              
                int mathuonghieu = rs.getInt("thuonghieu");
                int gianhap = rs.getInt("gianhap");
                int giaban = rs.getInt("giaban");
                int soluongton = rs.getInt("soluongton");
                int trangthai = rs.getInt("trangthai");
                ketQua = new SanPhamDTO(masp, dungtich, tensp, hinhanh, maxuatxu, mathuonghieu, soluongton, gianhap, giaban, trangthai);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public SanPhamDTO selectByTenSP(String t) {
        SanPhamDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM sanpham WHERE tensp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int masp = rs.getInt("masp");
                int dungtich = rs.getInt("dungtich");
                String tensp = rs.getString("tensp");
                String hinhanh = rs.getString("hinhanh");
                int maxuatxu = rs.getInt("xuatxu");              
                int mathuonghieu = rs.getInt("thuonghieu");
                int gianhap = rs.getInt("gianhap");
                int giaban = rs.getInt("giaban");
                int soluongton = rs.getInt("soluongton");
                int trangthai = rs.getInt("trangthai");
                ketQua = new SanPhamDTO(masp, dungtich, tensp, hinhanh, maxuatxu, mathuonghieu, soluongton, gianhap, giaban, trangthai);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    } 

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'cuahangnuochoa' AND TABLE_NAME = 'sanpham'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(SanPhamDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "Update sanpham set `trangthai` = 0 WHERE masp = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getMasp());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateQuantity(SanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE sanpham SET soluongton = ? WHERE masp = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoluongton());
            pst.setInt(2, t.getMasp());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public boolean checkExistingData(SanPhamDTO t) {
            SanPhamDTO result = null;
            try {
                  Connection con = (Connection) JDBC.getConnection();
                  String sql = "SELECT * from sanpham WHERE tensp=? AND dungtich=? AND xuatxu=? AND thuonghieu=?";
                  PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                  pst.setString(1, t.getTensp());
                  pst.setInt(2, t.getDungtich());
                  pst.setInt(3, t.getMaxuatxu());
                  pst.setInt(4, t.getMathuonghieu());
                  ResultSet rs = (ResultSet) pst.executeQuery();
                  while (rs.next()) {
                        String tensp = rs.getString("tensp");
                        int dungtich = rs.getInt("dungtich");
                        int maxuatxu = rs.getInt("xuatxu");
                        int thuonghieu = rs.getInt("thuonghieu");
                        result = new SanPhamDTO(tensp, dungtich, maxuatxu, thuonghieu, 0, 0, 0, 0);
                  }
                  JDBC.closeConnection(con);
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return result != null;  //tồn tại
      }
}
