package tree;

import util.TreeNode;

/**
 * Bài toán: Invert Binary Tree (Đảo ngược cây nhị phân).
 * <br>
 * Mục tiêu: Hoán đổi cây con trái và cây con phải của mọi node trong cây.
 * <br>
 * Giải thuật: DFS Recursion (Đệ quy).
 * <br>
 * Tư duy:
 * - Nếu node null -> dừng.
 * - Hoán đổi left và right của node hiện tại.
 * - Gọi đệ quy cho con trái (lúc này đã đổi chỗ) và con phải.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(h).
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

