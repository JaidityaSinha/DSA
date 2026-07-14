import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int num : adj.get(i))
                indegree[num]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for (int neigh : adj.get(curr)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    queue.add(neigh);
            }

            list.add(curr);
        }

        if (list.size() == numCourses) {
            int[] array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            return array;
        }

        else
            return new int[0];
    }
}
