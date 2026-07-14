import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;

        for (int i = 0; i < nums.length; i++)
            newNums[i + 1] = nums[i];

        int[][] dp = new int[newNums.length][newNums.length];

        for (int i = newNums.length - 2; i >= 1; i--) {
            for (int j = i; j <= newNums.length - 2; j++) {
                int max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = newNums[i - 1] * newNums[k] * newNums[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][newNums.length - 2];
    }

    private int getMax(int i, int j, int[] newNums, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = newNums[i - 1] * newNums[k] * newNums[j + 1] + getMax(i, k - 1, newNums, dp) + getMax(k + 1, j, newNums, dp);

            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }
}
