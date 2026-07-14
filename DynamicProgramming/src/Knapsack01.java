import java.util.Arrays;

public class Knapsack01 {
    public int knapsack(int W, int[] val, int[] wt) {
        int[] prev = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        for (int i = 1; i < val.length; i++) {
            for (int j = W; j >= 0; j--) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;

                if (j >= wt[i])
                    take = val[i] + prev[j - wt[i]];

                prev[j] = Math.max(take, notTake);
            }
        }

        return prev[W];
    }


}
