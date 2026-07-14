import java.util.Arrays;

public class FrogWithKJumps {
    public int frogJump(int[] height, int k) {
        int[] dp = new int[height.length];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i < height.length; i++)
            for (int j = 1; j <= k; j++)
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    dp[i] = Math.min(dp[i], jump);
                }


        return dp[height.length - 1];
    }
}
