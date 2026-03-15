package graph;

/**
 * Bài toán: Number of Islands (Số lượng đảo).
 * <br>
 * Mục tiêu: Đếm số vùng đảo ('1') được bao quanh bởi nước ('0'). Đảo được hình thành bởi các số '1' nối liền kề (ngang/dọc).
 * <br>
 * Giải thuật: DFS (Depth First Search) - Tìm kiếm theo chiều sâu.
 * <br>
 * Tư duy:
 * - Duyệt qua từng ô của lưới (grid).
 * - Nếu gặp '1' -> Tăng biến đếm đảo.
 * - Từ ô '1' đó, gọi DFS loang ra 4 hướng để đánh dấu tất cả các ô '1' thuộc cùng hòn đảo đó thành '0' (visited).
 * - Tiếp tục duyệt, các ô '0' sẽ bị bỏ qua.
 * <br>
 * Độ phức tạp:
 * - Time: O(M * N) - Mỗi ô được duyệt tối đa vài lần.
 * - Space: O(M * N) - Trong trường hợp đảo bao phủ toàn bộ lưới, stack đệ quy có thể sâu M*N (DFS). BFS sẽ tốn O(min(M,N)) space.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int r = 0; r < grid.length; r++) {

            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == '1') {

                    // Tìm thấy một hòn đảo mới, bắt đầu loang để đánh dấu hết hòn đảo này
                    dfs(grid, r, c);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {

        // Kiểm tra biên và điều kiện dừng (nước '0')
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] == '0')
            return;

        // Đánh dấu ô hiện tại là nước ('0') để không duyệt lại
        grid[r][c] = '0';

        // Loang ra 4 hướng: xuống, lên, phải, trái
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}