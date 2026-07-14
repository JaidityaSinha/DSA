import java.util.*;

public class EventualSafeStatesUsingTopo {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjReversed = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adjReversed.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int num : graph[i]) {
                adjReversed.get(num).add(i);
            }
        }

        int[] indegree = new int[adjReversed.size()];

        for (List<Integer> list : adjReversed) {
            for (int num : list) {
                indegree[num]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            for (var neigh : adjReversed.get(curr)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    queue.add(neigh);
            }

            ans.add(curr);
        }

        Collections.sort(ans);
        return ans;
    }
}
