import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDfs {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, visited, adj, stack);
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!stack.isEmpty())
            list.add(stack.pop());

        return list;
    }

    private void dfs(int start, boolean[] visited, List<List<Integer>> adj, Stack<Integer> stack) {
        visited[start] = true;

        for (int neigh : adj.get(start)) {
            if (!visited[neigh]) {
                visited[neigh] = true;
                dfs(neigh, visited, adj, stack);
            }
        }

        stack.push(start);
    }
}
