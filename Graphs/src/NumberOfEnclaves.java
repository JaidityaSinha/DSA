import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfEnclaves {
    static class Pair {
        int row,col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] connectedToBorder = new boolean[m][n];
        Queue<Pair> queue = new ArrayDeque<>();

        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1 && !connectedToBorder[0][col]) {
                connectedToBorder[0][col] = true;
                queue.add(new Pair(0, col));
            }

            if (grid[m - 1][col] == 1 && !connectedToBorder[m - 1][col]) {
                connectedToBorder[m - 1][col] = true;
                queue.add(new Pair(m - 1, col));
            }
        }

        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 1 && !connectedToBorder[row][0]) {
                connectedToBorder[row][0] = true;
                queue.add(new Pair(row, 0));
            }

            if (grid[row][n - 1] == 1 && !connectedToBorder[row][n - 1]) {
                connectedToBorder[row][n - 1] = true;
                queue.add(new Pair(row, n - 1));
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();
            int row = curr.row;
            int col = curr.col;

            for (int i = 0; i < 4; i++) {
                int nR = row + delRow[i];
                int nC = col + delCol[i];

                if (nR >= 0 && nR < m && nC >= 0 && nC < n
                        && !connectedToBorder[nR][nC] && grid[nR][nC] == 1) {
                    connectedToBorder[nR][nC] = true;
                    queue.add(new Pair(nR, nC));
                }
            }
        }

        int enclaves = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1 && !connectedToBorder[i][j])
                    enclaves++;

        return enclaves;
    }
}
