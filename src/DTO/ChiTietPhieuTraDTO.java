package DTO;

/**
 *
 * @author Bao Phan
 */
public class ChiTietPhieuTraDTO {

    private int maphieutra;
    private int masp;
    private int soluong;
    private long dongia;
    
    private String tensp;

    public ChiTietPhieuTraDTO() {
    }

    public ChiTietPhieuTraDTO(int maphieutra, int masp, int soluong, long dongia) {
        this.maphieutra = maphieutra;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    
    public ChiTietPhieuTraDTO(int maphieutra, int masp, String tensp, int soluong, long dongia) {
        this.maphieutra = maphieutra;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public ChiTietPhieuTraDTO(int maphieutra) {
        this.maphieutra = maphieutra;
    }

    public int getMaphieutra() {
        return maphieutra;
    }

    public void setMaphieutra(int maphieutra) {
        this.maphieutra = maphieutra;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
    
    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

}
