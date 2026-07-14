import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LargestIsland {
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

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        // Connecting Components
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue;

                int[] dr = {1,-1,0,0};
                int[] dc = {0,0,-1,1};

                for (int i = 0; i < 4; i++) {
                    int nR = row + dr[i];
                    int nC = col + dc[i];

                    if (nR >= 0 && nR < n && nC >= 0 && nC < n && grid[nR][nC] == 1) {
                        int node = (n * row) + col;
                        int adjNode = (n * nR) + nC;

                        ds.unionBySize(node, adjNode);
                    }
                }
            }

        }

        int max = 0;
        // Finding size after converting every zero and taking maz of them
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;

                int[] dr = {1,-1,0,0};
                int[] dc = {0,0,-1,1};

                HashSet<Integer> set = new HashSet<>();

                for (int i = 0; i < 4; i++) {
                    int nR = row + dr[i];
                    int nC = col + dc[i];


                    if (nR >= 0 && nR < n && nC >= 0 && nC < n && grid[nR][nC] == 1) {
                        int adjNode = (n * nR) + nC;
                        set.add(ds.findUltPar(adjNode));
                    }
                }
                int sizeTotal = 0;
                for (Integer parent : set)
                    sizeTotal += ds.size.get(parent);

                max = Math.max(max, sizeTotal + 1);
            }
        }

        for (int node = 0; node < n * n; node++) {
            max = Math.max(max, ds.size.get(ds.findUltPar(node)));
        }

        return max;
    }
}
