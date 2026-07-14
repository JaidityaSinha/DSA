import java.util.Arrays;

public class BuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] next = new int[2];
        int[] next2 = new int[2];

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];

            for (int canBuy = 0; canBuy < 2; canBuy++) {
                if (canBuy == 1)
                    profit = Math.max(-prices[i] + next[0], next[1]);
                else
                    profit = Math.max(prices[i] + next2[1], next[0]);

                curr[canBuy] = profit;
            }
            next2 = next;
            next = curr;
        }

        return next[1];
    }
}
