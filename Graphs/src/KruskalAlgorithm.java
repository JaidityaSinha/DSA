import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalAlgorithm {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findUlp(int node) {
            if (parent.get(node) == node)
                return node;
            int ultPar = findUlp(parent.get(node));

            parent.set(node, ultPar);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ultPar_u = findUlp(u);
            int ultPar_v = findUlp(v);

            if (ultPar_u == ultPar_v)
                return;

            if (rank.get(ultPar_u) < rank.get(ultPar_v)) {
                parent.set(ultPar_u, ultPar_v);
            }
            else if (rank.get(ultPar_v) < rank.get(ultPar_u)) {
                parent.set(ultPar_v, ultPar_u);
            }
            else {
                parent.set(ultPar_u, ultPar_v);
                rank.set(ultPar_v, rank.get(ultPar_v) + 1);
            }
        }
    }

    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (ds.findUlp(u) != ds.findUlp(v)) {
                mstWt += wt;
                ds.unionByRank(u, v);
            }
        }

        return mstWt;
    }
}
