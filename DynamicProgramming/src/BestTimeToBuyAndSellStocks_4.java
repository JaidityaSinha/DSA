public class BestTimeToBuyAndSellStocks_4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][k + 1];

        for (int canBuy = 0; canBuy < 2; canBuy++) {
            for (int cap = 0; cap < k + 1; cap++) {
                next[canBuy][cap] = 0;
            }
        }


        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][k + 1];

            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = 1; cap < k + 1; cap++) {
                    if (canBuy == 1)
                        profit = Math.max(-prices[i] + next[0][cap], next[1][cap]);
                    else
                        profit = Math.max(prices[i] + next[1][cap - 1], next[0][cap]);

                    curr[canBuy][cap] = profit;
                }
            }

            next = curr;
        }


        return next[1][k];
    }
}
