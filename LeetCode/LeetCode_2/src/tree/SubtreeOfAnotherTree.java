package tree;

import util.TreeNode;

/**
 * Bài toán: Subtree of Another Tree (Cây con của một cây khác).
 * <br>
 * Mục tiêu: Kiểm tra xem cây `subRoot` có phải là một phần của cây `root` không (giống hệt cấu trúc và giá trị).
 * <br>
 * Giải thuật: DFS Recursion.
 * <br>
 * Tư duy:
 * - Duyệt qua từng node của `root`.
 * - Tại mỗi node, kiểm tra xem cây con bắt đầu từ node đó có `isSameTrea` với `subRoot` không.
 * - Nếu `isSameTree` trả về true -> xong.
 * - Nếu không, tiếp tục kiểm tra con trái và con phải.
 * <br>
 * Độ phức tạp:
 * - Time: O(n * m) - Với n là số node của root, m là số node của subRoot.
 * - Space: O(h).
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

