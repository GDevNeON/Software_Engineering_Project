package helper;

public class Validation {
    public static Boolean isEmpty(String input) {
        if (input == null) {
            return true;
        }
        return input.equals("");
    }

    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty() || (name.length() < 6 || name.length() > 30)) {
            return false; // Không chấp nhận chuỗi null hoặc chỉ có khoảng trắng
        }
        String nameRegex = "^[\\p{L}\\s]+$";
        return name.matches(nameRegex);
    }
    
     public boolean isValidAddress(String name) {
        if (name == null || name.trim().isEmpty() || (name.length() < 6 || name.length() > 50)) {
            return false; // Không chấp nhận chuỗi null hoặc chỉ có khoảng trắng
        }
        return true;
    }
    
    public boolean isValidEmail(String email) {
        // Kiểm tra định dạng email sử dụng biểu thức chính quy
        // Bạn có thể thay đổi biểu thức chính quy theo nhu cầu
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public boolean isValidPhoneNumber(String str) {
        // Loại bỏ khoảng trắng và dấu ngoặc đơn nếu có
        str = str.replaceAll("\\s+", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "");

        // Kiểm tra xem chuỗi có phải là một số điện thoại hợp lệ hay không
        if (str.matches("^(03|08|09)\\d{8}$")) { // Kiểm tra số điện thoại 10 chữ số
            return true;
        } else if (str.matches("\\d{3}-\\d{3}-\\d{4}")) { // Kiểm tra số điện thoại có dấu gạch ngang
            return true;
        } else {
            return str.matches("\\(\\d{3}\\)\\d{3}-\\d{4}"); // Kiểm tra số điện thoại có dấu ngoặc đơn
        }        // Trả về false nếu chuỗi không phải là số điện thoại hợp lệ
    }
}
