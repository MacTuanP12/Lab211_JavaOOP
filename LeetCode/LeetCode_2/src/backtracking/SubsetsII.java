package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bài toán: Subsets II (Tập hợp con II).
 * <br>
 * Mục tiêu: Tìm tất cả các tập hợp con (có thể chứa phần tử trùng lặp trong input, nhưng kết quả không được trùng lặp tập hợp).
 * <br>
 * Giải thuật: Backtracking (Quay lui) + Sorting.
 * <br>
 * Tư duy:
 * - Sắp xếp nums để gom các phần tử giống nhau lại gần nhau.
 * - Khi duyệt, nếu `nums[i] == nums[i-1]` và `i > start`, ta bỏ qua vì nó sẽ tạo ra tập con trùng lặp với phần tử trước đó.
 * <br>
 * Độ phức tạp:
 * - Time: O(N * 2^N).
 * - Space: O(N).
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Quan trọng để xử lý trùng lặp

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Bỏ qua duplicate trong cùng một tầng đệ quy
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}

