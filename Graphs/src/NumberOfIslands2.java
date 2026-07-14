import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findUltPar(int node) {
            if (parent.get(node) == node)
                return node;
            int ultPar = findUltPar(parent.get(node));

            parent.set(node, ultPar);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ultPar_u = findUltPar(u);
            int ultPar_v = findUltPar(v);

            if (ultPar_u == ultPar_v)
                return;

            if (rank.get(ultPar_u) < rank.get(ultPar_v))
                parent.set(ultPar_u, ultPar_v);
            else if (rank.get(ultPar_v) < rank.get(ultPar_u))
                parent.set(ultPar_v, ultPar_u);
            else {
                parent.set(ultPar_u, ultPar_v);
                rank.set(ultPar_v, 1 + rank.get(ultPar_v));
            }
        }
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        boolean[] visited = new boolean[rows * cols];
        int count = 0;

        DisjointSet ds = new DisjointSet(rows * cols);

        int[] delRow = {-1,1,0,0};
        int[] delCol = {0,0,-1,1};
        List<Integer> answer = new ArrayList<>();

        for (int[] op : operators) {
            int r = op[0], c = op[1];
            int node = (r * cols) + c;

            if (visited[node]) {
                answer.add(count);
                continue;
            }

            visited[node] = true;
            count++;


            for (int i = 0; i < 4; i++) {
                int nR = r + delRow[i];
                int nC = c + delCol[i];

                if (nR >= 0 && nR < rows && nC >= 0 && nC < cols) {
                    int neigh = (cols * nR) + nC;

                    if (visited[neigh] && ds.findUltPar(node) != ds.findUltPar(neigh)) {
                        count--;
                        ds.unionByRank(node, neigh);
                    }
                }

            }

            answer.add(count);
        }

        return answer;
    }
}
