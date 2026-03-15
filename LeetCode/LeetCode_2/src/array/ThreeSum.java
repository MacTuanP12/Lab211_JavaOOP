package array;

import java.util.*;

/**
 * Bài toán: Three Sum (Tổng ba số).
 * <br>
 * Mục tiêu: Tìm tất cả các bộ ba số [nums[i], nums[j], nums[k]] sao cho tổng bằng 0 và không trùng lặp.
 * <br>
 * Giải thuật: Sorting + Two Pointers.
 * <br>
 * Tư duy:
 * - Để tránh trùng lặp và dễ dàng tìm kiếm, đầu tiên sắp xếp mảng (O(n log n)).
 * - Duyệt qua từng phần tử nums[i] (cố định số thứ nhất).
 * - Dùng 2 con trỏ left (i+1) và right (n-1) để tìm 2 số còn lại sao cho nums[left] + nums[right] = -nums[i].
 * - Bỏ qua các giá trị trùng nhau của nums[i], nums[left], nums[right] để đảm bảo kết quả duy nhất.
 * <br>
 * Độ phức tạp:
 * - Time: O(n^2) - Vòng lặp i kết hợp với while(left < right).
 * - Space: O(1) hoặc O(n) tùy vào giải thuật sort (Java Arrays.sort dùng Dual-Pivot Quicksort ~ O(log n) stack space).
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Bước 1: Sắp xếp

        for (int i = 0; i < nums.length - 2; i++) {

            // Bỏ qua số trùng ở vị trí i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Tìm thấy bộ ba
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Bỏ qua các số trùng bên trái
                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    // Bỏ qua các số trùng bên phải
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }

                else if (sum < 0)
                    left++; // Tổng nhỏ quá -> tăng giá trị (dịch left qua phải)

                else
                    right--; // Tổng lớn quá -> giảm giá trị (dịch right qua trái)
            }
        }

        return result;
    }
}