import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    static class Triad {
        int x, y, time;

        public Triad(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Triad> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Triad(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }



        int maxTime = 0;
        maxTime = bfs(queue, visited, m, n, grid, maxTime);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxTime;
    }

    private int bfs(Queue<Triad> queue, boolean[][] visited, int m, int n, int[][] grid, int maxTime) {
        while (!queue.isEmpty()) {
            Triad curr = queue.remove();
            maxTime = Math.max(maxTime, curr.time);

            if (curr.x > 0) {
                if (grid[curr.x - 1][curr.y] == 1 && !visited[curr.x - 1][curr.y]) {
                    visited[curr.x - 1][curr.y] = true;
                    queue.add(new Triad(curr.x - 1, curr.y, curr.time + 1));
                    grid[curr.x - 1][curr.y] = 2;
                }
            }

            if (curr.x < m - 1) {
                if (grid[curr.x + 1][curr.y] == 1 && !visited[curr.x + 1][curr.y]) {
                    visited[curr.x + 1][curr.y] = true;
                    queue.add(new Triad(curr.x + 1, curr.y, curr.time + 1));
                    grid[curr.x + 1][curr.y] = 2;
                }
            }

            if (curr.y > 0) {
                if (grid[curr.x][curr.y - 1] == 1 && !visited[curr.x][curr.y - 1]) {
                    visited[curr.x][curr.y - 1] = true;
                    queue.add(new Triad(curr.x, curr.y - 1, curr.time + 1));
                    grid[curr.x][curr.y - 1] = 2;
                }
            }

            if (curr.y < n - 1) {
                if (grid[curr.x][curr.y + 1] == 1 && !visited[curr.x][curr.y + 1]) {
                    visited[curr.x][curr.y + 1] = true;
                    queue.add(new Triad(curr.x, curr.y + 1, curr.time + 1));
                    grid[curr.x][curr.y + 1] = 2;
                }
            }
        }

        return maxTime;
    }
}
