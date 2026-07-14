import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    private static final int MOD_VALUE = 1_000_000_007;

    private static class Pair {
        int node;
        long dist;

        public Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    private static class WeightPair {
        int node, weight;

        public WeightPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<WeightPair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new WeightPair(road[1], road[2]));
            adj.get(road[1]).add(new WeightPair(road[0], road[2]));
        }

        int[] ways = new int[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0; ways[0] = 1;

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(
                (a, b) -> Long.compare(a.dist, b.dist)
        );
        priorityQueue.add(new Pair(0, dist[0]));

        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();

            for (WeightPair neigh : adj.get(curr.node)) {
                if (dist[neigh.node] > curr.dist + neigh.weight) {
                    dist[neigh.node] = curr.dist + neigh.weight;
                    priorityQueue.add(new Pair(neigh.node, dist[neigh.node]));
                    ways[neigh.node] = ways[curr.node];
                }

                else if (dist[neigh.node] == curr.dist + neigh.weight)
                    ways[neigh.node] = (ways[neigh.node] + ways[curr.node]) % MOD_VALUE;
            }
        }

        return ways[n - 1] % MOD_VALUE;
    }
}
