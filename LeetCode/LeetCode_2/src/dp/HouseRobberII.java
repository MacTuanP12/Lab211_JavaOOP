package dp;

import java.util.Arrays;

/**
 * Bài toán: House Robber II (Kẻ trộm nhà II).
 * <br>
 * Mục tiêu: Giống bài I nhưng các ngôi nhà xếp thành vòng tròn (nhà đầu và nhà cuối liền nhau).
 * <br>
 * Giải thuật: Dynamic Programming.
 * <br>
 * Tư duy:
 * - Vì nhà đầu và cuối liền nhau, nên không thể trộm cả 2 cùng lúc.
 * - Bài toán chia làm 2 trường hợp con (dạng bài House Robber I):
 *   1. Trộm từ nhà 0 đến n-2 (bỏ nhà cuối).
 *   2. Trộm từ nhà 1 đến n-1 (bỏ nhà đầu).
 * - Kết quả là max của 2 trường hợp trên.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(1).
 */
public class HouseRobberII {

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // 1. Rob houses 0 to n-2
        int max1 = robSimple(nums, 0, nums.length - 2);

        // 2. Rob houses 1 to n-1
        int max2 = robSimple(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    private int robSimple(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}

