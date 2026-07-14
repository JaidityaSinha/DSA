import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> conn : connections) {
            int u = conn.getFirst(), v = conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, visited, adj, tin, low, bridges);

        return  bridges;
    }

    private void dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj
            , int[] tin, int[] low, List<List<Integer>> bridges) {

        visited[node] = true;
        tin[node] = low[node] = timer;
        timer++;

        for (int neigh : adj.get(node)) {
            if (neigh == parent)
                continue;
            if (!visited[neigh]) {
                dfs(neigh, node, visited, adj, tin, low, bridges);
                low[node]  = Math.min(low[node], low[neigh]);

                if (low[neigh] > tin[node]) {
                    bridges.add(Arrays.asList(neigh, node));
                }
            }

            else  {
                low[node] = Math.min(low[node], low[neigh]);
            }
        }
    }
}
