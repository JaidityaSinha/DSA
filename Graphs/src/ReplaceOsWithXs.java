import java.util.ArrayDeque;
import java.util.Queue;

public class ReplaceOsWithXs {
    static class Pair {
        int row,col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] notConvertible = new boolean[m][n];
        Queue<Pair> queue = new ArrayDeque<>();

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O' && !notConvertible[0][col]) {
               notConvertible[0][col] = true;
               queue.add(new Pair(0, col));
            }

            if (board[m - 1][col] == 'O' && !notConvertible[m - 1][col]) {
                notConvertible[m - 1][col] = true;
                queue.add(new Pair(m - 1, col));
            }
        }

        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O' && !notConvertible[row][0]) {
                notConvertible[row][0] = true;
                queue.add(new Pair(row, 0));
            }

            if (board[row][n - 1] == 'O' && !notConvertible[row][n - 1]) {
                notConvertible[row][n - 1] = true;
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
                        && !notConvertible[nR][nC] && board[nR][nC] == 'O') {
                    notConvertible[nR][nC] = true;
                    queue.add(new Pair(nR, nC));
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (notConvertible[i][j])
                    continue;
                board[i][j] = 'X';
            }
        }
    }
}
