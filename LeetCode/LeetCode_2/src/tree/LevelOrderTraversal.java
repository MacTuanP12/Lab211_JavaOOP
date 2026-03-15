package tree;

import util.TreeNode;
import java.util.*;

/**
 * Bài toán: Binary Tree Level Order Traversal (Duyệt cây theo mức).
 * <br>
 * Mục tiêu: Trả về danh sách các node theo từng tầng (từ trái qua phải).
 * <br>
 * Giải thuật: BFS (Breadth First Search - Duyệt theo chiều rộng) dùng Queue.
 * <br>
 * Tư duy:
 * - Dùng Queue để lưu các node cần duyệt.
 * - Tại mỗi vòng lặp, lấy size của Queue (số lượng node ở tầng hiện tại).
 * - Poll từng node ra, thêm vào list tầng hiện tại, và add con trái/phải của nó vào Queue (cho tầng sau).
 * <br>
 * Độ phức tạp:
 * - Time: O(n).
 * - Space: O(n) (độ rộng lớn nhất của cây).
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}

