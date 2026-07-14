import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String[] words) {
        int K = 26;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] exists = new boolean[26];

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        int totalChars = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!exists[ch - 'a']) {
                    exists[ch - 'a'] = true;
                    totalChars++;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());

            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {

                    int u = s1.charAt(ptr) - 'a';
                    int v = s2.charAt(ptr) - 'a';

                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                    }

                    break;
                }
            }
        }

        List<Integer> topo = topoSort(adj, exists);

        if (topo.size() != totalChars) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int node : topo) {
            sb.append((char) (node + 'a'));
        }

        return sb.toString();
    }

    private List<Integer> topoSort(List<List<Integer>> adj, boolean[] exists) { // CHANGED
        int[] indegree = new int[adj.size()];

        for (List<Integer> list : adj) {
            for (int num : list)
                indegree[num]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> topoList = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            if (exists[i] && indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            topoList.add(curr);

            for (int neigh : adj.get(curr)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    queue.add(neigh);
            }
        }

        return topoList;
    }
}
