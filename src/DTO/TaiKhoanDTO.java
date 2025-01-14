package DTO;

import java.util.ArrayList;


public class TaiKhoanDTO {
    private int manv;
    private NhanVienDTO manv1 = new NhanVienDTO();
    private String matkhau;
    private int manhomquyen;
    private int trangthai;
    private int maaccount;
    private int manhomquyenaccount;
    private String tennhomquyenaccount;
    private ArrayList<ChiTietQuyenDTO> ctquyenaccount;
//     private String email;
     
    
    public TaiKhoanDTO() {
        
    }

    public TaiKhoanDTO(int manv,String matkhau, int manhomquyen, int trangthai) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.manhomquyen = manhomquyen;
        this.trangthai = trangthai;
//        this.email = email;
    }
    
    public TaiKhoanDTO(int maaccount, int manhomquyenaccount, String tennhomquyenaccount, ArrayList<ChiTietQuyenDTO> ctquyenaccount) {
        this.maaccount = maaccount;
        this.manhomquyenaccount = manhomquyenaccount;
        this.tennhomquyenaccount = tennhomquyenaccount;
        this.ctquyenaccount = ctquyenaccount;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public NhanVienDTO getManv1() {
        return manv1;
    }

    public void setManv1(NhanVienDTO manv1) {
        this.manv1 = manv1;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getManhomquyen() {
        return manhomquyen;
    }

    public void setManhomquyen(int manhomquyen) {
        this.manhomquyen = manhomquyen;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getMaaccount() {
        return maaccount;
    }

    public void setMaaccount(int maaccount) {
        this.maaccount = maaccount;
    }

    public int getManhomquyenaccount() {
        return manhomquyenaccount;
    }

    public void setManhomquyenaccount(int manhomquyenaccount) {
        this.manhomquyenaccount = manhomquyenaccount;
    }

    public String getTennhomquyenaccount() {
        return tennhomquyenaccount;
    }

    public void setTennhomquyenaccount(String tennhomquyenaccount) {
        this.tennhomquyenaccount = tennhomquyenaccount;
    }
    
    public ArrayList<ChiTietQuyenDTO> getCtquyenaccount() {
        return ctquyenaccount;
    }

    public void setCtquyenaccount(ArrayList<ChiTietQuyenDTO> ctquyenaccount) {
        this.ctquyenaccount = ctquyenaccount;
    }
    
    

    @Override
    public String toString() {
        return "TaiKhoanDTO{"  +", matkhau=" + matkhau + ", manhomquyen=" + manhomquyen + ", trangthai=" + trangthai + '}';
    }

    public void setTennhomquyen(String roleName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
