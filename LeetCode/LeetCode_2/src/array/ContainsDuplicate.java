package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Bài toán: Contains Duplicate (Kiểm tra phần tử trùng lặp).
 * <br>
 * Mục tiêu: Kiểm tra xem trong mảng có bất kỳ số nào xuất hiện ít nhất 2 lần không.
 * <br>
 * Giải thuật: Hash Set.
 * <br>
 * Tư duy:
 * - Dùng HashSet để lưu các giá trị đã gặp.
 * - Duyệt qua từng phần tử của mảng.
 * - Nếu phần tử đã có trong Set -> Có trùng lặp -> return true.
 * - Nếu chưa có -> Thêm vào Set.
 * - Nếu duyệt hết mảng mà không thấy trùng -> return false.
 * - (Cách khác: Sort mảng rồi kiểm tra 2 phần tử kề nhau, Time O(n log n), Space O(1) hoặc O(log n)).
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt mảng, các thao tác với Set trung bình là O(1).
 * - Space: O(n) - Set lưu tối đa n phần tử.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}

