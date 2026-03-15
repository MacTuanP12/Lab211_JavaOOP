package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bài toán: Combination Sum II (Tổ hợp tổng II).
 * <br>
 * Mục tiêu: Tìm các tổ hợp trong `candidates` sao cho tổng bằng `target`. Mỗi sổ chỉ dùng 1 lần. Kết quả không trùng lặp.
 * <br>
 * Giải thuật: Backtracking + Sorting.
 * <br>
 * Tư duy:
 * - Sắp xếp mảng để skip duplicates.
 * - Duyệt i từ start.
 * - Nếu `candidates[i] > target` -> dừng (vì mảng đã sort).
 * - Nếu `i > start` và `candidates[i] == candidates[i-1]` -> skip.
 * - Gọi đệ quy với `i + 1` (vì mỗi số dùng tối đa 1 lần).
 * <br>
 * Độ phức tạp:
 * - Time: O(2^N).
 * - Space: O(N).
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target) break; // Đã sort nên không cần check tiếp

            if (i > start && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);

            // i + 1 để tránh dùng lại chính phần tử đó
            backtrack(candidates, target - candidates[i], i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}

