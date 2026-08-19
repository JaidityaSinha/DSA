package BinarySearch.src;

public class FindPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = maxElement(mat, mid, n, m);

            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
            int right = (mid + 1 < m) ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right)
                return new int[]{row, mid};

            else if (mat[row][mid] < left)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return new int[]{-1, -1};
    }

    private int maxElement(int[][] nums, int col, int n, int m) {
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i][col] > max) {
                max = nums[i][col];
                ans = i;
            }
        }

        return ans;
    }
}
