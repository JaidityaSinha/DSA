public class MinimumCoins {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        prev[0] = 0;

        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0)
                prev[j] = j / coins[0];
            else
                prev[j] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            curr[0] = 0;
            for (int j = 1; j <= amount; j++) {
                int notTake = prev[j];
                int take = (int) 1e9;

                if (coins[i] <= j)
                    take = 1 + curr[j - coins[i]];

                curr[j] = Math.min(take, notTake);
            }

            prev = curr;
        }

        return (prev[amount] == (int) 1e9) ? -1 : prev[amount];
    }

    private int getMinCoins(int index, int amount, int[] coins, int[][] dp) {

        if (amount == 0)
            return 0;
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int) 1e9;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];


        int notTake = getMinCoins(index - 1, amount, coins, dp);
        int take = (int) 1e9;

        if (coins[index] <= amount)
            take = 1 + getMinCoins(index, amount - coins[index], coins, dp);

        return dp[index][amount] = Math.min(take, notTake);
    }
}
