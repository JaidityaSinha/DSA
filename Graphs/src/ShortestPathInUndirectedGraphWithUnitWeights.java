import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for (int neigh : adj.get(curr)) {
                if (dist[neigh] > dist[curr] + 1) {
                    dist[neigh] = dist[curr] + 1;
                    queue.add(neigh);
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == (int)1e9)
                dist[i] = -1;
        }

        return dist;
    }
}
