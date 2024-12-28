package BUS;

import DAO.ChiTietKMTheoHDDAO;
import DAO.ChiTietKMTheoSPDAO;
import DTO.ChiTietKMTheoHDDTO;
import DTO.ChiTietKMTheoSPDTO;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class CTKMTheoSpBUS {
    public final ChiTietKMTheoSPDAO ctDao=new ChiTietKMTheoSPDAO();
    ArrayList<ChiTietKMTheoSPDTO> list=new ArrayList<>();

    public CTKMTheoSpBUS() {
        list=ctDao.selectAll();
    }
    
    public ArrayList<ChiTietKMTheoSPDTO> getAll(){
        return this.list;
    }
    public boolean insert(ChiTietKMTheoSPDTO t){
        boolean check=ctDao.insert(t)!=0;
        if (check){
            this.list.add(t);
        }
        return check;
    }
}
