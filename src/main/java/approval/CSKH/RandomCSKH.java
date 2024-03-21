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
                "Kiểm tra hệ thống ổn áp cho máy tính và thiết bị công nghệ.",
                "Kiểm tra hệ thống điều khiển thiết bị điện tự động.",
                "Kiểm tra hệ thống báo động cháy trong các phòng học.",
                "Kiểm tra hệ thống cấp điện dự phòng cho phòng học.",
                "Kiểm tra hệ thống điều khiển quạt máy trong các phòng học.",
                "Kiểm tra hệ thống cung cấp điện cho thiết bị giáo dục đa phương tiện.",
                "Kiểm tra hệ thống chuỗi dây điện nối các thiết bị đèn chiếu sáng.",
                "Kiểm tra hệ thống dây điện cung cấp điện cho bảng trắng.",
                "Kiểm tra hệ thống cung cấp điện cho máy chiếu.",
                "Kiểm tra hệ thống cung cấp điện cho máy vi tính.",
                "Kiểm tra hệ thống bảo vệ điện cho máy tính.",
                "Kiểm tra hệ thống cung cấp điện cho máy in.",
                "Kiểm tra hệ thống cung cấp điện cho máy photocopy.",
                "Kiểm tra hệ thống cung cấp điện cho máy scan.",
                "Kiểm tra hệ thống dây điện kết nối máy tính trong phòng máy tính.",
                "Kiểm tra hệ thống cung cấp điện cho máy lạnh.",
                "Kiểm tra hệ thống điều khiển nhiệt độ trong phòng học.",
                "Kiểm tra hệ thống điều khiển nhiệt độ trong phòng máy tính.",
                "Kiểm tra hệ thống dây điện kết nối điều hòa không khí.",
                "Kiểm tra hệ thống cung cấp điện cho máy lọc không khí.",
                "Kiểm tra hệ thống bảo vệ điện cho máy lọc không khí.",
                "Kiểm tra hệ thống cung cấp điện cho tủ lạnh trong khu vực ăn uống.",
                "Kiểm tra hệ thống bảo vệ điện cho tủ lạnh trong khu vực ăn uống.",
                "Kiểm tra hệ thống cung cấp điện cho bếp điện.",
                "Kiểm tra hệ thống bảo vệ điện cho bếp điện.",
                "Kiểm tra hệ thống điều khiển nhiệt độ cho bếp điện.",
                "Kiểm tra hệ thống cung cấp điện cho máy sưởi.",
                "Kiểm tra hệ thống điều khiển nhiệt độ cho máy sưởi.",
                "Kiểm tra hệ thống bảo vệ điện cho máy sưởi.",
                "Kiểm tra hệ thống cung cấp điện cho máy phát sóng Wi-Fi.",
                "Kiểm tra hệ thống bảo vệ điện cho máy phát sóng Wi-Fi.",
                "Kiểm tra hệ thống cung cấp điện cho máy chiếu trong phòng họp.",
                "Kiểm tra hệ thống bảo vệ điện cho máy chiếu trong phòng họp.",
                "Kiểm tra hệ thống điều khiển nhiệt độ trong phòng họp.",
                "Kiểm tra hệ thống điều khiển thiết bị điện thông minh.",
                "Kiểm tra hệ thống cung cấp điện cho các thiết bị giáo dục đa phương tiện trong phòng học.",
                "Kiểm tra hệ thống bảo vệ điện cho các thiết bị giáo dục đa phương tiện trong phòng học.",
                "Kiểm tra hệ thống cung cấp điện cho quạt máy trong phòng học.",
                "Kiểm tra hệ thống bảo vệ điện cho quạt máy trong phòng học.",
                "Kiểm tra hệ thống cung cấp điện cho máy tính bảng.",
                "Kiểm tra hệ thống bảo vệ điện cho máy tính bảng.",
                "Kiểm tra hệ thống cung cấp điện cho máy tính xách tay.",
                "Kiểm tra hệ thống bảo vệ điện cho máy tính xách tay.",
                "Kiểm tra hệ thống cung cấp điện cho máy chấm công.",
                "Kiểm tra hệ thống bảo vệ điện cho máy chấm công.",
                "Kiểm tra hệ thống cung cấp điện cho hệ thống âm thanh.",
                "Kiểm tra hệ thống bảo vệ điện cho hệ thống âm thanh.",
                "Kiểm tra hệ thống cung cấp điện cho hệ thống hình ảnh.",
                "Kiểm tra hệ thống bảo vệ điện cho hệ thống hình ảnh.",
                "Kiểm tra hệ thống cung cấp điện cho máy in 3D.",};
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
                "Xin hãy gửi cho tôi nhanh nhất có thể.",
                "Chậm chậm lại đi một chút nhé",
                "Đừng vội vàng quá nhé",
                "Cẩn thận một chút nhé",
                "Hãy kiên nhẫn một tí nhé",
                "Không nên vội vàng đâu nhé",
                "Từ từ một chút nhé",
                "Đừng hấp tấp quá nhé",
                "Cần phải cẩn thận hơn nhé",
                "Không cần phải vội vã đâu nhé",
                "Hãy làm từ từ nhé",
                "Hãy chậm lại một chút nhé",
                "Đừng bận rộn quá nhé",
                "Không cần phải hối hả đâu nhé",
                "Chờ đợi một chút nhé",
                "Chú ý một tí nhé",
                "Cẩn thận hơn một chút nhé",
                "Đừng nhanh quá nhé",
                "Hãy thong thả một chút nhé",
                "Không cần phải nhanh chóng đâu nhé",
                "Hãy kiên nhẫn một chút nhé",
                "Đừng vội vàng quá đâu nhé",
                "Hãy bình tĩnh một chút nhé",
                "Chú ý và cẩn thận một chút nhé",
                "Đừng nôn nóng quá nhé",
                "Hãy thong thả một chút nhé",
                "Đừng làm vội quá nhé"};
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
    public static String Random_nguoi_lien_he_tao_ticket() {
        String[] words = {
                "Sang",
                "Linh",
                "Phương",
                "Hoa"
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
