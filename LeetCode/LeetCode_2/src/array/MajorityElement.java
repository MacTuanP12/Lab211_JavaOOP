package array;

/**
 * Bài toán: Majority Element (Phần tử đa số).
 * <br>
 * Mục tiêu: Tìm phần tử xuất hiện nhiều hơn n/2 lần trong mảng.
 * <br>
 * Giải thuật: Boyer-Moore Voting Algorithm.
 * <br>
 * Tư duy:
 * - Giả sử phần tử đa số là "vua".
 * - Duyệt qua mảng, duy trì một `candidate` và một `count`.
 * - Nếu `count` bằng 0, chọn phần tử hiện tại làm `candidate` mới.
 * - Nếu phần tử hiện tại giống `candidate`, tăng `count`. Ngược lại giảm `count` (triệt tiêu nhau).
 * - Vì "vua" chiếm quá nửa quân số, nên sau khi triệt tiêu hết các phe khác, "vua" vẫn còn sót lại.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt mảng 1 lần.
 * - Space: O(1) - Chỉ dùng biến đếm.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        int count = 0;
        Integer candidate = null;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

