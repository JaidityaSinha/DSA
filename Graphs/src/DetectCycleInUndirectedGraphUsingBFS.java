import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraphUsingBFS {
    static class Node {
        int node, parent;

        public Node(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (checkForCycle(i, adj, visited))
                    return true;
        }

        return false;
    }

    private boolean checkForCycle(int source, List<List<Integer>> adj, boolean[] visited) {
        visited[source] = true;

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(source, -1));

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            int node = curr.node;
            int parent = curr.parent;

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(new Node(neighbour, node));
                }
                else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}
