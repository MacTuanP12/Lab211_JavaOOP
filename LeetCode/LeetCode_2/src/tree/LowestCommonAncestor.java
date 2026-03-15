package tree;

import util.TreeNode;

/**
 * Bài toán: Lowest Common Ancestor of a Binary Tree (Tổ tiên chung gần nhất).
 * <br>
 * Mục tiêu: Tìm node tổ tiên chung thấp nhất của 2 node p và q trong cây.
 * <br>
 * Giải thuật: DFS Recursion (Đệ quy).
 * <br>
 * Tư duy:
 * - Nếu root là p hoặc q (hoặc null) -> trả về root. (Tìm thấy hoặc đi vào ngõ cụt).
 * - Tìm đệ quy bên trái và bên phải.
 * - Nếu cả 2 bên đều trả về khác null -> p và q nằm ở 2 nhánh khác nhau -> root là LCA.
 * - Nếu chỉ 1 bên trả về khác null -> p và q nằm cùng 1 nhánh đó -> trả về kết quả đó.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(h).
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}

