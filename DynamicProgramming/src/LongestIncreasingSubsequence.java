import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] =  1 + dp[prev];
                }
            }
            if (dp[i] > max)
                max = dp[i];
        }

        return max;
    }


}
