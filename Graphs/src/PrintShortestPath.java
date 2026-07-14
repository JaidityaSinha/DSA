import java.util.*;

public class PrintShortestPath {
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

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<WeightPair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new WeightPair(edge[1], edge[2]));
            adj.get(edge[1]).add(new WeightPair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.dist, b.dist)
        );

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Arrays.fill(dist, (int)1e9);
        dist[1] = 0;
        priorityQueue.add(new Pair(0, 1));

        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();

            if (curr.dist > dist[curr.node])
                continue;

            for (WeightPair neighPair : adj.get(curr.node)) {
                if (dist[neighPair.node] > curr.dist + neighPair.weight) {
                    dist[neighPair.node] = curr.dist + neighPair.weight;
                    priorityQueue.add(new Pair(dist[neighPair.node], neighPair.node));
                    parent[neighPair.node] = curr.node;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (dist[dist.length - 1] == (int)1e9) {
            ans.add(-1);
            return ans;
        }

        int i = parent.length - 1;
        while (parent[i] != i) {
            ans.add(i);
            i = parent[i];
        }

        ans.add(1);
        ans.add(dist[dist.length - 1]);

        Collections.reverse(ans);

        return ans;
    }
}
