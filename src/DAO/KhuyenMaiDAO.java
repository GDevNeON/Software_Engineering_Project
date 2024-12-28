package DAO;

import DTO.KhuyenMaiDTO;
import com.mysql.cj.xdevapi.Result;

import config.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class KhuyenMaiDAO implements DAOinterface<KhuyenMaiDTO>{

    public static KhuyenMaiDAO getInstance() {
        return new KhuyenMaiDAO();
    }
    @Override
    public int insert(KhuyenMaiDTO t) {
        int ketqua=0;
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="INSERT INTO khuyenmai VALUES(?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, t.getMaKM());
            pst.setString(2, t.getLoaiKM());
            java.sql.Date sqlNgayBD = new java.sql.Date(t.getTgBatDau().getTime());
            java.sql.Date sqlNgayKT = new java.sql.Date(t.getTgKetThuc().getTime());
            pst.setDate(3,sqlNgayBD);
            pst.setDate(4, sqlNgayKT);            
            pst.setInt(5,1);
            ketqua=pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không  thêm được mã khuyến mãi"+t.getMaKM(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(KhuyenMaiDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(KhuyenMaiDTO t) {
        int result = 0;
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql = "UPDATE khuyenmai SET TrangThai= 0 WHERE MaKM = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaKM());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<KhuyenMaiDTO> selectAll() {
        ArrayList<KhuyenMaiDTO> list=new ArrayList<>();
        try {
            java.sql.Connection con= JDBC.getConnection();                      
            String sql="SELECT * FROM khuyenmai WHERE TrangThai=1";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()){
                int maKM=rs.getInt("MaKM");
                String loaiKM=rs.getString("LoaiKM");
                Date tgBD=rs.getDate("TgBatDau");
                Date tgKT=rs.getDate("TgKetThuc");               
                int trangThai=rs.getInt("TrangThai");
                KhuyenMaiDTO km=new KhuyenMaiDTO(maKM, loaiKM, tgBD, tgKT, trangThai);
                list.add(km);
            }
            System.out.println(list.size());
            for (KhuyenMaiDTO km : list) {
                
                System.out.println(km.toString()); // Hoặc in từng thuộc tính nếu bạn muốn
            }
            JDBC.closeConnection(con);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public KhuyenMaiDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        KhuyenMaiDTO kmDTO=null;
//        try {
//            java.sql.Connection con=JDBC.getConnection();
//            String sql="SELECT * FROM khuyenmai km WHERE km.MaKM=?";
//            PreparedStatement pst=con.prepareStatement(sql);
//            pst.setInt(1, t);
//            ResultSet rs=pst.executeQuery();
//            if(rs.next()){
//                int maKm=rs.getInt("MaKM");
//                String loaiKM=rs.getString("LoaiKM");
//                Date tgBD=rs.getDate("TgBatDau");
//                Date tgKT=rs.getDate("TgKetThuc");
//                int phanTramGiam=rs.getInt("PhanTramGiam");
//                int trangThai=rs.getInt("TrangThai");
//                
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return kmDTO;
    }
    
    public KhuyenMaiDTO getKMByID(int t){
        KhuyenMaiDTO kmDTO=null;
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="SELECT * FROM khuyenmai km WHERE km.MaKM=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, t);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                int maKm=rs.getInt("MaKM");
                String loaiKM=rs.getString("LoaiKM");
                Date tgBD=rs.getDate("TgBatDau");
                Date tgKT=rs.getDate("TgKetThuc");               
                int trangThai=rs.getInt("TrangThai");
                kmDTO= new KhuyenMaiDTO(maKm, loaiKM, tgBD, tgKT, trangThai);
            }
            rs.close(); 
            pst.close(); 
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return kmDTO;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'cuahangnuochoa' AND TABLE_NAME   = 'khuyenmai'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            java.sql.ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean isOverLapKMHD(Date ngayBD, Date ngayKT){
        boolean isOverlap=false;
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="SELECT * FROM khuyenmai WHERE (TgBatDau <= ? AND TgKetThuc >= ? AND LoaiKM LIKE N'Theo hóa đơn' AND TgKetThuc >= CURRENT_DATE)";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            java.sql.Date sqlNgayBD = new java.sql.Date(ngayBD.getTime());
            java.sql.Date sqlNgayKT = new java.sql.Date(ngayKT.getTime());
            pst.setDate(1, sqlNgayKT);
            pst.setDate(2, sqlNgayBD);
            ResultSet rs=pst.executeQuery();
            isOverlap=rs.next();
            rs.close();
            pst.close();
            JDBC.closeConnection(con);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOverlap;
    }
    public boolean isOverLapKMSP(Date ngayBD, Date ngayKT){
        boolean isOverlap=false;
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="SELECT * FROM ctkhuyenmaitheosp WHERE (TgBatDau <= ? AND TgKetThuc >= ?  AND TgKetThuc >= CURRENT_DATE)";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
           java.sql.Date sqlNgayBD = new java.sql.Date(ngayBD.getTime());
            java.sql.Date sqlNgayKT = new java.sql.Date(ngayKT.getTime());
            pst.setDate(1, sqlNgayKT);
            pst.setDate(2, sqlNgayBD);
            ResultSet rs=pst.executeQuery();
            isOverlap=rs.next();
            rs.close();
            pst.close();
            JDBC.closeConnection(con);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOverlap;
    }
    
}
