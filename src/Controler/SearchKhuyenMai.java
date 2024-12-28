/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.KhachHangDAO;
import DAO.KhuyenMaiDAO;
import DAO.PhieuNhapDAO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author NeON
 */
public class SearchKhuyenMai {
    public static SearchKhuyenMai getInstance() {
        return new SearchKhuyenMai();
    }

    public ArrayList<KhuyenMaiDTO> searchTatCa(String text) {
        ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
        ArrayList<KhuyenMaiDTO> list = KhuyenMaiDAO.getInstance().selectAll();
        for (var km : list) {
            if ((""+km.getMaKM()).toLowerCase().contains(text.toLowerCase())
                    || km.getLoaiKM().toLowerCase().contains(text.toLowerCase())
                    || (""+km.getTgBatDau()).toLowerCase().contains(text.toLowerCase())
                    || (""+km.getTgKetThuc()).toLowerCase().contains(text.toLowerCase())
                    || (km.tinhTrang().toLowerCase().contains(text.toLowerCase())))                 
             {
                result.add(km);
            }
        }
        return result;
    }

    public ArrayList<KhuyenMaiDTO> searchMaKM(String text) {
        ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
        ArrayList<KhuyenMaiDTO> list = KhuyenMaiDAO.getInstance().selectAll();
        for (var km : list) {
            if ((""+km.getMaKM()).toLowerCase().contains(text.toLowerCase())) {
                result.add(km);
            }
        }
        return result;
    }

    public ArrayList<KhuyenMaiDTO> searchLoaiKM(String text) {
        ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
        ArrayList<KhuyenMaiDTO> list = KhuyenMaiDAO.getInstance().selectAll();
        for (var km : list) {
            if ((""+km.getLoaiKM()).toLowerCase().contains(text.toLowerCase())) {
                result.add(km);
            }
        }
        return result;
    }

    public ArrayList<KhuyenMaiDTO> searchTgBD(String text) {
        ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
        ArrayList<KhuyenMaiDTO> list = KhuyenMaiDAO.getInstance().selectAll();
        for (var km : list) {
            if ((""+km.getTgBatDau()).toLowerCase().contains(text.toLowerCase())) {
                result.add(km);
            }
        }
        return result;
    }
    
    public ArrayList<KhuyenMaiDTO> searchTgKT(String text) {
        ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
        ArrayList<KhuyenMaiDTO> list = KhuyenMaiDAO.getInstance().selectAll();
        for (var km : list) {
            if ((""+km.getTgKetThuc()).toLowerCase().contains(text.toLowerCase())) {
                result.add(km);
            }
        }
        return result;
    }
 
    
    public ArrayList<KhuyenMaiDTO> searchTinhTrang(String text) {
        ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
        ArrayList<KhuyenMaiDTO> list = KhuyenMaiDAO.getInstance().selectAll();
        for (var km : list) {
            if ((""+km.tinhTrang()).toLowerCase().contains(text.toLowerCase())) {
                result.add(km);
            }
        }
        return result;
    }
    
   
}
