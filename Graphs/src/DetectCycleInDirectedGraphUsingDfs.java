import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphUsingDfs {
    public boolean isCyclic(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        List<List<Integer>> adj = new ArrayList<>();

        // Adjacency List
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, adj))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(int start, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {
        visited[start] = true;
        pathVisited[start] = true;

        for (int neigh : adj.get(start)) {
            if (!visited[neigh]) {
                if (dfs(neigh, visited, pathVisited, adj))
                    return true;
            }

            else if (pathVisited[neigh]) {
                    return true;
            }
        }

        pathVisited[start] = false;
        return false;
    }
}
