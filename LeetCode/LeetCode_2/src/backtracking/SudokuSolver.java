package backtracking;

/**
 * Bài toán: Sudoku Solver (Giải Sudoku).
 * <br>
 * Mục tiêu: Điền các số từ 1-9 vào các ô trống ('.') sao cho đúng luật Sudoku.
 * <br>
 * Giải thuật: Backtracking (Quay lui).
 * <br>
 * Tư duy:
 * - Duyệt qua từng ô trống trên bàn cờ.
 * - Thử điền các số từ '1' đến '9'.
 * - Kiểm tra tính hợp lệ (`isValid`): Số đó chưa có ở hàng, cột, và ô vuông 3x3 tương ứng.
 * - Nếu hợp lệ -> điền số và đệ quy giải tiếp (`solve(board)`).
 * - Nếu đệ quy trả về true (đã giải xong) -> return true.
 * - Nếu không tìm được số nào hợp lệ tại vị trí này -> backtrack (trả lại '.'), return false.
 * <br>
 * Độ phức tạp:
 * - Time: O(9^M) - M là số ô trống. Rất lớn trong trường hợp xấu nhất, nhưng thực tế chạy nhanh do cắt nhánh (pruning) nhiều qua `isValid`.
 * - Space: O(M) - Stack đệ quy.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, r, c, num)) {

                            board[r][c] = num;

                            if (solve(board))
                                return true;

                            // Backtrack
                            board[r][c] = '.';
                        }
                    }

                    return false; // Không điền được số nào phù hợp vào ô này
                }
            }
        }

        return true; // Tất cả các ô đã được điền
    }

    // Kiểm tra xem đặt num vào vị trí (row, col) có hợp lệ không
    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            // Kiểm tra hàng
            if (board[row][i] == num) return false;

            // Kiểm tra cột
            if (board[i][col] == num) return false;

            // Kiểm tra ô vuông 3x3
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) return false;
        }

        return true;
    }
}