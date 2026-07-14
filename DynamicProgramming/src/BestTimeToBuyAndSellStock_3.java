public class BestTimeToBuyAndSellStock_3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][3];

        for (int canBuy = 0; canBuy < 2; canBuy++) {
            for (int cap = 0; cap < 3; cap++) {
                next[canBuy][cap] = 0;
            }
        }



        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][3];

            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = 1; cap < 3; cap++) {
                    if (canBuy == 1)
                        profit = Math.max(-prices[i] + next[0][cap], next[1][cap]);
                    else
                        profit = Math.max(prices[i] + next[1][cap - 1], next[0][cap]);

                    curr[canBuy][cap] = profit;
                }
            }

            next = curr;
        }

        return next[1][2];
    }
}
