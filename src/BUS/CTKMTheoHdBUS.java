package BUS;

import DAO.ChiTietKMTheoHDDAO;
import DTO.ChiTietKMTheoHDDTO;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class CTKMTheoHdBUS {
    public final ChiTietKMTheoHDDAO ctDao=new ChiTietKMTheoHDDAO();
    ArrayList<ChiTietKMTheoHDDTO> list=new ArrayList<>();

    public CTKMTheoHdBUS() {
        list=ctDao.selectAll();
    }
    
    public ArrayList<ChiTietKMTheoHDDTO> getAll(){
        return this.list;
    }
    public boolean insert(ChiTietKMTheoHDDTO t){
        boolean check=ctDao.insert(t)!=0;
        if (check){
            this.list.add(t);
        }
        return check;
    }
    
    public boolean checkGiaDKHD(float gia) {
          return (gia >= 1 && gia <= 1000000);
    }
    
    public boolean checkPhanTramGiam(int pt) {
          return (pt >= 1 && pt <= 100);
    }
}
