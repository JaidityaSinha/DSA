package BinarySearch.src;

public class LowerBound {
    int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return (ans == -1) ? arr.length : ans;
    }
}
