import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    private static class Triad {
        int row, col, effort;

        public Triad(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(effort[i], (int)1e9);
        }

        effort[0][0] = 0;

        PriorityQueue<Triad> priorityQueue = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.effort, b.effort)
        );

        priorityQueue.add(new Triad(0, 0, effort[0][0]));

        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, -1, 0, 1};

        while (!priorityQueue.isEmpty()) {
            Triad curr = priorityQueue.remove();

            if (curr.effort > effort[curr.row][curr.col])
                continue;

            for (int i = 0; i < 4; i++) {
                int nR = curr.row + delRow[i];
                int nC = curr.col + delCol[i];


                if (nR >= 0 && nR < m && nC >= 0 && nC < n) {

                int weight = Math.abs(heights[curr.row][curr.col] - heights[nR][nC]);
                int newEffort = Math.max(curr.effort, weight);

                    if (effort[nR][nC] > newEffort) {
                        effort[nR][nC] = newEffort;
                        priorityQueue.add(new Triad(nR, nC, effort[nR][nC]));
                    }
                }
            }
        }

        return effort[m - 1][n - 1];
    }
}
