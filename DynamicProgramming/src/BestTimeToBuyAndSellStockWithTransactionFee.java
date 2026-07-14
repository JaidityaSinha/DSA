public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int nextCantBuy = 0;
        int nextCanBuy = 0;

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currCanBuy = Math.max(-prices[i] + nextCantBuy, nextCanBuy);
            int currCantBuy = Math.max(prices[i] - fee + nextCanBuy, nextCantBuy);

            nextCantBuy = currCantBuy;
            nextCanBuy = currCanBuy;
        }


        return nextCanBuy;
    }
}
