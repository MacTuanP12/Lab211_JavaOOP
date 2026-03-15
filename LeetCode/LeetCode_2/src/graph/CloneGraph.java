package graph;

import util.GraphNode;
import java.util.*;

/**
 * Bài toán: Clone Graph (Sao chép đồ thị).
 * <br>
 * Mục tiêu: Tạo bản sao sâu (deep copy) của đồ thị vô hướng.
 * <br>
 * Giải thuật: DFS + Hash Map.
 * <br>
 * Tư duy:
 * - Dùng Map<NodeCu, NodeMoi> để lưu các node đã được sao chép.
 * - Duyệt DFS từ node ban đầu.
 * - Nếu node đã có trong map -> trả về node mới từ map (tránh lặp vô hạn và tái sử dụng node đã clone).
 * - Nếu chưa có:
 *   - Tạo node mới.
 *   - Lưu vào map.
 *   - Duyệt qua các neighbors, gọi để quy clone từng neighbor và add vào list neighbors của node mới.
 * <br>
 * Độ phức tạp:
 * - Time: O(V + E).
 * - Space: O(V).
 */
public class CloneGraph {

    private Map<GraphNode, GraphNode> map = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node)) {
            return map.get(node);
        }

        GraphNode cloneNode = new GraphNode(node.val);
        map.put(node, cloneNode);

        for (GraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}

