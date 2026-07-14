import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        prev[0] = 1;

        for (int j = 0; j <= amount; j++)
            if (j % coins[0] == 0)
                prev[j] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            curr[0] = 1;

            for (int j = 1; j <= amount; j++) {
                int notTake = prev[j];
                int take = 0;

                if (coins[i] <= j)
                    take = curr[j - coins[i]];

                curr[j] = take + notTake;
            }

            prev = curr;
        }

        return prev[amount];
    }


}
