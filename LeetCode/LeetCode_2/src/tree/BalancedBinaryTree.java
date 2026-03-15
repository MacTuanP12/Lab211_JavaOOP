package tree;

import util.TreeNode;

/**
 * Bài toán: Balanced Binary Tree (Cây cân bằng).
 * <br>
 * Mục tiêu: Kiểm tra xem cây có cân bằng về chiều cao không (độ lệch chiều cao con trái và phải không quá 1 cho mọi node).
 * <br>
 * Giải thuật: DFS (Bottom-up).
 * <br>
 * Tư duy:
 * - Hàm tính chiều cao trả về chiều cao cây nếu cân bằng, trả về -1 nếu không cân bằng.
 * - Tại mỗi node, lấy chiều cao trái, chiều cao phải.
 * - Nếu con trái hoặc con phải trả về -1 (không cân bằng) -> return -1.
 * - Nếu chênh lệch > 1 -> return -1.
 * - Nếu ổn, trả về max(left, right) + 1.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(h).
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Tảo hoả nhập ma ở nhánh trái

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Tảo hoả nhập ma ở nhánh phải

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

