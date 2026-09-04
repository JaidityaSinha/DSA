package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobSequencing {
    int[] parent;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;

        int[][] jobs = new int[n][2];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1]));

        parent = new int[maxDeadline + 1];

        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalProfit = 0;

        for (int[] job : jobs) {
            int d = job[0];
            int p = job[1];

            // Find latest available slot <= deadline
            int slot = find(d);

            if (slot > 0) {
                count++;
                totalProfit += p;

                // Slot is now occupied.
                // Next time, go to the previous available slot.
                parent[slot] = find(slot - 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);

        return ans;
    }
}
