package DTO;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Objects; // Add this line

public class PhieuTraDTO{
    private int maphieutra;
    private int maphieunhap;
    private int manhacungcap;
    private int manguoitao;
    private Date thoigiantao;
    private String lydo;
    private long tongTien;
    private int trangthai;
    
    private String tenncc;
    private String tennt;

    public PhieuTraDTO(int manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public PhieuTraDTO(int maphieutra, int maphieunhap, int manhacungcap, int manguoitao, Date thoigiantao, String lydo, long tongTien, int trangthai) {
        this.manhacungcap = manhacungcap;
        this.maphieutra = maphieutra;
        this.maphieunhap = maphieunhap;
        this.manguoitao = manguoitao;
        this.thoigiantao = thoigiantao;
        this.lydo = lydo;
        this.tongTien = tongTien;
        this.trangthai = trangthai;
    }

    public PhieuTraDTO(int maphieutra, int maphieunhap, int manhacungcap, int manguoitao, Date thoigiantao, long tongTien) {
        this.manhacungcap = manhacungcap;
        this.maphieutra = maphieutra;
        this.maphieunhap = maphieunhap;
        this.manguoitao = manguoitao;
        this.thoigiantao = thoigiantao;
        this.tongTien = tongTien;
    }

    public PhieuTraDTO(int maphieutra, int maphieunhap, int manhacungcap, String tenncc, int manguoitao, String tennt, Date thoigiantao, String lydo, long tongTien, int trangthai) {
        this.maphieutra = maphieutra;
        this.maphieunhap = maphieunhap;
        this.manhacungcap = manhacungcap;
        this.tenncc = tenncc;
        this.manguoitao = manguoitao;
        this.tennt = tennt;
        this.thoigiantao = thoigiantao;
        this.lydo = lydo;
        this.tongTien = tongTien;
        this.trangthai = trangthai;
    }

    public int getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(int manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public int getMaphieutra() {
        return maphieutra;
    }

    public void setMaphieutra(int maphieutra) {
        this.maphieutra = maphieutra;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getManguoitao() {
        return manguoitao;
    }

    public void setManguoitao(int manguoitao) {
        this.manguoitao = manguoitao;
    }

    public Date getThoigiantao() {
        return thoigiantao;
    }

    public void setThoigiantao(Date thoigiantao) {
        this.thoigiantao = thoigiantao;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }
    
    public String getTenncc() {
        return this.tenncc;
    }
    
    public void setTennt(String tennt) {
        this.tennt = tennt;
    }
    
    public String getTennt() {
        return this.tennt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.manhacungcap;
        hash = 67 * hash + this.maphieutra;
        hash = 67 * hash + this.maphieunhap;
        hash = 67 * hash + this.manguoitao;
        hash = 67 * hash + (this.thoigiantao != null ? this.thoigiantao.hashCode() : 0);
        hash = 67 * hash + (int) (this.tongTien ^ (this.tongTien >>> 32));
        hash = 67 * hash + this.trangthai;
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
        final PhieuTraDTO other = (PhieuTraDTO) obj;
        return this.manhacungcap == other.manhacungcap &&
               this.maphieutra == other.maphieutra &&
               this.maphieunhap == other.maphieunhap &&
               this.manguoitao == other.manguoitao &&
               Objects.equals(this.thoigiantao, other.thoigiantao) &&
               this.tongTien == other.tongTien &&
               this.trangthai == other.trangthai;
    }

    @Override
    public String toString() {
        return "PhieuTraDTO{" + "manhacungcap=" + manhacungcap +
               ", maphieutra=" + maphieutra +
               ", maphieunhap=" + maphieunhap +
               ", manguoitao=" + manguoitao +
               ", thoigiantao=" + thoigiantao +
               ", lydo=" + lydo +
               ", tongTien=" + tongTien +
               ", trangthai=" + trangthai +
               '}';
    }
}
