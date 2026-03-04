/**

 * Giải thích:
 * - Ma trận kề là ma trận vuông n x n với n là số đỉnh
 * - adjacencyMatrix[i][j] = 1 nghĩa là có cạnh nối giữa đỉnh i và đỉnh j
 * - adjacencyMatrix[i][j] = 0 nghĩa là không có cạnh
 * - Với đồ thị vô hướng: adjacencyMatrix[i][j] = adjacencyMatrix[j][i] (ma trận đối xứng)
 *
 * Ví dụ: Đồ thị có 5 đỉnh (0,1,2,3,4) với các cạnh (0,1), (1,2), (2,4)
 * Ma trận kề sẽ là:
 *     0  1  2  3  4
 * 0 [ 0  1  0  0  0 ]
 * 1 [ 1  0  1  0  0 ]
 * 2 [ 0  1  0  0  1 ]
 * 3 [ 0  0  0  0  0 ]
 * 4 [ 0  0  1  0  0 ]
 */
public class Graph {
    private int[][] adjacencyMatrix;  // Ma trận kề để lưu các cạnh
    private int numVertices;          // Số đỉnh trong đồ thị
    private int numEdges;             // Số cạnh trong đồ thị

    /**
     * Constructor - Khởi tạo đồ thị với số đỉnh cho trước
     * @param numVertices Số đỉnh của đồ thị
     */
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.numEdges = 0;
        // Khởi tạo ma trận kề với tất cả giá trị = 0 (không có cạnh nào)
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    /**
     * Thêm một cạnh vào đồ thị
     * Vì là đồ thị vô hướng nên cạnh (u,v) cũng đồng nghĩa với cạnh (v,u)
     * Do đó ma trận kề phải đối xứng: adjacencyMatrix[i][j] = adjacencyMatrix[j][i]
     *
     * @param vertex1 Đỉnh thứ nhất
     * @param vertex2 Đỉnh thứ hai
     * @return true nếu thêm thành công, false nếu thất bại
     *
     * Ví dụ 1: addEdge(2, 5) sẽ đặt:
     *           - adjacencyMatrix[2][5] = 1
     *           - adjacencyMatrix[5][2] = 1 (vì đồ thị vô hướng)
     *
     * Ví dụ 2: addEdge(3, 3) tạo loop (vòng lặp tự nối):
     *           - adjacencyMatrix[3][3] = 1 (phần tử trên đường chéo chính)
     *           - Loop được biểu diễn bởi các phần tử trên đường chéo chính của ma trận
     */
    public boolean addEdge(int vertex1, int vertex2) {
        // Kiểm tra tính hợp lệ của các đỉnh
        if (!isValidVertex(vertex1) || !isValidVertex(vertex2)) {
            return false;
        }

        // Nếu cạnh chưa tồn tại, thêm vào
        if (adjacencyMatrix[vertex1][vertex2] == 0) {
            adjacencyMatrix[vertex1][vertex2] = 1;
            adjacencyMatrix[vertex2][vertex1] = 1;  // Đảm bảo tính đối xứng cho đồ thị vô hướng
            numEdges++;
            return true;
        }

        // Cạnh đã tồn tại trả về false
        return false;
    }

    /**
     * Xóa một cạnh khỏi đồ thị
     * Vì đồ thị vô hướng nên phải xóa cả 2 ô đối xứng trong ma trận
     *
     * @param vertex1 Đỉnh thứ nhất
     * @param vertex2 Đỉnh thứ hai
     * @return true nếu xóa thành công, false nếu thất bại
     *
     * Ví dụ: removeEdge(2, 5) sẽ đặt:
     *        - adjacencyMatrix[2][5] = 0
     *        - adjacencyMatrix[5][2] = 0 (vì ma trận đối xứng)
     */
    public boolean removeEdge(int vertex1, int vertex2) {
        // Kiểm tra tính hợp lệ của các đỉnh
        if (!isValidVertex(vertex1) || !isValidVertex(vertex2)) {
            return false;
        }

        // Nếu cạnh tồn tại, xóa nó (đồng thời xóa cả 2 ô đối xứng)
        if (adjacencyMatrix[vertex1][vertex2] == 1) {
            adjacencyMatrix[vertex1][vertex2] = 0;
            adjacencyMatrix[vertex2][vertex1] = 0;
            numEdges--;
            return true;
        }

        // Cạnh không tồn tại
        return false;
    }

    /**
     * Kiểm tra xem có cạnh nối giữa hai đỉnh hay không
     * Đây là chức năng chính của chương trình theo đề bài
     *
     * @param vertex1 Đỉnh thứ nhất
     * @param vertex2 Đỉnh thứ hai
     * @return true nếu có cạnh (adjacencyMatrix[vertex1][vertex2] = 1), false nếu không có (= 0)
     *
     * Ví dụ: hasEdge(2, 5) kiểm tra ô adjacencyMatrix[2][5]
     *        - Nếu = 1 → có cạnh → trả về true
     *        - Nếu = 0 → không có cạnh → trả về false
     *
     * Lưu ý: Vì đồ thị vô hướng nên adjacencyMatrix[2][5] = adjacencyMatrix[5][2]
     *        Do đó hasEdge(2,5) và hasEdge(5,2) cho kết quả giống nhau
     */
    public boolean hasEdge(int vertex1, int vertex2) {
        if (!isValidVertex(vertex1) || !isValidVertex(vertex2)) {
            return false;
        }
        return adjacencyMatrix[vertex1][vertex2] == 1;
    }

    /**
     * Alias của hasEdge - Kiểm tra xem có phải là cạnh hay không
     *
     * @param i Đỉnh thứ nhất
     * @param j Đỉnh thứ hai
     * @return true nếu có cạnh, false nếu không có
     */
    public boolean isEdge(int i, int j) {
        return hasEdge(i, j);
    }

    /**
     * Kiểm tra xem một đỉnh có hợp lệ hay không
     * Đỉnh hợp lệ khi nằm trong khoảng từ 0 đến numVertices-1
     *
     * @param vertex Đỉnh cần kiểm tra
     * @return true nếu hợp lệ, false nếu không hợp lệ
     */
    public boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < numVertices;
    }

    /**
     * Lấy số đỉnh của đồ thị
     * @return Số đỉnh
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * Lấy số cạnh của đồ thị
     * @return Số cạnh
     */
    public int getNumEdges() {
        return numEdges;
    }

    /**
     * Lấy bậc của một đỉnh (số cạnh kề với đỉnh đó)
     *
     * @param vertex Đỉnh cần tính bậc
     * @return Bậc của đỉnh, -1 nếu đỉnh không hợp lệ
     *
     * Ví dụ: Nếu đỉnh 2 có các cạnh nối với đỉnh 1, 3, 4 thì bậc của đỉnh 2 là 3
     */
    public int getDegree(int vertex) {
        if (!isValidVertex(vertex)) {
            return -1;
        }

        int degree = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * Hiển thị ma trận kề dưới dạng bảng
     * Ma trận sẽ được hiển thị với header cho hàng và cột
     *
     * Ví dụ output:
     *   Adjacency Matrix:
     *      0  1  2  3  4
     *   0  0  1  0  0  0
     *   1  1  0  1  0  0
     *   2  0  1  0  0  1
     */
    public void displayAdjacencyMatrix() {
        System.out.println("\n========== Adjacency Matrix ==========");

        // In header (số thứ tự các đỉnh)
        System.out.print("   ");
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        // In từng hàng của ma trận với số thứ tự đỉnh ở đầu
        for (int i = 0; i < numVertices; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%3d", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("======================================");
    }

    /**
     * Hiển thị thông tin chi tiết về đồ thị
     * Bao gồm: số đỉnh, số cạnh, danh sách các cạnh, bậc của từng đỉnh
     */
    public void displayGraphInfo() {
        System.out.println("\n========== Graph Information ==========");
        System.out.println("Number of vertices: " + numVertices);
        System.out.println("Number of edges: " + numEdges);

        // Hiển thị danh sách các cạnh
        System.out.println("\nList of edges:");
        boolean hasEdges = false;
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {  // j bắt đầu từ i để tránh in trùng cạnh
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.println("  (" + i + ", " + j + ")");
                    hasEdges = true;
                }
            }
        }
        if (!hasEdges) {
            System.out.println("  (No edges in the graph)");
        }

        // Hiển thị bậc của từng đỉnh
        System.out.println("\nDegree of each vertex:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("  Vertex " + i + ": degree = " + getDegree(i));
        }

        // Kiểm tra tính liên thông (đơn giản)
        System.out.println("\nGraph type: Undirected (Đồ thị vô hướng)");
        System.out.println("======================================");
    }

    /**
     * Lấy danh sách các đỉnh kề với một đỉnh cho trước
     *
     * @param vertex Đỉnh cần tìm các đỉnh kề
     * @return Mảng các đỉnh kề
     *
     * Ví dụ: Nếu đỉnh 2 có cạnh với đỉnh 1, 3, 4 thì trả về [1, 3, 4]
     */
    public int[] getAdjacentVertices(int vertex) {
        if (!isValidVertex(vertex)) {
            return new int[0];
        }

        int degree = getDegree(vertex);
        int[] adjacentVertices = new int[degree];
        int index = 0;

        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                adjacentVertices[index++] = i;
            }
        }

        return adjacentVertices;
    }

    /**
     * Hiển thị danh sách kề của tất cả các đỉnh
     * Đây là cách biểu diễn đồ thị khác ngoài ma trận kề
     */
    public void displayAdjacencyList() {
        System.out.println("\n========== Adjacency List ==========");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            int[] adjacent = getAdjacentVertices(i);
            if (adjacent.length == 0) {
                System.out.println("(no connections)");
            } else {
                for (int j = 0; j < adjacent.length; j++) {
                    System.out.print(adjacent[j]);
                    if (j < adjacent.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("====================================");
    }
}

