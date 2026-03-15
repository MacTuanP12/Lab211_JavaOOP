package graph;

import java.util.*;

/**
 * Bài toán: Course Schedule (Lịch học).
 * <br>
 * Mục tiêu: Kiểm tra xem có thể hoàn thành tất cả các khóa học không (có tồn tại thứ tự học hợp lệ không).
 * Bài toán tương đương với việc kiểm tra đồ thị có chu trình (cycle) hay không.
 * <br>
 * Giải thuật: Topological Sort (Kahn's Algorithm - BFS).
 * <br>
 * Tư duy:
 * - Xây dựng đồ thị và mảng `indegree` (bán bậc vào - số khóa học tiên quyết).
 * - Thêm các node có indegree = 0 vào Queue (các khóa học có thể học ngay).
 * - Khi học xong 1 khóa (poll từ Queue), giảm indegree của các khóa học phụ thuộc nó.
 * - Nếu khóa phụ thuộc có indegree về 0 -> thêm vào Queue.
 * - Đếm số lượng khóa học đã lấy ra khỏi Queue. Nếu bằng tổng số khóa học -> True.
 * <br>
 * Độ phức tạp:
 * - Time: O(V + E).
 * - Space: O(V + E).
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            adjacency.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int nextCourse : adjacency.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return count == numCourses;
    }
}

