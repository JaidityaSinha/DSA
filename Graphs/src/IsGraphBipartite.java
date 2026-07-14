import java.util.*;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph[i].length; j++)
                adj.get(i).add(graph[i][j]);

        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);

        for (int i = 0; i < adj.size(); i++) {
            if (color[i] == -1) {
                if (!check(i, adj, color))
                    return false;
            }
        }

        return true;
    }

    private boolean check(int start, List<List<Integer>> adj, int[] color) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for (int neigh : adj.get(curr)) {
                if (color[neigh] == -1) {
                    if (color[curr] == 0)
                        color[neigh] = 1;
                    else
                        color[neigh] = 0;

                    queue.add(neigh);
                }
                else if (color[curr] == color[neigh]) {
                    return false;
                }
            }
        }

        return true;
    }
}
