package array;

/**
 * Bài toán: Trapping Rain Water (Hứng nước mưa).
 * <br>
 * Mục tiêu: Tính tổng lượng nước có thể giữ được giữa các cột có chiều cao cho trước.
 * <br>
 * Giải thuật: Two Pointers (Hai con trỏ).
 * <br>
 * Tư duy:
 * - Lượng nước tại mỗi vị trí phụ thuộc vào min(max_left, max_right) - height[hien_tai].
 * - Dùng 2 con trỏ left và right chạy từ 2 đầu vào.
 * - Duy trì 2 biến leftMax và rightMax để theo dõi chiều cao lớn nhất từ 2 phía.
 * - Nếu height[left] < height[right], ta xử lý bên trái (vì chắc chắn bị chặn bởi bên phải cao hơn hoặc bằng),
 *   lượng nước tích được là leftMax - height[left] (nếu dương).
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - duyệt qua mảng 1 lần.
 * - Space: O(1) - chỉ dùng biến đơn.
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            // Nếu cột bên trái thấp hơn, xử lý bên trái
            // Nước đọng phụ thuộc vào cột chắn thấp hơn trong 2 bên
            if (height[left] < height[right]) {

                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    water += leftMax - height[left];

                left++;
            }

            // Ngược lại xử lý bên phải
            else {

                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];

                right--;
            }
        }

        return water;
    }
}