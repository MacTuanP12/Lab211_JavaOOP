package backtracking;

import java.util.*;

/**
 * Bài toán: Permutations (Hoán vị).
 * <br>
 * Mục tiêu: Tìm tất cả các hoán vị có thể có của một mảng các số phân biệt.
 * <br>
 * Giải thuật: Backtracking (Quay lui).
 * <br>
 * Tư duy:
 * - Xây dựng hoán vị từng bước.
 * - Dùng mảng `used` để đánh dấu các số đã được chọn vào hoán vị hiện tại.
 * - Với mỗi vị trí trong hoán vị, thử tất cả các số chưa được sử dụng.
 * - Khi độ dài hoán vị bằng độ dài mảng ban đầu -> tìm thấy 1 kết quả.
 * <br>
 * Độ phức tạp:
 * - Time: O(N * N!) - Có N! hoán vị, mỗi hoán vị mất O(N) để sao chép vào danh sách kết quả.
 * - Space: O(N) - Mảng used và stack đệ quy.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           boolean[] used,
                           List<Integer> path,
                           List<List<Integer>> result) {

        // Base case: hoàn thành 1 hoán vị
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Nếu số này đã dùng rồi thì bỏ qua
            if (used[i]) continue;

            // Choose
            used[i] = true;
            path.add(nums[i]);

            // Explore
            backtrack(nums, used, path, result);

            // Un-choose (Backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}