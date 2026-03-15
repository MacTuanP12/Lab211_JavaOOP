package tree;

import util.TreeNode;

/**
 * Bài toán: Diameter of Binary Tree (Đường kính của cây).
 * <br>
 * Mục tiêu: Tìm độ dài đường đi dài nhất giữa 2 node bất kỳ trong cây (có thể không đi qua root).
 * <br>
 * Giải thuật: DFS (Tính chiều cao).
 * <br>
 * Tư duy:
 * - Đường kính qua một node = chiều cao con trái + chiều cao con phải.
 * - Tính chiều cao của mỗi node.
 * - Tại mỗi node, cập nhật `maxDiameter`.
 * - Chiều cao trả về của hàm đệ quy là `max(left, right) + 1`.
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(h).
 */
public class DiameterBinaryTree {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        // Cập nhật đường kính lớn nhất đi qua node hiện tại
        maxDiameter = Math.max(maxDiameter, left + right);

        // Trả về chiều cao
        return Math.max(left, right) + 1;
    }
}

