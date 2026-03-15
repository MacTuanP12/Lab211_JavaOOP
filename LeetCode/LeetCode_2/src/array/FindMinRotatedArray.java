package array;

/**
 * Bài toán: Find Minimum in Rotated Sorted Array (Tìm giá trị nhỏ nhất trong mảng đã xoay).
 * <br>
 * Mục tiêu: Tìm phần tử nhỏ nhất trong mảng đã được sắp xếp tăng dần rồi bị xoay tại một điểm nào đó.
 * Ví dụ: [3,4,5,1,2]. Min là 1.
 * <br>
 * Giải thuật: Binary Search (Tìm kiếm nhị phân).
 * <br>
 * Tư duy:
 * - Mảng xoay chia làm 2 phần đều tăng dần. Điểm gãy (pivot) là nơi chứa min.
 * - So sánh nums[mid] với nums[right].
 * - Nếu nums[mid] > nums[right]:
 *   => Min nằm bên phải (vì đoạn mid->right bị gẫy, không tăng dần liên tục).
 *   => left = mid + 1.
 * - Nếu nums[mid] < nums[right]:
 *   => Đoạn từ mid->right tăng dần đều => Min nằm bên trái (hoặc chính là mid).
 *   => right = mid (không trừ 1 vì mid có thể là min).
 * - Kết thúc khi left == right.
 * <br>
 * Độ phức tạp:
 * - Time: O(log n).
 * - Space: O(1).
 */
public class FindMinRotatedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Min nằm bên phải
                left = mid + 1;
            } else {
                // Min nằm bên trái hoặc chính là mid
                right = mid;
            }
        }

        return nums[left];
    }
}

