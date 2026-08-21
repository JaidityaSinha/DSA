package BinarySearch.src;

public class MedianInARowWiseSortedMatrix {
    public int median(int[][] mat) {
        int low = -1, high = -1;
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        int req = (n * m) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallerEquals = blackbox(mat, mid);

            if (smallerEquals <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    private int blackbox(int[][] mat, int x) {
        int count = 0;

        for (int[] ints : mat) {
            count += ub(ints, x);
        }

        return count;
    }

    private int ub(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            }

            else
                low = mid + 1;
        }

        return ans;
    }
}
