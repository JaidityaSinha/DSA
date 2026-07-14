import java.util.*;

public class CheapestFlightsWithinKStops {
    static class Triad {
        int node, cost, stops;

        public Triad(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    static class WeightPair {
        int node, cost;

        public WeightPair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<WeightPair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : flights) {
            adj.get(edge[0]).add(new WeightPair(edge[1], edge[2]));
        }

        int[] cost = new int[n];
        Arrays.fill(cost, (int)1e9);
        cost[src] = 0;

        Queue<Triad> queue = new ArrayDeque<>();

        queue.add(new Triad(src, cost[src], 0));

        while (!queue.isEmpty()) {
            Triad curr = queue.remove();

            if (curr.stops == k + 1) {
                continue;
            }

            for (WeightPair neigh : adj.get(curr.node)) {
                if (cost[neigh.node] > curr.cost + neigh.cost) {
                    cost[neigh.node] = curr.cost + neigh.cost;
                    queue.add(new Triad(neigh.node, cost[neigh.node], curr.stops + 1));
                }
            }
        }

        int ans = cost[dst];

        return (ans == (int)1e9) ? -1 : ans;
    }
}
