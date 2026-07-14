public class CountInversions {
    int count = 0;
    public int inversionCount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        breakdown(arr, low, high);

        return count;
    }

    private void breakdown(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (high + low) / 2;

        breakdown(arr, low, mid);
        breakdown(arr, mid + 1, high);

        countInversion(arr, low, mid, high);
    }

    private void countInversion(int[] arr, int low, int mid, int high) {
        int[] result = new int[high - low + 1];
        int l = low, r = mid + 1, k = 0;

        while (l <= mid && r <= high) {
            if (arr[l] <= arr[r])
                result[k++] = arr[l++];
            else {
                count += mid - l + 1;
                result[k++] = arr[r++];
            }

        }

        while (l <= mid)
            result[k++] = arr[l++];
        while (r <= high)
            result[k++] = arr[r++];

        for (int i = low; i <= high; i++)
            arr[i] = result[i - low];
    }
}
