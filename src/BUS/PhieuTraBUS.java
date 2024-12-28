package BUS;

import DAO.PhieuTraDAO;
import DAO.ChiTietPhieuTraDAO;
import DTO.ChiTietPhieuTraDTO;
import DTO.PhieuTraDTO;
import java.util.ArrayList;

public class PhieuTraBUS {
    public final PhieuTraDAO phieuTraDAO;
    public final ChiTietPhieuTraDAO ChiTietPhieuTraDAO;

    public PhieuTraBUS() {
        this.phieuTraDAO = new PhieuTraDAO();
        this.ChiTietPhieuTraDAO = new ChiTietPhieuTraDAO();
    }

    // Add this getter method
    public PhieuTraDAO getPhieuTraDAO() {
        return phieuTraDAO;
    }

    public void addPhieuTra(PhieuTraDTO phieuTra) {
        phieuTraDAO.insert(phieuTra);
    }

    public void updatePhieuTra(PhieuTraDTO phieuTra) {
        phieuTraDAO.update(phieuTra);
    }

    public void deletePhieuTra(int maPhieuTra) {
        phieuTraDAO.delete(maPhieuTra);
    }

    public ArrayList<PhieuTraDTO> getAllPhieuTra() {
        return phieuTraDAO.selectAll();
    }
    
    public ArrayList<ChiTietPhieuTraDTO> getAllCtpt(String mapt) {
        return phieuTraDAO.selectAllCtpt(mapt);
    }

    public PhieuTraDTO getPhieuTraByMaPhieuTra(int maPhieuTra) {
        return phieuTraDAO.selectById(String.valueOf(maPhieuTra));
    }
}
