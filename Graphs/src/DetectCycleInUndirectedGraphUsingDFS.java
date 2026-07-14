import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraphUsingDFS {
    static class Pair {
        int node, parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (checkForCycle(adj, new Pair(i, -1), visited))
                    return true;
        }

        return false;
    }

    private boolean checkForCycle(List<List<Integer>> adj, Pair pair, boolean[] visited) {
        int start = pair.node;
        int parent = pair.parent;

        visited[start] = true;

        for (int neighbour : adj.get(start)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                if (checkForCycle(adj, new Pair(neighbour, start), visited))
                    return true;
            }
            else if (neighbour != parent)
                return true;
        }

        return false;
    }
}
