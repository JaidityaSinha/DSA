import java.util.*;

public class BreadthFirstSearch {
    public List<Integer> bfs(List<List<Integer>> adj) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            list.add(curr);

            for (int node : adj.get(curr))
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
        }

        return list;
    }
}
