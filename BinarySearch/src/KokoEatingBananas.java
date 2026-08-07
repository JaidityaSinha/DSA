package BinarySearch.src;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = 0, n = piles.length;

        for (int num : piles)
            high = Math.max(high, num);

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int totalHrs = func(piles, mid);

            if (totalHrs <= h) {
                ans = mid;
                high = mid - 1;
            }

            else
                low = mid + 1;
        }

        return ans;
    }

    private int func(int[] piles, int hourly) {
        int totalHrs = 0;
        for (int pile : piles) totalHrs = (int) (totalHrs + Math.ceil((double) pile / hourly));

        return totalHrs;
    }
}
