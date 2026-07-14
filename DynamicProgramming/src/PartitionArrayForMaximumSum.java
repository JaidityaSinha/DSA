import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            int max = (int) -1e9;
            int maximumSum = (int) -1e9;

            for (int j = i; j < Math.min(i + k, n); j++) {
                len++;
                max = Math.max(max, arr[j]);

                int sum = (len * max) + dp[j + 1];

                maximumSum = Math.max(maximumSum, sum);
            }

            dp[i] = maximumSum;
        }

        return dp[0];
    }

    private int maxSum(int i, int[] arr, int k, int[] dp) {
        if (i == arr.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int len = 0;
        int max = (int) -1e9;
        int maximumSum = (int) -1e9;
        for (int j = i; j < Math.min(i + k, arr.length); j++) {
            len++;
            max = Math.max(max, arr[j]);

            int sum = (len * max) + maxSum(j + 1, arr, k, dp);
            maximumSum = Math.max(maximumSum, sum);
        }

        return dp[i] = maximumSum;
    }
}
