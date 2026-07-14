import org.w3c.dom.xpath.XPathResult;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrimsAlgorithm {
    static class Triad {
        int wt, node, parent;

        public Triad(int wt, int node, int parent) {
            this.wt = wt;
            this.node = node;
            this.parent = parent;
        }
    }

    static class WeightPair {
        int node, wt;

        public WeightPair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    static class Pair {
        int node, parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public int spanningTree(int V, int[][] edges) {
        List<Pair> mst = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int sum = 0;

        List<List<WeightPair>> adj = makeAdjList(edges, V);

        PriorityQueue<Triad> priorityQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.wt, b.wt)
        );

        priorityQueue.add(new Triad(0, 0, -1));

        while (!priorityQueue.isEmpty()) {
            Triad curr = priorityQueue.remove();

            if (visited[curr.node])
                continue;

            visited[curr.node] = true;
            sum += curr.wt;

            if (curr.parent != -1)
                mst.add(new Pair(curr.node, curr.parent));

            for (var neigh : adj.get(curr.node)) {
                if (!visited[neigh.node]) {
                    priorityQueue.add(new Triad(neigh.wt, neigh.node, curr.node));
                }
            }
        }

        return sum;
    }

    private List<List<WeightPair>> makeAdjList (int[][] edges, int V) {
        List<List<WeightPair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];

            adj.get(u).add(new WeightPair(v, wt));
            adj.get(v).add(new WeightPair(u, wt));
        }

        return adj;
    }
}
