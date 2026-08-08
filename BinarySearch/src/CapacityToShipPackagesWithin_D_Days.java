package BinarySearch.src;

public class CapacityToShipPackagesWithin_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int low = -1;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(weight, low);
            high += weight;
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int daysRequired = daysRequired(mid, weights);

            if (daysRequired <= days) {
                ans = mid;
                high = mid - 1;
            }

            else
                low = mid + 1;
        }

        return ans;
    }

    public int daysRequired(int cap, int[] weights) {
        int days = 1;
        int load = 0;

        for (int weight : weights) {
            if (load + weight > cap) {
                days++;
                load = weight;
            }
            else
                load += weight;
        }

        return days;
    }
}
