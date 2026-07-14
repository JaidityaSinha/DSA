import java.util.Arrays;

public class MatrixChainMultiplication {
    public int matrixMultiplication(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = (int) 1e9;

                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];

                    min = Math.min(min, steps);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][n - 1];
    }
}
