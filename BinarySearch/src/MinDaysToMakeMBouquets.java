package BinarySearch.src;

public class MinDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = (int)1e9, high = -1;

        for (int num : bloomDay) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        int ans = high;

        if (bloomDay.length < (long) m * k)
            return -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            }

            else
                low = mid + 1;
        }

        return ans;
    }

    private boolean possible(int[] bloomDay, int m, int k, int day) {
        int count = 0;
        int numB = 0;

        for (int j : bloomDay) {
            if (j <= day)
                count++;
            else {
                numB += (count / k);
                count = 0;
            }
        }

        numB += count / k;

        return numB >= m;
    }
}
