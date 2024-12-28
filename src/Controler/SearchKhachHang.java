/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.KhachHangDAO;
import DAO.PhieuNhapDAO;
import DTO.KhachHangDTO;
import DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author NeON
 */
public class SearchKhachHang {
    public static SearchKhachHang getInstance() {
        return new SearchKhachHang();
    }

    public ArrayList<KhachHangDTO> searchTatCa(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> list = KhachHangDAO.getInstance().selectAll();
        for (var kh : list) {
            if ((""+kh.getMaKH()).toLowerCase().contains(text.toLowerCase())
                    || kh.getHoten().toLowerCase().contains(text.toLowerCase())
                    || kh.getDiachi().toLowerCase().contains(text.toLowerCase())
                    || (""+kh.getGioitinh()).toLowerCase().contains(text.toLowerCase())
                    || (""+kh.getSdt()).toLowerCase().contains(text.toLowerCase())
                    || (""+kh.getNgaythamgia()).toLowerCase().contains(text.toLowerCase()))
                    
             {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHangDTO> searchMaKH(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> list = KhachHangDAO.getInstance().selectAll();
        for (var kh : list) {
            if ((""+kh.getMaKH()).toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHangDTO> searchTenKH(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> list = KhachHangDAO.getInstance().selectAll();
        for (var kh : list) {
            if (kh.getHoten().toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHangDTO> searchThoiGian(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> list = KhachHangDAO.getInstance().selectAll();
        for (var kh : list) {
            if ((""+kh.getNgaythamgia()).toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> searchSDT(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> list = KhachHangDAO.getInstance().selectAll();
        for (var kh : list) {
            if ((kh.getSdt()).toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }
 
    
    public ArrayList<KhachHangDTO> searchDiaChi(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> list = KhachHangDAO.getInstance().selectAll();
        for (var kh : list) {
            if ((""+kh.getDiachi()).toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangDTO> searchGioiTinh(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> list = KhachHangDAO.getInstance().selectAll();
        for (var kh : list) {
            if ((""+kh.getGioitinh()).toLowerCase().contains(text.toLowerCase())) {
                result.add(kh);
            }
        }
        return result;
    }

}
