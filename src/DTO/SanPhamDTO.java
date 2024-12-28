/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.DungTichDAO;
import DAO.LoaiSanPhamDAO;
import DAO.ThuongHieuDAO;
import DAO.XuatXuDAO;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bao Phan
 */
public class SanPhamDTO {

    ThuongHieuDAO thuongHieuDAO = new ThuongHieuDAO();
    XuatXuDAO xuatXuDAO = new XuatXuDAO();
    DungTichDAO dungtichDAO = new DungTichDAO();

    private int masp;
    private String tensp;
    private int dungtich;
    private String hinhanh;
    private XuatXuDTO xuatxu = new XuatXuDTO();
    private int maxuatxu;   
    private ThuongHieuDTO thuonghieu = new ThuongHieuDTO();
    private int mathuonghieu;
    private int gianhap;
    private int giaban;
    private int giaKM;
    private int soluongton;
    private int trangthai;

    public SanPhamDTO() {

    }

    public SanPhamDTO(int masp, int dungtich, String tensp, String hinhanh, int maxuatxu, int mathuonghieu, int gianhap, int giaban, int soluongton, int trangthai, int giaKM) {
        this.masp = masp;
        this.dungtich = dungtich;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.maxuatxu = maxuatxu;      
        this.mathuonghieu = mathuonghieu;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.soluongton = soluongton;
        this.trangthai = trangthai;
        this.giaKM = giaKM;
    }

    public SanPhamDTO(int masp, int dungtich, String tensp, String hinhanh, int maxuatxu, int mathuonghieu, int gianhap, int giaban, int soluongton, int trangthai) {
        this.masp = masp;
        this.dungtich = dungtich;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.maxuatxu = maxuatxu;      
        this.mathuonghieu = mathuonghieu;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.soluongton = soluongton;
        this.trangthai = trangthai;
    }
    
    public SanPhamDTO(String tensp, int dungtich, int maxuatxu, int mathuonghieu, int gianhap, int giaban, int giaKM, int soluongton) {
        this.tensp = tensp;
        this.dungtich = dungtich;
        this.maxuatxu = maxuatxu;
        this.mathuonghieu = mathuonghieu;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.giaKM = giaKM;
        this.soluongton = soluongton;
    }

    public int getGiaKM() {
        return giaKM;
    }

    public void setGiaKM(int giaKM) {
        this.giaKM = giaKM;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getDungtich() {
        return dungtich;
    }

    public void setDungtich(int dungtich) {
        this.dungtich = dungtich;
    }

   

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public XuatXuDTO getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(XuatXuDTO xuatxu) {
        this.xuatxu = xuatxu;
    }

    public int getMaxuatxu() {
        return maxuatxu;
    }

    public void setMaxuatxu(int maxuatxu) {
        this.maxuatxu = maxuatxu;
    }

    

    public ThuongHieuDTO getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(ThuongHieuDTO thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public int getMathuonghieu() {
        return mathuonghieu;
    }

    public void setMathuonghieu(int mathuonghieu) {
        this.mathuonghieu = mathuonghieu;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.masp);
        hash = 79 * hash + Objects.hashCode(this.dungtich);
        hash = 79 * hash + Objects.hashCode(this.tensp);
        hash = 79 * hash + Objects.hashCode(this.hinhanh);
        hash = 79 * hash + Objects.hashCode(this.xuatxu);        
        hash = 79 * hash + Objects.hashCode(this.thuonghieu);
        hash = 79 * hash + Objects.hashCode(this.soluongton);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPhamDTO other = (SanPhamDTO) obj;
        return true;
    }

    @Override
    public String toString() {
        return "SanPham{" + "masp=" + masp + ", dungtich=" + dungtich + ", tensp="
                + tensp + ", hinhanh=" + hinhanh + "xuatxu=" + xuatxu + "gianhap=" + gianhap + "thuonghieu=" + thuonghieu + "soluongton=" + soluongton + '}';
    }

}
