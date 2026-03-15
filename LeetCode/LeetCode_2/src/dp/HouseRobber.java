package dp;

/**
 * Bài toán: House Robber (Kẻ trộm nhà).
 * <br>
 * Mục tiêu: Ăn trộm tiền tối đa từ các ngôi nhà dọc theo con phố. Không được trộm 2 nhà liền kề (báo động).
 * <br>
 * Giải thuật: Dynamic Programming.
 * <br>
 * Tư duy:
 * - Tại nhà thứ i, ta có 2 lựa chọn:
 *   1. Trộm nhà i: Thì không được trộm nhà i-1 -> Tổng tiền = `nums[i] + dp[i-2]`.
 *   2. Không trộm nhà i: Thì tổng tiền bằng tổng tiền tại nhà i-1 -> `dp[i-1]`.
 * - Công thức: `dp[i] = max(dp[i-1], nums[i] + dp[i-2])`.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(n) (hoặc O(1) nếu tối ưu).
 */
public class HouseRobber {

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;       // dp[i-2]
        int prev1 = 0;       // dp[i-1]

        for (int num : nums) {
            int temp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}

