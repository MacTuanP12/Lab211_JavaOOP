package backtracking;

import java.util.*;

/**
 * Bài toán: Combination Sum (Tổ hợp tổng).
 * <br>
 * Mục tiêu: Tìm tất cả các tổ hợp các số từ mảng candidates sao cho tổng bằng target. Một số có thể dùng nhiều lần.
 * <br>
 * Giải thuật: Backtracking (Quay lui).
 * <br>
 * Tư duy:
 * - Xây dựng tổ hợp bằng cách thử chọn từng số trong candidates.
 * - Tại mỗi bước, trừ giá trị số đã chọn khỏi target.
 * - Nếu target == 0: Tìm thấy một tổ hợp hợp lệ -> thêm vào kết quả.
 * - Nếu target < 0: Tổ hợp hiện tại vượt quá target -> quay lui (backtrack).
 * - Để tránh trùng lặp (ví dụ [2,3] và [3,2]), ta truyền tham số `start` vào đệ quy, chỉ cho phép chọn các số từ chỉ số `start` trở đi.
 * <br>
 * Độ phức tạp:
 * - Time: O(N^(M/min_candidate)) - N là số phần tử, M là target. Cây tìm kiếm có thể rất rộng.
 * - Space: O(M/min_candidate) - Độ sâu của đệ quy (chiều dài của tổ hợp).
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           int target,
                           int start,
                           List<Integer> path,
                           List<List<Integer>> result) {

        // Base case: tìm thấy tổng bằng target
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // Nếu số hiện tại lớn hơn phần còn lại của target thì không cần xét tiếp (nếu mảng đã sort thì break luôn được)
            // Ở đây mảng chưa chắc sort nên dùng continue, hoặc check logic khác.
            // Logic ở đây: nếu nums[i] > target, thì target - nums[i] < 0 => sẽ sai.
            if (nums[i] > target) continue;

            // Choose
            path.add(nums[i]);

            // Explore
            // start = i cho phép chọn lại số nums[i] (không giới hạn số lần sử dụng)
            backtrack(nums, target - nums[i], i, path, result);

            // Un-choose (Backtrack)
            path.remove(path.size() - 1);
        }
    }
}