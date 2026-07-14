import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithmUsingPQ {
    private static class Pair {
        int dist, node;

        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    private static class WeightPair {
        int node, weight;

        public WeightPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
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

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.dist, b.dist)
        );

        int[] dist = new int[V];

        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        priorityQueue.add(new Pair(0, src));

        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();

            if (curr.dist > dist[curr.node])
                continue;

            for (WeightPair neighPair : adj.get(curr.node)) {
                if (dist[neighPair.node] > curr.dist + neighPair.weight) {
                    dist[neighPair.node] = curr.dist + neighPair.weight;
                    priorityQueue.add(new Pair(dist[neighPair.node], neighPair.node));
                }
            }
        }

        return dist;
    }
}
