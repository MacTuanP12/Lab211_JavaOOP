package tree;

import util.TreeNode;
import java.util.*;

/**
 * Bài toán: Binary Tree Inorder Traversal (Duyệt cây trung thứ tự).
 * <br>
 * Mục tiêu: Duyệt cây nhị phân theo thứ tự Inorder (Left -> Root -> Right).
 * <br>
 * Giải thuật: DFS Recursion (Đệ quy).
 * <br>
 * Tư duy:
 * - Nếu node hiện tại null -> dừng.
 * - Gọi đệ quy duyệt cây con bên trái.
 * - Xử lý (thêm vào list) giá trị của node hiện tại.
 * - Gọi đệ quy duyệt cây con bên phải.
 * - Kết quả là danh sách các giá trị được sắp xếp tăng dần (nếu là cây nhị phân tìm kiếm BST).
 * <br>
 * Độ phức tạp:
 * - Time: O(n) - Duyệt qua mỗi node 1 lần.
 * - Space: O(h) - Chiều cao của cây (stack đệ quy).
 */
public class BinaryTreeTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {

        if (node == null)
            return;

        inorder(node.left, result);  // L

        result.add(node.val);        // Node

        inorder(node.right, result); // R
    }
}