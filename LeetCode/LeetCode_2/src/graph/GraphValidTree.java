package graph;

import java.util.*;

/**
 * Bài toán: Graph Valid Tree (Đồ thị là cây hợp lệ).
 * <br>
 * Mục tiêu: Kiểm tra xem một đồ thị vô hướng có phải là cây không (liên thông và không có chu trình).
 * <br>
 * Giải thuật: Union-Find (Disjoint Set) hoặc DFS/BFS.
 * <br>
 * Tư duy (Union-Find):
 * - Đồ thị là cây khi số cạnh E = V - 1 và liên thông.
 * - Hoặc: Không có chu trình và liên thông.
 * - Duyệt qua các cạnh, union 2 đỉnh.
 * - Nếu 2 đỉnh đã cùng 1 set -> Có chu trình -> False.
 * - Sau khi duyệt hết cạnh, nếu số thành phần liên thông == 1 -> True.
 * <br>
 * Độ phức tạp:
 * - Time: O(E * alpha(V)) ~ O(E).
 * - Space: O(V).
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {

        // Điều kiện cần: Cây có n đỉnh thì phải có n-1 cạnh
        if (edges.length != n - 1) return false;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // Nếu đã chung gốc -> có chu trình
            if (rootU == rootV) return false;

            // Gộp 2 set
            parent[rootU] = rootV;
            components--;
        }

        // Đã check E = n-1, nếu không có chu trình thì chắc chắn liên thông
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]); // Path compression
    }
}

