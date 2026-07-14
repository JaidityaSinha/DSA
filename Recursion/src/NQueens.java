import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        recurse(0, board, n);

        return list;
    }

    private void recurse(int row, char[][] board, int n) {
        if (row == n) {
            list.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++)
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                recurse(row + 1, board, n);
                board[row][col] = '.';
            }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;


        return true;

    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board)
            list.add(new String(row));

        return list;
    }

}
