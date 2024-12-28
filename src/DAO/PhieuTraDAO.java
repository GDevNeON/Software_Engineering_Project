package DAO;

import DTO.ChiTietPhieuTraDTO;
import DTO.PhieuNhapDTO;
import DTO.PhieuTraDTO;
import config.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Nhat Sinh
 */
public class PhieuTraDAO implements DAOinterface<PhieuTraDTO> {

    public static PhieuTraDAO getInstance() {
        return new PhieuTraDAO();
    }

    @Override
    public int insert(PhieuTraDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `phieutra`(`maphieutra`, `maphieunhap`, `manhacungcap`, `manguoitao`,`thoigiantao`, `tongtien`, `trangthai`) VALUES (?,?,?,?,?,?,1)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieutra());
            pst.setInt(2, t.getMaphieunhap());
            pst.setInt(3, t.getManhacungcap());
            pst.setInt(4, t.getManguoitao());
            pst.setDate(5, t.getThoigiantao());
            pst.setLong(6, t.getTongTien());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(PhieuTraDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `phieutra` SET `manhacungcap`=?, `thoigiantao`=?, `tongtien`=?, `trangthai`=?, `maphieunhap`=?, `lydo`=? WHERE `maphieutra`=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getManhacungcap());
            pst.setDate(2, t.getThoigiantao());
            pst.setLong(3, t.getTongTien());
            pst.setInt(4, t.getTrangthai());
            pst.setInt(5, t.getMaphieunhap());
            pst.setString(6, t.getLydo());
            pst.setInt(7, t.getMaphieutra());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int delete(int mapt) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE phieutra SET trangthai = 0 WHERE maphieutra = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, mapt);
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(PhieuTraDTO t) {
        return delete(t.getMaphieutra()); // Assuming maphieutra is the identifier
    }

    @Override
    public ArrayList<PhieuTraDTO> selectAll() {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT phieutra.*, nhacungcap.tenncc, nhanvien.hoten AS tennt FROM phieutra JOIN nhacungcap ON phieutra.manhacungcap = nhacungcap.mancc JOIN nhanvien ON phieutra.manguoitao = nhanvien.manv";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) { // Check if ResultSet is empty
                System.out.println("No data returned from the query.");
            }

            while (rs.next()) {
                int maphieutra = rs.getInt("maphieutra");
                int maphieunhap = rs.getInt("maphieunhap");
                int manhacungcap = rs.getInt("manhacungcap");
                int manguoitao = rs.getInt("manguoitao");
                Date thoigiantao = rs.getDate("thoigiantao");
                long tongtien = rs.getLong("tongtien");
                String lydo = "";
                int trangthai = rs.getInt("trangthai");
                String tenncc = rs.getString("tenncc");
                String tennt = rs.getString("tennt");
                PhieuTraDTO phieutra = new PhieuTraDTO(maphieutra, maphieunhap, manhacungcap, tenncc, manguoitao, tennt, thoigiantao,
                        lydo, tongtien,
                        trangthai);
                result.add(phieutra);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public PhieuTraDTO selectById(String t) {
        PhieuTraDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT phieutra.*, nhacungcap.tenncc, nhanvien.hoten AS tennt "
                    + "FROM phieutra "
                    + "JOIN nhacungcap ON phieutra.manhacungcap = nhacungcap.mancc "
                    + "JOIN nhanvien ON phieutra.manguoitao = nhanvien.manv "
                    + "WHERE maphieutra=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maphieutra = rs.getInt("maphieutra");
                int maphieunhap = rs.getInt("maphieunhap");
                int manhacungcap = rs.getInt("manhacungcap");
                String tenncc = rs.getString("tenncc");
                String tennt = rs.getString("tennt");
                int manguoitao = rs.getInt("manguoitao");
                Date thoigiantao = rs.getDate("thoigiantao");
                long tongtien = rs.getLong("tongtien");
                int trangthai = rs.getInt("trangthai");

                result = new PhieuTraDTO(maphieutra, maphieunhap, manhacungcap, tenncc, manguoitao, tennt, thoigiantao, "", tongtien, trangthai);
            }
            JDBC.closeConnection(con);
        } catch (SQLException | NullPointerException e) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public ArrayList<String> selectAllNcc() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT DISTINCT ncc.tenncc AS ten_nhacungcap FROM phieutra pt JOIN nhacungcap ncc ON pt.manhacungcap = ncc.mancc";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("ten_nhacungcap");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }

    public ArrayList<String> selectAllHoten() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT DISTINCT nv.hoten AS ten_nhanvien FROM phieutra pt JOIN nhanvien nv ON pt.manguoitao = nv.manv";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("ten_nhanvien");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }

    public ArrayList<ChiTietPhieuTraDTO> selectAllCtpt(String mapt) {
        ArrayList<ChiTietPhieuTraDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT *, sanpham.tensp FROM ctphieutra JOIN sanpham ON ctphieutra.masp = sanpham.masp WHERE maphieutra=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, mapt);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieutra");
                int masp = rs.getInt("masp");
                String tensp = rs.getString("tensp");
                int sl = rs.getInt("soluong");
                long dongia = rs.getLong("dongia");
                ChiTietPhieuTraDTO chitietphieutra = new ChiTietPhieuTraDTO(maphieu, masp, tensp, sl, dongia);
                result.add(chitietphieutra);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }

    public int deletePhieu(int t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "DELETE FROM `phieutra` WHERE maphieutra = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t);
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ArrayList<PhieuTraDTO> selectAllofNCC(int makh) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM phieutra WHERE manhacungcap=? ORDER BY maphieutra DESC";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, makh);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maphieutra = rs.getInt("maphieutra");
                int maphieunhap = rs.getInt("maphieunhap");
                int manhacungcap = rs.getInt("manhacungcap");
                int manguoitao = rs.getInt("manguoitao");
                Date thoigiantao = rs.getDate("thoigiantao");
                long tongtien = rs.getLong("tongtien");
                String lydo = rs.getString("lydo");
                int trangthai = rs.getInt("trangthai");

                PhieuTraDTO phieutra = new PhieuTraDTO(maphieutra, maphieunhap, manhacungcap, manguoitao, thoigiantao,
                        lydo, tongtien,
                        trangthai);

                result.add(phieutra);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public int getAutoIncrement() {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT MAX(maphieutra) FROM phieutra";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
