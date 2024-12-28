/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DungTichDTO;
import config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Phan
 */
public class DungTichDAO implements DAOinterface<DungTichDTO> {

    public static DungTichDAO getInstance() {
        return new DungTichDAO();
    }

    @Override
    public int insert(DungTichDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "INSERT INTO dungtich  VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMadungtich());
            pst.setString(2, t.getTendungtich());
            pst.setInt(3, 1);
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được dung tích "
                    + t.getMadungtich(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(DungTichDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE dungtich SET  tendungtich=? WHERE madungtich=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTendungtich());
            pst.setInt(2, t.getMadungtich());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

   
   
    @Override
    public ArrayList<DungTichDTO> selectAll() {
        ArrayList<DungTichDTO> result = new ArrayList<DungTichDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM dungtich where trangthai = 1 ";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int madungtich = rs.getInt("madungtich");
                String tendungtich = rs.getString("tendungtich");
                DungTichDTO lh = new DungTichDTO(madungtich, tendungtich);
                result.add(lh);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public DungTichDTO selectById(String t) {
        DungTichDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM dungtich WHERE madungtich like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int madungtich = rs.getInt("madungtich");
                String tendungtich = rs.getString("tendungtich");

                ketQua = new DungTichDTO(madungtich, tendungtich);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public DungTichDTO selectByName(String t) {
        DungTichDTO ketQua = null;
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM dungtich WHERE tendungtich=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int madungtich = rs.getInt("madungtich");
                String tendungtich = rs.getString("tendungtich");
                ketQua = new DungTichDTO(madungtich, tendungtich);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ một cách cụ thể, ví dụ: ghi log
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'cuahangnuochoa' AND TABLE_NAME = 'dungtich'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                    //ALTER TABLE dungtich AUTO_INCREMENT = ? đặt lại chỉ số auto 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    

    @Override
    public int delete(DungTichDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "DELETE FROM dungtich WHERE madungtich=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ""+t.getMadungtich());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return ketQua;
    }
}
