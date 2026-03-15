package array;

/**
 * Bài toán: Best Time to Buy and Sell Stock (Thời điểm tốt nhất để mua bán chứng khoán).
 * <br>
 * Mục tiêu: Tìm lợi nhuận lớn nhất bằng cách chọn 1 ngày mua và 1 ngày bán (ngày bán phải sau ngày mua).
 * <br>
 * Giải thuật: One Pass (Duyệt 1 lần).
 * <br>
 * Tư duy:
 * - Thay vì dùng 2 vòng lặp (O(n^2)), ta chỉ cần duyệt qua mảng 1 lần.
 * - Duy trì một biến `minPrice` để lưu giá thấp nhất đã gặp từ đầu đến hiện tại.
 * - Tại mỗi ngày, nếu bán ra hôm nay thì lợi nhuận là `giá_hôm_nay - minPrice`.
 * - Cập nhật `maxProfit` nếu lợi nhuận hôm nay cao hơn.
 * - Nếu giá hôm nay thấp hơn `minPrice`, cập nhật `minPrice` mới.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt qua mảng 1 lần.
 * - Space: O(1) - Chỉ dùng biến đơn.
 */
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Nếu tìm thấy giá mua thấp hơn, cập nhật minPrice
            if (price < minPrice) {
                minPrice = price;
            }
            // Nếu bán hôm nay có lãi cao hơn, cập nhật maxProfit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

