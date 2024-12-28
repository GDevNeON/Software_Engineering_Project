package BUS;

import DAO.KhachHangDAO;
import DAO.KhuyenMaiDAO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author HP
 */
public class KhuyenMaiBUS {
    public final KhuyenMaiDAO kmDAO= new KhuyenMaiDAO();
    private ArrayList<KhuyenMaiDTO> listKM= new ArrayList<KhuyenMaiDTO>();

    public KhuyenMaiBUS() {
        listKM=kmDAO.selectAll();
    }
    public ArrayList<KhuyenMaiDTO> getAll() {
        return this.listKM;
    }
    public boolean insert(KhuyenMaiDTO km){
        boolean check=kmDAO.insert(km)!=0;
        if (check){
            this.listKM.add(km);
        }
        return check;
    }
    
    public ArrayList<KhuyenMaiDTO> searchTatCa(String text) {
        ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
        ArrayList<KhuyenMaiDTO> armt = KhuyenMaiDAO.getInstance().selectAll();
        for (var km : armt) {
            if ((""+km.getMaKM()).toLowerCase().contains(text.toLowerCase())
                    || km.getLoaiKM().toLowerCase().contains(text.toLowerCase()))
             {
                result.add(km);
            }
        }
        return result;
    }
    
    public ArrayList<KhuyenMaiDTO> fillerPhieuNhap(Date time_s, Date time_e) {
    // Convert input dates to Timestamps
    Timestamp time_start = new Timestamp(time_s.getTime());
    
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(time_e);
    // Set time to the end of the day
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    
    Timestamp time_end = new Timestamp(calendar.getTimeInMillis());

    ArrayList<KhuyenMaiDTO> result = new ArrayList<>();
    
    for (KhuyenMaiDTO  km: getAll()) {
        Timestamp tgBD =new Timestamp(km.getTgBatDau().getTime()) ;
        Timestamp tgKT =new Timestamp(km.getTgKetThuc().getTime()) ;
        
        // Check if the date range of `phieuNhap` overlaps with the search range
          if ((tgBD.compareTo(time_end) <= 0 && tgKT.compareTo(time_start) >= 0) ||
            (tgBD.before(time_start) && tgKT.after(time_end))) {
            result.add(km);
        }
    }

    return result;
}
//    public boolean delete(int maKM){
//        kmDAO.getAutoIncrement();
//        if (km.getTrangThai()!=0){
//            km.setTrangThai(0);
//        }
//        return true;
//    }
    
}
