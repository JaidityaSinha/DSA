import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStatesDfs {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited  = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        boolean[] check = new boolean[graph.length];

        List<Integer> safe = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, pathVisited, graph, check);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (check[i])
                safe.add(i);
        }

        return safe;
    }

    private boolean dfs(int start, boolean[] visited, boolean[] pathVisited, int[][] graph, boolean[] check) {
        visited[start] = true;
        pathVisited[start] = true;
        check[start] = false;

        for (int neigh : graph[start]) {
            if (!visited[neigh]) {
                if (dfs(neigh, visited, pathVisited, graph, check))
                    return true;
            }

            else if (visited[neigh] && pathVisited[neigh]) {
                return true;
            }
        }

        check[start] = true;
        pathVisited[start] = false;
        return false;
    }
}
