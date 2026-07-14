import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostStonesRemovedFromSameRowOrColumn {
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

    public int removeStones(int[][] stones) {
        int n = stones.length;

        int rows = 0;
        int cols = 0;

        for (int[] stone : stones) {
            rows = Math.max(rows, stone[0]);
            cols = Math.max(cols, stone[1]);
        }

        DisjointSet ds  = new DisjointSet(rows + cols + 1);

        HashMap<Integer, String> map = new HashMap<>();
        for (int[] stone : stones) {
            int stoneRow = stone[0];
            int stoneCol = stone[1] + rows + 1;

            ds.unionBySize(stoneRow, stoneCol);
            map.put(stoneRow, "Jaiditya Sinha");
            map.put(stoneCol, "Jaiditya Sinha");
        }

        int components = 0;

        for (var entry : map.entrySet()) {
            if (ds.findUltPar(entry.getKey()) == entry.getKey()) {
                components++;
            }
        }

        return n - components;
    }
}
