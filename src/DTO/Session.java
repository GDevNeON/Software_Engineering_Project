package DTO;

/**
 *
 * @author HP
 */
public class Session {
    private static NhanVienDTO nv=new NhanVienDTO();

    public static NhanVienDTO getNv() {
        return nv;
    }

    public static void setNv(NhanVienDTO nv) {
        Session.nv = nv;
    }

    
    
    
}
