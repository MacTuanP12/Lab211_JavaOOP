package array;

/**
 * Bài toán: Search in Rotated Sorted Array (Tìm kiếm trong mảng đã xoay).
 * <br>
 * Mục tiêu: Tìm chỉ số của target trong mảng sorted xoay. Nếu không có trả về -1.
 * <br>
 * Giải thuật: Binary Search (Cải tiến).
 * <br>
 * Tư duy:
 * - Mảng xoay luôn có ít nhất một nửa là đã sắp xếp (sorted).
 * - Kiểm tra xem nửa trái [left...mid] có sorted không (dựa vào nums[left] <= nums[mid]).
 * - Nếu nửa trái sorted:
 *   - Kiểm tra target có nằm trong khoảng [left, mid] không.
 *   - Nếu có -> tìm bên trái (right = mid - 1).
 *   - Nếu không -> tìm bên phải (left = mid + 1).
 * - Nếu nửa trái không sorted (thì nửa phải chắc chắn sorted):
 *   - Kiểm tra target có nằm trong khoảng [mid, right] không.
 *   - Nếu có -> tìm bên phải (left = mid + 1).
 *   - Nếu không -> tìm bên trái (right = mid - 1).
 * <br>
 * Độ phức tạp:
 * - Time: O(log n).
 * - Space: O(1).
 */
public class SearchRotatedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Kiểm tra xem nửa trái có sorted không
            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target nằm bên trái
                } else {
                    left = mid + 1;  // Target nằm trong nửa phải
                }

            }
            // Ngược lại nửa phải sorted
            else {

                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Target nằm trong nửa phải
                } else {
                    right = mid - 1; // Target nằm bên trái
                }
            }
        }

        return -1;
    }
}

