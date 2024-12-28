package DAO;

import DTO.ChiTietKMTheoSPDTO;
import config.JDBC;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ChiTietKMTheoSPDAO implements DAOinterface<ChiTietKMTheoSPDTO>{

    @Override
    public int insert(ChiTietKMTheoSPDTO t) {
        int ketqua=0;
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="INSERT INTO ctkhuyenmaitheosp VALUES(?,?,?,?,?,?)";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, t.getMaKM());
            pst.setInt(2,t.getMaSP());
            java.sql.Date sqlNgayBD = new java.sql.Date(t.getTgBatDau().getTime());
            java.sql.Date sqlNgayKT = new java.sql.Date(t.getTgKetThuc().getTime());
            pst.setDate(3,sqlNgayBD);
            pst.setDate(4, sqlNgayKT);
            pst.setInt(5, t.getPhanTramGiam());
            pst.setString(6,t.getNvTao());
            ketqua=pst.executeUpdate();
            JDBC.closeConnection(con); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(ChiTietKMTheoSPDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChiTietKMTheoSPDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietKMTheoSPDTO> selectAll() {
        ArrayList<ChiTietKMTheoSPDTO> list=new ArrayList<>();
        try {
            java.sql.Connection con= JDBC.getConnection();
            String sql="SELECT * FROM ctkhuyenmaitheosp";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                int makm=rs.getInt("MaKM");
                int masp=rs.getInt("MaSP");
                Date tgbd=rs.getDate("TgBatDau");
                Date tgkt=rs.getDate("TgKetThuc");
                int phanTramGiam=rs.getInt("PhanTramGiam");
                String nvTao=rs.getString("nvTao");
                ChiTietKMTheoSPDTO ctkmDTO= new ChiTietKMTheoSPDTO(makm, masp, tgbd, tgkt, nvTao, phanTramGiam);
                list.add(ctkmDTO);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ChiTietKMTheoSPDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ChiTietKMTheoSPDTO getChiTietById(int t) {
        ChiTietKMTheoSPDTO  ctkm= new ChiTietKMTheoSPDTO();
        try {
            java.sql.Connection con= JDBC.getConnection();
            String sql="SELECT * FROM ctkhuyenmaitheosp WHERE MaKM=?";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,t );
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                ctkm.setMaKM(rs.getInt("MaKM"));
                ctkm.setMaSP(rs.getInt("MaSP"));
                ctkm.setTgBatDau(rs.getDate("TgBatDau"));
                ctkm.setTgKetThuc(rs.getDate("TgKetThuc"));
                ctkm.setPhanTramGiam(rs.getInt("PhanTramGiam"));
                ctkm.setNvTao(rs.getString("nvTao"));
            }
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctkm;
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
