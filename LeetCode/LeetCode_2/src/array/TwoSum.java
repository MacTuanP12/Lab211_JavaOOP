package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Bài toán: Two Sum (Tổng hai số).
 * <br>
 * Mục tiêu: Tìm chỉ số của 2 số trong mảng sao cho tổng của chúng bằng target.
 * <br>
 * Giải thuật: Hash Map (Bảng băm).
 * <br>
 * Tư duy:
 * - Thay vì dùng 2 vòng lặp lồng nhau (O(n^2)), ta dùng Map để lưu trữ các số đã duyệt qua.
 * - Key: Giá trị số, Value: Index của số đó.
 * - Với mỗi số x, ta kiểm tra xem (target - x) đã có trong Map chưa.
 * - Nếu có -> Tìm thấy cặp số.
 * - Nếu chưa -> Lưu x và chỉ số của nó vào Map.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt mảng 1 lần.
 * - Space: O(n) - Hash Map lưu tối đa n phần tử.
 */
public class TwoSum {

    // Time: O(n)
    // Space: O(n)

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // Kiểm tra xem phần bù đã xuất hiện trước đó chưa
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Lưu giá trị hiện tại vào map để các số sau tìm kiếm
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}