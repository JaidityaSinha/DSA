import java.sql.Array;
import java.util.*;

public class AccountsMerge {
    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                size.add(1);
                parent.add(i);
            }
        }

        public int findUltPar(int node) {
            if (node == parent.get(node))
                return node;

            int ultPar = findUltPar(parent.get(node));
            parent.set(node, ultPar);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ultPar_u = findUltPar(u);
            int ultPar_v = findUltPar(v);

            if (ultPar_u == ultPar_v)
                return;

            if (size.get(ultPar_u) < size.get(ultPar_v)) {
                parent.set(ultPar_u, ultPar_v);
                size.set(ultPar_v, size.get(ultPar_v) + size.get(ultPar_u));
            }

            else {
                parent.set(ultPar_v, ultPar_u);
                size.set(ultPar_u, size.get(ultPar_u) + size.get(ultPar_v));
            }
        }

        public void unionByRank(int u, int  v) {
            int ultPar_u = findUltPar(u);
            int ultPar_v = findUltPar(v);

            if (ultPar_u == ultPar_v)
                return;

            if (rank.get(ultPar_u) < rank.get(ultPar_v))
                parent.set(ultPar_u, ultPar_v);

            else if (rank.get(ultPar_v) < rank.get(ultPar_u))
                parent.set(ultPar_v, ultPar_u);

            else if (rank.get(ultPar_u).equals(rank.get(ultPar_v))) {
                parent.set(ultPar_v, ultPar_u);
                int rankU = rank.get(ultPar_u);
                rank.set(ultPar_u, rankU + 1);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail))
                    map.put(mail, i);
                else
                    ds.unionBySize(i, map.get(mail));
            }
        }

        List<List<String>> mergeMail = new ArrayList<>();

        for (int i = 0; i < n; i++)
            mergeMail.add(new ArrayList<>());

        for (var entry : map.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findUltPar(entry.getValue());
            mergeMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergeMail.get(i).isEmpty())
                continue;

            Collections.sort(mergeMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).getFirst());
            temp.addAll(mergeMail.get(i));
            ans.add(temp);
        }

        return ans;
    }
}
