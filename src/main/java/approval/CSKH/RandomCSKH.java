package approval.CSKH;

import java.util.Random;

public class RandomCSKH {
    static Random random = new Random();
    public static String generateRandom() {
        String[] words = {
                "Kiểm tra đèn chiếu sáng trong phòng học.",
                "Kiểm tra hệ thống cầu chì của tủ điện.",
                "Kiểm tra ổ cắm điện trong phòng học.",
                "Kiểm tra hệ thống dây điện ở các khu vực công cộng.",
                "Kiểm tra hệ thống điều khiển thiết bị điện tự động.",
                "Kiểm tra hệ thống bảo vệ điện cho máy tính xách tay.",
                "Kiểm tra hệ thống bảo vệ điện cho hệ thống hình ảnh.",
                "Kiểm tra hệ thống bảo vệ điện cho các thiết bị giáo dục đa phương tiện trong phòng học."};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static String generateRandomGhiChu() {
        String[] words = {
                "Hãy làm nhanh nhất bạn có thể.",
                "Hãy hoàn thành nhanh nhất có thể.",
                "Mong bạn làm xong nhanh nhất.",
                "Xin hãy gửi cho tôi nhanh nhất có thể."};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static String generateRandomMucDo() {
        String[] words = {
                "Bình thường",
                "Khẩn cấp",
                "Cao"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static String generateRandomPhanLoai() {
        String[] words = {
                "Yêu cầu",
                "Phản ánh"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
