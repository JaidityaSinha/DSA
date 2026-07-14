import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {
    boolean graphColoring(int v, int[][] edges, int m) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];

            adjList.get(u).add(w);
            adjList.get(w).add(u);
        }

        int[] color = new int[v];


        return backtrack(0, adjList, color, v, m);
    }

    private boolean backtrack(int node, List<List<Integer>> adjList, int[] color, int v, int m) {
        if (node == v)
            return true;

        for (int col = 1; col <= m; col++) {
            if (isSafe(node, adjList, color, col)) {
                color[node] = col;

                if (backtrack(node + 1, adjList, color, v, m))
                    return true;

                color[node] = 0;
            }

        }

        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> adjList, int[] color, int col) {
        for (int neigh : adjList.get(node))
            if (color[neigh] == col)
                return false;

        return true;
    }

}
