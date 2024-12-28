package DTO;

import java.util.Date;

/**
 *
 * @author HP
 */
public class KhuyenMaiDTO {
    private int maKM;
    private String loaiKM;
    private Date tgBatDau;
    private Date tgKetThuc;   
    private int trangThai;

    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public String getLoaiKM() {
        return loaiKM;
    }

    public void setLoaiKM(String loaiKM) {
        this.loaiKM = loaiKM;
    }

    public Date getTgBatDau() {
        return tgBatDau;
    }

    public void setTgBatDau(Date tgBatDau) {
        this.tgBatDau = tgBatDau;
    }

    public Date getTgKetThuc() {
        return tgKetThuc;
    }

    public void setTgKetThuc(Date tgKetThuc) {
        this.tgKetThuc = tgKetThuc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   

    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(int maKM, String loaiKM, Date tgBatDau, Date tgKetThuc, int trangThai) {
        this.maKM = maKM;
        this.loaiKM = loaiKM;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.trangThai = trangThai;
    }

    public String tinhTrang(){
        Date currentDate= new Date();
        String tinhTrang="";
        if (this.tgKetThuc.before(currentDate)){
            tinhTrang="Hết hạn";
        }
        else if (!this.tgBatDau.after(currentDate) && !this.tgKetThuc.before(currentDate)){
            tinhTrang="Đang khuyến mãi";
        }
        else{
            tinhTrang="Chưa bắt đầu";
        }
        return tinhTrang;
    }
    
    
    
}
