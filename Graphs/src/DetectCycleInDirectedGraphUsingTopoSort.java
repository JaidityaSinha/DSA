import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphUsingTopoSort {
    public boolean isCyclic(int V, int[][] edges) {
        int[] indegree = new int[V];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        for (int i = 0; i < V; i++) {
            for (int num : adj.get(i))
                indegree[num]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for (int neigh : adj.get(curr)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    queue.add(neigh);
            }

            list.add(curr);
        }

        return list.size() != V;
    }
}
