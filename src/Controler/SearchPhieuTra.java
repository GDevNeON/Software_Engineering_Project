package Controler;

import DAO.PhieuNhapDAO;
import DAO.PhieuTraDAO;
import DTO.PhieuTraDTO;
import java.util.ArrayList;

public class SearchPhieuTra {
    public static SearchPhieuTra getInstance() {
        return new SearchPhieuTra();
    }

    public ArrayList<PhieuTraDTO> searchTatCa(String text) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
//        ArrayList<PhieuTraDTO> armt = PhieuTraDAO.getInstance().selectAll();
//        for (var pt : armt) {
//            if ((""+pt.getMaphieutra()).toLowerCase().contains(text.toLowerCase())
//                    || pt.getTenncc().toLowerCase().contains(text.toLowerCase())
//                    || pt.getTennvnhap().toLowerCase().contains(text.toLowerCase())
//                    || (""+pt.getThoigiantao()).toLowerCase().contains(text.toLowerCase())
//                    || (""+pt.getTongTien()).toLowerCase().contains(text.toLowerCase()))
//            {
//                result.add(pt);
//            }
//        }
        return result;
    }

    public ArrayList<PhieuTraDTO> searchTenNCC(String text) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
        ArrayList<PhieuTraDTO> armt = PhieuTraDAO.getInstance().selectAll();
        for (var pt : armt) {
            if (pt.getTenncc().toLowerCase().contains(text.toLowerCase())) {
                result.add(pt);
            }
        }
        return result;
    }

    public ArrayList<PhieuTraDTO> searchMaphieutra(String text) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
        ArrayList<PhieuTraDTO> armt = PhieuTraDAO.getInstance().selectAll();
        for (var pt : armt) {
            if ((""+pt.getMaphieutra()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pt);
            }
        }
        return result;
    }

    public ArrayList<PhieuTraDTO> searchTenNv(String text) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
//        ArrayList<PhieuTraDTO> armt = PhieuTraDAO.getInstance().selectAll();
//        for (var pt : armt) {
//            if (pt.getTennvnhap().toLowerCase().contains(text.toLowerCase())) {
//                result.add(pt);
//            }
//        }
        return result;
    }

    public ArrayList<PhieuTraDTO> searchTennvtra(String text) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
        ArrayList<PhieuTraDTO> armt = PhieuTraDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getTennt().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuTraDTO> searchThoigiantao(String text) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
        ArrayList<PhieuTraDTO> armt = PhieuTraDAO.getInstance().selectAll();
        for (var pt : armt) {
            if ((""+pt.getThoigiantao()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pt);
            }
        }
        return result;
    }

    public ArrayList<PhieuTraDTO> searchTongtien(String text) {
        ArrayList<PhieuTraDTO> result = new ArrayList<>();
        ArrayList<PhieuTraDTO> armt = PhieuTraDAO.getInstance().selectAll();
        for (var pt : armt) {
            if ((""+pt.getTongTien()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pt);
            }
        }
        return result;
    }
}
