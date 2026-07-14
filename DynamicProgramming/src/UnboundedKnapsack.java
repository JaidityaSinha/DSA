import java.util.Arrays;

public class UnboundedKnapsack {
    public int knapSack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[] prev = new int[capacity + 1];

        for (int i = wt[0]; i <= capacity; i++)
            prev[i] = (i / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {

                int notTake = prev[j];
                int take = Integer.MIN_VALUE;

                if (j >= wt[i])
                    take = val[i] + prev[j - wt[i]];

                prev[j] = Math.max(take, notTake);
            }
        }

        return prev[capacity];
    }
}
