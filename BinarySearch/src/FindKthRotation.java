package BinarySearch.src;

public class FindKthRotation {
    public int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Right sorted
            if (arr[mid] <= arr[high]) {
                if (arr[mid] < min) {
                    min = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }

            // Left sorted
            else {
                if (arr[low] < min) {
                    min = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
        }

        return index;
    }
}
