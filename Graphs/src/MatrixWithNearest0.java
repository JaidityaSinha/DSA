import java.util.ArrayDeque;
import java.util.Queue;

public class MatrixWithNearest0 {
    static class Triad {
        int row,col,dist;

        public Triad(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        Queue<Triad> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        int[][] distances = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new Triad(i, j, 0));
                }
            }
        }

        findNearestZero(mat, m, n, visited, queue, distances);

        return distances;
    }

    private void findNearestZero(int[][] mat, int m, int n,
                                 boolean[][] visited, Queue<Triad> queue, int[][] distances) {

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!queue.isEmpty()) {
            Triad curr = queue.remove();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;

            distances[row][col] = dist;

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow <= m - 1 && nCol >= 0 && nCol <= n - 1 && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.add(new Triad(nRow, nCol, dist + 1));
                }
            }
        }
    }
}
