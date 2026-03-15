package array;

/**
 * Bài toán: Container With Most Water (Bể chứa nước lớn nhất).
 * <br>
 * Mục tiêu: Tìm 2 đường thẳng sao cho cùng với trục hoành tạo thành bể chứa được nhiều nước nhất.
 * Diện tích = khoảng cách * chiều cao thấp hơn.
 * <br>
 * Giải thuật: Two Pointers (Hai con trỏ).
 * <br>
 * Tư duy:
 * - Bắt đầu với left = 0, right = n - 1 (bể rộng nhất).
 * - Tính diện tích hiện tại `(right - left) * min(h[left], h[right])`.
 * - Để có cơ hội tìm diện tích lớn hơn, ta cần giữ lại cột cao và bỏ cột thấp (vì cột thấp là yếu tố giới hạn chiều cao).
 * - Nếu h[left] < h[right] -> tăng left.
 * - Nếu h[left] >= h[right] -> giảm right.
 * - Lặp lại và cập nhật max area.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt mảng 1 lần.
 * - Space: O(1).
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int w = right - left;

            maxArea = Math.max(maxArea, h * w);

            // Di chuyển con trỏ cột thấp hơn
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

