package DAO;

import java.util.ArrayList;
import DTO.ChiTietKMTheoHDDTO;

import config.JDBC;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class ChiTietKMTheoHDDAO implements DAOinterface<ChiTietKMTheoHDDTO>{

    @Override
    public int insert(ChiTietKMTheoHDDTO t) {
        int ketqua=0;
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="INSERT INTO ctkhuyenmaitheohd VALUES(?,?,?,?,?,?,?)";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, t.getMaKM());
            pst.setString(2,t.getTenCTKM());
            java.sql.Date sqlNgayBD = new java.sql.Date(t.getTgBatDau().getTime());
            java.sql.Date sqlNgayKT = new java.sql.Date(t.getTgKetThuc().getTime());
            pst.setDate(3,sqlNgayBD);
            pst.setDate(4, sqlNgayKT);
            pst.setInt(5, t.getPhanTramGiam());
            pst.setString(6,t.getNvTao());
            pst.setFloat(7, t.getDkHoaDon());
            ketqua=pst.executeUpdate();
            JDBC.closeConnection(con);        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(ChiTietKMTheoHDDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChiTietKMTheoHDDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietKMTheoHDDTO> selectAll() {
        ArrayList<ChiTietKMTheoHDDTO> list=new ArrayList<>();
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="SELECT * FROM ctkhuyenmaitheohd";
            java.sql.PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int maKm=rs.getInt("MaKM");
                String tenCT=rs.getString("CTKM");
                Date tgbd=rs.getDate("TgBatDau");
                Date tgkt=rs.getDate("TgKetThuc");
                int phanTramGiam=rs.getInt("PhanTramGiam");
                String nvTao=rs.getString("nvTao");
                Float dkHoaDon=rs.getFloat("ĐKHD");
                ChiTietKMTheoHDDTO ctkm=new ChiTietKMTheoHDDTO(maKm, tenCT, nvTao, tgbd, tgkt, phanTramGiam,dkHoaDon);
                list.add(ctkm);
            }
            JDBC.closeConnection(con);           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChiTietKMTheoHDDTO getChiTietById(int maKM) {
       ChiTietKMTheoHDDTO ctkm=new ChiTietKMTheoHDDTO();
        try {
            java.sql.Connection con=JDBC.getConnection();
            String sql="SELECT * FROM ctkhuyenmaitheohd ctkm WHERE ctkm.MaKM=?";
            java.sql.PreparedStatement pst= con.prepareStatement(sql);
            pst.setInt(1, maKM);
            ResultSet rs=pst.executeQuery();
            if (rs.next()) {           
            ctkm.setMaKM(rs.getInt("MaKM"));
            ctkm.setTenCTKM(rs.getString("CTKM")); 
            ctkm.setTgBatDau(rs.getDate("TgBatDau")); 
            ctkm.setTgKetThuc(rs.getDate("TgKetThuc")); 
            ctkm.setDkHoaDon(rs.getFloat("ĐKHD")); 
            ctkm.setNvTao(rs.getString("nvTao")); 
            ctkm.setPhanTramGiam(rs.getInt("PhanTramGiam"));
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

    @Override
    public ChiTietKMTheoHDDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}