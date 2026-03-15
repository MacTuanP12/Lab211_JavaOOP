package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Bài toán: Subsets (Tập hợp con).
 * <br>
 * Mục tiêu: Tìm tất cả các tập hợp con (với các phần tử không trùng lặp) của một mảng nums (các phần tử trong nums là duy nhất).
 * <br>
 * Giải thuật: Backtracking (Quay lui).
 * <br>
 * Tư duy:
 * - Tại mỗi bước, ta có thể chọn thêm một phần tử vào subset hiện tại hoặc không.
 * - Duyệt i từ start -> n.
 * - Thêm phần tử nums[i] -> gọi đệ quy (i+1) -> bỏ phần tử nums[i] (backtrack).
 * <br>
 * Độ phức tạp:
 * - Time: O(N * 2^N) - Có 2^N tập con, mỗi tập con tốn O(N) để copy.
 * - Space: O(N) - Stack đệ quy.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}

