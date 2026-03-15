package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Bài toán: N-Queens (Bài toán n quân hậu).
 * <br>
 * Mục tiêu: Đặt n quân hậu lên bàn cờ n x n sao cho không quân nào ăn quân nào (không cùng hàng, cột, đường chéo).
 * <br>
 * Giải thuật: Backtracking.
 * <br>
 * Tư duy:
 * - Duyệt từng hàng (row) từ 0 -> n-1.
 * - Tại mỗi hàng, thử đặt Hậu vào cột (col) từ 0 -> n-1.
 * - Kiểm tra `isValid(row, col)`:
 *   - Cột có quân nào chưa?
 *   - Đường chéo chính (row-col) có quân nào chưa?
 *   - Đường chéo phụ (row+col) có quân nào chưa?
 * - Nếu valid -> đặt -> đệ quy tiếp hàng sau.
 * <br>
 * Độ phức tạp:
 * - Time: O(N!).
 * - Space: O(N).
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0, result);

        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result) {

        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isValid(board, row, col)) {

                board[row][col] = 'Q';

                backtrack(board, row + 1, result);

                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // Kiểm tra cột dọc
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Kiểm tra chéo chính (lên trên bên trái)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Kiểm tra chéo phụ (lên trên bên phải)
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}

