import java.util.*;

public class DijkstraAlgorithmUsingSet {
    private static class WeightPair {
        int node, weight;

        public WeightPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class Pair {
        int node, distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<WeightPair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new WeightPair(edge[1], edge[2]));
            adj.get(edge[1]).add(new WeightPair(edge[0], edge[2]));
        }

        TreeSet<Pair> set = new TreeSet<>(
                (a, b) -> {
                    if (a.distance != b.distance)
                        return Integer.compare(a.distance, b.distance);

                    return Integer.compare(a.node, b.node);
                }
        );
        int[] dist = new int[V];

        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        set.add(new Pair(src, dist[src]));

        while (!set.isEmpty()) {
            Pair curr = set.removeFirst();

            if (curr.distance > dist[curr.node])
                continue;

            for (WeightPair neigh : adj.get(curr.node)) {
                if (dist[neigh.node] > curr.distance + neigh.weight) {
                    dist[neigh.node] = curr.distance + neigh.weight;
                    set.add(new Pair(neigh.node, dist[neigh.node]));
                }
            }
        }

        return dist;
    }
}
