package graph;

import java.util.*;

/**
 * Bài toán: Rotting Oranges (Cam thối).
 * <br>
 * Mục tiêu: Tính số phút tối thiểu để toàn bộ cam tươi bị lây thối (nếu có thể).
 * Cam thối lây sang 4 hướng xung quanh sau mỗi phút.
 * <br>
 * Giải thuật: BFS (Multi-source BFS).
 * <br>
 * Tư duy:
 * - Đưa tất cả cam thối ban đầu vào Queue.
 * - Đếm tổng số cam tươi ban đầu `freshCount`.
 * - BFS từng tầng (mỗi tầng tương ứng 1 phút).
 * - Khi cam thối lây sang cam tươi -> giảm `freshCount`, thêm cam mới thối vào Queue.
 * - Nếu Queue rỗng mà `freshCount > 0` -> không thể lây hết -> return -1.
 * <br>
 * Độ phức tạp:
 * - Time: O(M * N).
 * - Space: O(M * N).
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();

        // 1. Init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. BFS
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottedSomething = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Nếu gặp cam tươi
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Làm cho nó thối
                        freshCount--;
                        queue.offer(new int[]{nr, nc});
                        rottedSomething = true;
                    }
                }
            }

            if (rottedSomething) {
                minutes++;
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}

