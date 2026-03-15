package tree;

import util.TreeNode;

/**
 * Bài toán: Maximum Depth of Binary Tree (Độ sâu lớn nhất của cây).
 * <br>
 * Mục tiêu: Tìm số lượng node trên đường đi dài nhất từ gốc đến lá.
 * <br>
 * Giải thuật: DFS Recursion (Đệ quy).
 * <br>
 * Tư duy:
 * - Nếu node null (cây rỗng) -> độ sâu là 0.
 * - Nếu không, độ sâu = 1 (node hiện tại) + max(độ sâu con trái, độ sâu con phải).
 * - Bài toán chia nhỏ thành bài toán con tính độ sâu của 2 nhánh con.
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt qua mỗi node 1 lần.
 * - Space: O(h) - Chiều cao của cây (stack đệ quy). Trong trường hợp xấu nhất (cây lệch) là O(n).
 */
public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}