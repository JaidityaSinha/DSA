import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestDistInABinaryMaze {
    private static class Triad {
        int row, col, distance;

        public Triad(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }

        dist[0][0] = 0;

        PriorityQueue<Triad> priorityQueue = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.distance, b.distance)
        );

        priorityQueue.add(new Triad(0, 0, dist[0][0]));

        int[] delRow = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] delCol = {1, 0, -1, -1, -1, 0, 1, 1};

        while (!priorityQueue.isEmpty()) {
            Triad curr = priorityQueue.remove();

            for (int i = 0; i < 8; i++) {
                int nR = curr.row + delRow[i];
                int nC = curr.col + delCol[i];

                if (nR >= 0 && nR < n && nC >= 0 && nC < n && grid[nR][nC] == 0) {
                    if (dist[nR][nC] > curr.distance + 1) {
                        dist[nR][nC] = curr.distance + 1;
                        priorityQueue.add(new Triad(nR, nC, dist[nR][nC]));
                    }
                }
            }
        }

        return (dist[n - 1][n - 1] + 1 == (int)1e9 + 1) ? -1 : dist[n - 1][n - 1] + 1;
    }
}
