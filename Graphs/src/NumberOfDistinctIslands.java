import java.util.*;

public class NumberOfDistinctIslands {
    static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int countDistinctIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Set<List<String>> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 'L') {
                    List<String> vector = new ArrayList<>();
                    bfs(i, j, visited, vector, grid, m, n);
                    set.add(vector);
                }
            }
        }

        return set.size();
    }

    private void bfs(int row, int col, boolean[][] visited,
                     List<String> vector, char[][] grid, int m, int n) {
        int baseRow = row, baseCol = col;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();

            vector.add((curr.row - baseRow) + "," + (curr.col - baseCol));

            for (int i = 0; i < 4; i++) {
                int newRow = curr.row + delRow[i];
                int newCol = curr.col + delCol[i];

                if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 'L' &&
                        !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
