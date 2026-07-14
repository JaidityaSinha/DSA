import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CountScc {
    public int kosaraju(int V, int[][] edges) {
        boolean[] visited = new boolean[V];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++)
            if (!visited[i])
                dfsAndStore(i, visited, adj, stack);

        List<List<Integer>> reverseAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseAdj.add(new ArrayList<>());
        }

        for (int[] edge : edges)
            reverseAdj.get(edge[1]).add(edge[0]);

        Arrays.fill(visited, false);
        int scc = 0;

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (!visited[curr]) {
                scc++;
                dfs(curr, visited, reverseAdj);
            }
        }

        return scc;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> reverseAdj) {
        visited[node] = true;

        for (int neigh : reverseAdj.get(node)) {
            if (!visited[neigh])
                dfs(neigh, visited, reverseAdj);
        }
    }

    private void dfsAndStore(int node, boolean[] visited, List<List<Integer>> adj, Stack<Integer> stack) {
        visited[node] = true;

        for (int neigh :  adj.get(node)) {
            if (!visited[neigh])
                dfsAndStore(neigh, visited, adj, stack);
        }

        stack.push(node);
    }
}
