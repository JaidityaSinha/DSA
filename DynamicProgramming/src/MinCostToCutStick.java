import java.util.Arrays;

public class MinCostToCutStick {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] newCuts = new int[cuts.length + 2];

        newCuts[0] = 0;
        for (int i = 0; i < m; i++)
            newCuts[i + 1] = cuts[i];
        newCuts[m + 1] = n;

        int p = newCuts.length;
        Arrays.sort(newCuts);

        int[][] dp =new int[p][p];

        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                int min = (int) 1e9;
                for (int index = i; index <= j; index++) {
                    int cost = newCuts[j + 1] - newCuts[i - 1] + dp[i][index - 1] + dp[index + 1][j];
                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][m];
    }

    private int getMin(int i, int j, int[] newCuts, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = (int) 1e9;
        for (int index = i; index <= j; index++) {
            int cost = newCuts[j + 1] - newCuts[i - 1] + getMin(i, index - 1, newCuts, dp) + getMin(index + 1, j, newCuts, dp);

            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}
