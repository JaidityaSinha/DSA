import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[0] = true;

        dfs(0, visited, adj, list);

        return list;
    }

    private void dfs(int node, boolean[] visited,
                     ArrayList<ArrayList<Integer>> adj, List<Integer> list) {

        visited[node] = true;
        list.add(node);

        for (var graphNode : adj.get(node)) {
            if (!visited[graphNode]) {
                visited[graphNode] = true;
                dfs(graphNode, visited, adj, list);
            }
        }
    }
}
