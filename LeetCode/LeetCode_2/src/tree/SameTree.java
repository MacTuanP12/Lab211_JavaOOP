package tree;

import util.TreeNode;

/**
 * Bài toán: Same Tree (Kiểm tra hai cây giống nhau).
 * <br>
 * Mục tiêu: Kiểm tra xem hai cây p và q có cấu trúc giống hệt nhau và các giá trị tại mỗi node tương ứng cũng bằng nhau không.
 * <br>
 * Giải thuật: DFS Recursion (Đệ quy).
 * <br>
 * Tư duy:
 * - Nếu cả 2 cây đều null -> true.
 * - Nếu chỉ 1 trong 2 cây null -> false.
 * - Nếu giá trị 2 node khác nhau -> false.
 * - Đệ quy kiểm tra cây con trái và cây con phải.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt qua tất cả các node.
 * - Space: O(h) - Chiều cao cây.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

