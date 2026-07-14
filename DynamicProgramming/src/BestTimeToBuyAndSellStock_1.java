public class BestTimeToBuyAndSellStock_1 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int price : prices) {
            int cost = price - min;
            profit = Math.max(cost, profit);

            min = Math.min(min, price);
        }

        return profit;

    }
}
