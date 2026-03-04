import java.util.HashMap;        // Import HashMap để lưu trữ cặp key-value
import java.util.Map;            // Import Map interface
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // Vòng lặp để đảm bảo người dùng nhập ít nhất 1 ký tự
        do {
            System.out.print("Enter your content: ");
            input = scanner.nextLine();

            // Kiểm tra nếu input rỗng
            if (input.trim().isEmpty()) {
                System.out.println("Input must not be empty. Please try again.");
            }
        } while (input.trim().isEmpty());

        // ===== BƯỚC 1: ĐẾM SỐ LẦN XUẤT HIỆN CỦA TỪ =====

        // Tạo HashMap để lưu: Key = từ (String), Value = số lần xuất hiện (Integer)
        Map<String, Integer> wordCount = new HashMap<>();

        // Sử dụng StringTokenizer để tách chuỗi thành các từ (tách theo khoảng trắng)
        StringTokenizer tokenizer = new StringTokenizer(input);

        // Duyệt qua từng từ trong chuỗi
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            // getOrDefault: Nếu từ chưa có → trả về 0, đã có → trả về giá trị hiện tại
            // Sau đó +1 để tăng số đếm
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // ===== BƯỚC 2: ĐẾM SỐ LẦN XUẤT HIỆN CỦA KÝ TỰ =====

        // Tạo HashMap để lưu: Key = ký tự (Character), Value = số lần xuất hiện (Integer)
        Map<Character, Integer> charCount = new HashMap<>();

        // Duyệt qua từng ký tự trong chuỗi
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Chỉ đếm các chữ cái (a-z, A-Z), bỏ qua số, khoảng trắng, ký tự đặc biệt
            if (Character.isLetter(c)) {
                // Tương tự như đếm từ: getOrDefault + 1
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        // ===== BƯỚC 3: HIỂN THỊ KẾT QUẢ =====
        // In ra HashMap dưới dạng {key=value, key=value}
        System.out.println(wordCount);
        System.out.println(charCount);
    }
}