import java.util.Arrays;

public class NumberOfLis {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] =  1 + dp[prev];
                    count[i] = count[prev];
                }
                else if (nums[i] > nums[prev] && 1 + dp[prev] == dp[i]) {
                    count[i] += count[prev];
                }
            }
            if (dp[i] > max)
                max = dp[i];
        }

        int numOfLis = 0;

        for (int i = 0; i < n; i++)
            if (dp[i] == max)
                numOfLis += count[i];

        return numOfLis;
    }

}
