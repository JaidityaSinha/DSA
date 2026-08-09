package BinarySearch.src;

import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr[arr.length - 1] - arr[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canWePlace(arr, mid, k)) {
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return high;
    }

    private boolean canWePlace(int[] arr, int distance, int k) {
        int countCows = 1;
        int lastStall = arr[0];

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] - lastStall >= distance) {
                countCows++;
                lastStall = arr[j];
            }

            if (countCows >= k)
                return true;
        }

        return false;
    }
}
