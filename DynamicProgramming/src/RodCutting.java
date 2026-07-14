import java.util.Arrays;

public class RodCutting {
    public int cutRod(int[] price) {
        int n = price.length;
        int[] prev = new int[n + 1];

        for (int i = 0; i <= n; i++)
            prev[i] = price[0] * i;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;

                int rodLength = i + 1;

                if (rodLength <= j)
                    take = price[i] + prev[j - rodLength];

                prev[j] = Math.max(take, notTake);
            }

        }

        return prev[n];
    }
}
