package graph;

import java.util.*;

/**
 * Bài toán: Course Schedule II (Lịch học II).
 * <br>
 * Mục tiêu: Trả về thứ tự các khóa học để hoàn thành tất cả.
 * <br>
 * Giải thuật: Topological Sort (Kahn's Algorithm).
 * <br>
 * Tư duy:
 * - Tương tự bài Course Schedule I.
 * - Thay vì chỉ đếm, ta lưu các node lấy ra từ Queue vào danh sách kết quả `order`.
 * - Nếu số lượng trong `order` khác `numCourses` -> có chu trình -> trả về mảng rỗng.
 * <br>
 * Độ phức tạp:
 * - Time: O(V + E).
 * - Space: O(V + E).
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

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

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int nextCourse : adjacency.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}

