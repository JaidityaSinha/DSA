package Greedy;

import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length + 1][2];

        int i = 0;
        int k = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans[k++] = intervals[i];
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        ans[k++] = newInterval;

        while (i < intervals.length) {
            ans[k++] = intervals[i];
            i++;
        }

        return Arrays.copyOf(ans, k);
    }
}
