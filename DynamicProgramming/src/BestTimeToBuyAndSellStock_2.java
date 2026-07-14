import java.util.Arrays;

public class BestTimeToBuyAndSellStock_2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int nextCantBuy = 0;
        int nextCanBuy = 0;

//        prev[0] = prev[1] = 0;

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currCanBuy = Math.max(-prices[i] + nextCantBuy, nextCanBuy);
            int currCantBuy = Math.max(prices[i] + nextCanBuy, nextCantBuy);

            nextCantBuy = currCantBuy;
            nextCanBuy = currCanBuy;
        }


        return nextCanBuy;
    }
}
