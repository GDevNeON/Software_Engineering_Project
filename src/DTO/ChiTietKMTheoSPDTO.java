package DTO;

import java.util.Date;

/**
 *
 * @author HP
 */
public class ChiTietKMTheoSPDTO {
    private int maKM;
    private int maSP;
    private Date tgBatDau;
    private Date tgKetThuc;
    private String nvTao;
    private int phanTramGiam;

    public ChiTietKMTheoSPDTO() {
    }

    public ChiTietKMTheoSPDTO(int maKM, int maSP, Date tgBatDau, Date tgKetThuc, String nvTao, int phanTramGiam) {
        this.maKM = maKM;
        this.maSP = maSP;
        this.tgBatDau = tgBatDau;
        this.tgKetThuc = tgKetThuc;
        this.nvTao = nvTao;
        this.phanTramGiam = phanTramGiam;
    }

    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
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

    public String getNvTao() {
        return nvTao;
    }

    public void setNvTao(String nvTao) {
        this.nvTao = nvTao;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
    
    
}
