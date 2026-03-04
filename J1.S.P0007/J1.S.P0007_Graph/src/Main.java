import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // BƯỚC 1: Tạo đồ thị với 6 đỉnh (đỉnh 0, 1, 2, 3, 4, 5)
        Graph graph = new Graph(6);

        // Mỗi lần gọi addEdge sẽ tạo 2 ô đối xứng trong ma trận vì đồ thị vô hướng
        graph.addEdge(1, 4);  // Tạo cạnh giữa đỉnh 1 và 4
        graph.addEdge(2, 4);  // Tạo cạnh giữa đỉnh 2 và 4
        graph.addEdge(2, 5);  // Tạo cạnh giữa đỉnh 2 và 5
        graph.addEdge(3, 5);  // Tạo cạnh giữa đỉnh 3 và 5
        graph.addEdge(4, 5);  // Tạo cạnh giữa đỉnh 4 và 5

        System.out.println("========== UNDIRECTED GRAPH REPRESENTATION ==========");

        // BƯỚC 2: Hiển thị ma trận kề để người dùng thấy cấu trúc đồ thị
        graph.displayAdjacencyMatrix();

        // BƯỚC 3: Nhập 2 điểm cần kiểm tra từ người dùng
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter the start point: ");
        int start = getIntInput(scanner);  // Sử dụng hàm có validation

        System.out.println("Enter the end point: ");
        int end = getIntInput(scanner);    // Sử dụng hàm có validation

        // BƯỚC 4: Kiểm tra và in kết luận theo format đề bài
        System.out.println("\nThis is" +
                (graph.isEdge(start, end) ? "" : " not ") + " an edge");

        scanner.close();
    }

    /**

     * Cách hoạt động:
     * - scanner.hasNextInt() kiểm tra xem input có phải là số nguyên không
     * - Nếu không phải số → yêu cầu nhập lại
     * - Nếu đúng là số → đọc và trả về giá trị

     * Ví dụ kịch bản xử lý lỗi:
     * - User nhập: "abc" → In ra "Invalid input! Please enter a valid number: "
     * - User nhập: "xyz" → In ra "Invalid input! Please enter a valid number: "
     * - User nhập: "5"   → Chấp nhận và trả về 5
     */
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}

