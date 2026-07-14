import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] prev = new int[cols];

        for (int j = 0; j < cols; j++) {
            prev[j] = matrix[0][j] - '0';
            maxSide = Math.max(maxSide, prev[j]);
        }

        for (int i = 1; i < rows; i++) {
            int[] curr = new int[cols];

            curr[0] = matrix[i][0] - '0';
            maxSide = Math.max(maxSide, curr[0]);

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int top = prev[j];
                    int left = curr[j - 1];
                    int topDiag = prev[j - 1];

                    curr[j] = 1 +  Math.min(left, Math.min(top, topDiag));
                    maxSide = Math.max(maxSide, curr[j]);
                }
            }

            prev = curr;
        }

        return maxSide * maxSide;
    }

    private int largestSquareSeen(int i, int j, char[][] matrix, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (matrix[i][j] == '0')
            return dp[i][j] = 0;

        int top = largestSquareSeen(i - 1, j, matrix, dp);
        int left = largestSquareSeen(i, j - 1, matrix, dp);
        int topDiag = largestSquareSeen(i - 1, j - 1, matrix, dp);

        return dp[i][j] = 1 + Math.min(top, Math.min(left, topDiag));
    }

}
