package DTO;

import java.util.Date;

/**
 *
 * @author HP
 */
public class ChiTietKMTheoHDDTO {
    private int maKM;
    private String tenCTKM;
    private String nvTao;
    private Date tgBatDau;
    private Date tgKetThuc;
    private int phanTramGiam;
    private float dkHoaDon;

    public ChiTietKMTheoHDDTO() {
    }

    public ChiTietKMTheoHDDTO(int maKM, String tenCTKM, String nvTao, Date tgBatDau, Date tgKetThuc, int phanTramGiam, float dkHoaDon) {
        this.maKM = maKM;
        this.tenCTKM = tenCTKM;
        this.nvTao = nvTao;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.phanTramGiam = phanTramGiam;
        this.dkHoaDon = dkHoaDon;
    }

    

    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public String getTenCTKM() {
        return tenCTKM;
    }

    public void setTenCTKM(String tenCTKM) {
        this.tenCTKM = tenCTKM;
    }

    public String getNvTao() {
        return nvTao;
    }

    public void setNvTao(String nvTao) {
        this.nvTao = nvTao;
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

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public float getDkHoaDon() {
        return dkHoaDon;
    }

    public void setDkHoaDon(float dkHoaDon) {
        this.dkHoaDon = dkHoaDon;
    }
    
    
    
}
