package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.ChiTietPhieuTraDTO;
import config.JDBC;

public class ChiTietPhieuTraDAO implements DAOinterface<ChiTietPhieuTraDTO> {
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM ctphieutra WHERE maphieutra=?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ctphieutra";

    @Override
    public ChiTietPhieuTraDTO selectById(String maphieutra) {
        ChiTietPhieuTraDTO result = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {
            pst.setString(1, maphieutra);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int masp = rs.getInt("masp");
                    int soluong = rs.getInt("soluong");
                    int dongia = rs.getInt("dongia");
                    result = new ChiTietPhieuTraDTO(Integer.parseInt(maphieutra), masp, soluong, dongia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<ChiTietPhieuTraDTO> selectAll() {
        ArrayList<ChiTietPhieuTraDTO> result = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement pst = con.prepareStatement(SELECT_ALL_QUERY);
                ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int maphieutra = rs.getInt("maphieutra");
                int masp = rs.getInt("masp");
                int soluong = rs.getInt("soluong");
                int dongia = rs.getInt("dongia");
                ChiTietPhieuTraDTO chiTiet = new ChiTietPhieuTraDTO(maphieutra, masp, soluong, dongia);
                result.add(chiTiet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(ChiTietPhieuTraDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `ctphieutra`(`maphieutra`, `masp`, `soluong`, `dongia`) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieutra());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setInt(4, (int) t.getDongia());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(ChiTietPhieuTraDTO t) {
        throw new UnsupportedOperationException("Update method is not supported yet.");
    }

    @Override
    public int delete(ChiTietPhieuTraDTO t) {
        throw new UnsupportedOperationException("Delete method is not supported yet.");
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Get auto increment method is not supported yet.");
    }
}
