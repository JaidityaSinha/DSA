import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDag {
    static class Pair {
        int num, weight;

        public Pair(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        int source = 0;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, visited, adj, stack);

        }

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (dist[curr] == Integer.MAX_VALUE)
                continue;

            for (Pair pair : adj.get(curr)) {
                dist[pair.num] = Math.min(dist[pair.num], dist[curr] + pair.weight);
            }
        }

        for (int i = 0; i < dist.length; i++) {
            dist[i] = (dist[i] == Integer.MAX_VALUE) ? -1 : dist[i];
        }

        return dist;
    }

    private void dfs(int start, boolean[] visited, List<List<Pair>> adj, Stack<Integer> stack) {
        visited[start] = true;

        for (Pair neigh : adj.get(start)) {
            int node = neigh.num;
            if (!visited[node]) {
                visited[node] = true;
                dfs(node, visited, adj, stack);
            }
        }

        stack.push(start);
    }
}
