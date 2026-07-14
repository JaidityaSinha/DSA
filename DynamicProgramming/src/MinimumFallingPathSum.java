public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];

        System.arraycopy(matrix[0], 0, prev, 0, n);

        for (int i = 1; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + prev[j];

                int upperLeftDiagonal = (int) 1e9;
                if (j > 0)
                    upperLeftDiagonal = matrix[i][j] + prev[j-1];

                int upperRightDiagonal = (int) 1e9;
                if (j < n - 1)
                    upperRightDiagonal = matrix[i][j] + prev[j+1];

                temp[j] = Math.min(up, Math.min(upperLeftDiagonal, upperRightDiagonal));
            }

            prev = temp;
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, prev[j]);
        }

        return min;
    }
}
