package Greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    public int solve(int[] bt) {
        if (bt.length == 0)
            return 0;
        Arrays.sort(bt);

        int sum = bt[0];

        for (int i = 1; i < bt.length; i++) {
            int t = bt[i];
            bt[i] = sum;
            sum += t;
        }

        sum = 0;

        for (int num : bt)
            sum += num;

        return (sum - bt[0]) / bt.length;
    }
}
