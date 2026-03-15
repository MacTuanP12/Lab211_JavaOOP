package graph;

import java.util.*;

/**
 * Bài toán: Pacific Atlantic Water Flow (Dòng chảy Thái Bình Dương - Đại Tây Dương).
 * <br>
 * Mục tiêu: Tìm các ô trên đảo mà nước mưa có thể chảy ra cả 2 đại dương (Pacific & Atlantic).
 * Nước chảy từ cao xuống thấp (hoặc bằng).
 * <br>
 * Giải thuật: DFS/BFS ngược dòng.
 * <br>
 * Tư duy:
 * - Thay vì kiểm tra từng ô xem có chảy ra được biển không, ta làm ngược lại:
 *   - Từ biên Pacific, nước có thể chảy NGƯỢC lên các ô cao hơn nào? (Đánh dấu `pacificReachable`).
 *   - Từ biên Atlantic, nước có thể chảy NGƯỢC lên các ô cao hơn nào? (Đánh dấu `atlanticReachable`).
 * - Giao của 2 tập hợp trên chính là kết quả.
 * <br>
 * Độ phức tạp:
 * - Time: O(M * N) - Mỗi ô được duyệt tối đa vài lần.
 * - Space: O(M * N).
 */
public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Duyệt biên hàng ngang (trên và dưới)
        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific, Integer.MIN_VALUE);
            dfs(heights, m - 1, c, atlantic, Integer.MIN_VALUE);
        }

        // Duyệt biên hàng dọc (trái và phải)
        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, r, n - 1, atlantic, Integer.MIN_VALUE);
        }

        // Tìm giao
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {

        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length
                || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        dfs(heights, r + 1, c, visited, heights[r][c]);
        dfs(heights, r - 1, c, visited, heights[r][c]);
        dfs(heights, r, c + 1, visited, heights[r][c]);
        dfs(heights, r, c - 1, visited, heights[r][c]);
    }
}

