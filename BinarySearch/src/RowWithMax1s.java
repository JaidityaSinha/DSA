package BinarySearch.src;

public class RowWithMax1s {
    public int rowWithMax1s(int[][] arr) {
        int in = -1;
        int maxCount = -1;
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            int low = 0, high = arr[i].length - 1;
            int firstOcc = -1;
            int cntRow = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[i][mid] >= 1) {
                    firstOcc = mid;
                    high = mid - 1;
                }
                else
                    low = mid + 1;
            }

            cntRow += (firstOcc == -1) ? 0 : arr[i].length - firstOcc;

            if (cntRow > maxCount && cntRow != 0) {
                maxCount = cntRow;
                in = i;
            }

        }

        return in;
    }
}
