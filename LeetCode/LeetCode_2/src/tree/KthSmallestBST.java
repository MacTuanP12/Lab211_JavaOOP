package tree;

import util.TreeNode;
import java.util.Stack;

/**
 * Bài toán: Kth Smallest Element in a BST (Phần tử nhỏ thứ K trong BST).
 * <br>
 * Mục tiêu: Tìm giá trị node nhỏ thứ k trong cây nhị phân tìm kiếm (BST).
 * <br>
 * Giải thuật: Inorder Traversal (Duyệt trung thứ tự).
 * <br>
 * Tư duy:
 * - Tính chất BST: Duyệt Inorder (Left -> Root -> Right) sẽ cho danh sách các giá trị tăng dần.
 * - Duyệt, đếm số node đã thăm.
 * - Khi đếm đến k -> trả về giá trị node đó.
 * - Có thể dùng đệ quy hoặc stack (Iterative). Stack giúp dừng sớm dễ hơn.
 * <br>
 * Độ phức tạp:
 * - Time: O(H + k).
 * - Space: O(H).
 */
public class KthSmallestBST {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;

            if (count == k) return curr.val;

            curr = curr.right;
        }

        return -1;
    }
}

