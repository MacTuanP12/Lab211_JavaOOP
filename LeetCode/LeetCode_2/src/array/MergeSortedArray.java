package array;

/**
 * Bài toán: Merge Sorted Array (Gộp hai mảng đã sắp xếp).
 * <br>
 * Mục tiêu: Gộp mảng nums2 vào nums1 sao cho kết quả vẫn được sắp xếp tăng dần.
 * Mảng nums1 có kích thước bằng m + n, trong đó m phần tử đầu là dữ liệu, n phần tử sau là 0 (để trống).
 * <br>
 * Giải thuật: Two Pointers from End (Hai con trỏ từ cuối).
 * <br>
 * Tư duy:
 * - Nếu gộp từ đầu, ta phải dịch chuyển các phần tử của nums1 để chèn nums2 vào -> O(n*m).
 * - Để tối ưu O(n+m), ta điền từ cuối mảng nums1 về đầu.
 * - So sánh phần tử cuối cùng của phần dữ liệu 2 mảng (nums1[m-1] và nums2[n-1]).
 * - Lấy phần tử lớn hơn đặt vào vị trí cuối cùng của nums1 (nums1[m+n-1]).
 * - Giảm chỉ số tương ứng.
 * <br>
 * Độ phức tạp:
 * - Time: O(n + m) - Duyệt qua mỗi phần tử cao nhất 1 lần.
 * - Space: O(1) - Thao tác trực tiếp trên nums1.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;       // Con trỏ cuối phần dữ liệu nums1
        int p2 = n - 1;       // Con trỏ cuối nums2
        int p = m + n - 1;    // Con trỏ vị trí điền vào nums1

        while (p1 >= 0 && p2 >= 0) {
            // So sánh và điền từ cuối lên
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Nếu nums2 còn phần tử (nums1 hết trước), copy nốt vào đầu nums1
        // (Nếu nums1 còn thì không cần làm gì vì nó đã ở đúng vị trí)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}

