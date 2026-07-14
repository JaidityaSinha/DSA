public class MergeSort {
    public void sort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        mergeSort(nums, low, high);

    }
    // [3,2,4,1,3]

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int l = low, r = mid + 1, k = 0;
        int[] result = new int[high - low + 1];

        while (l <= mid && r <= high)
            if (nums[l] <= nums[r])
                result[k++] = nums[l++];
            else
                result[k++] = nums[r++];

        while (l <= mid)
            result[k++] = nums[l++];

        while (r <= high)
            result[k++] = nums[r++];

        for (int i = low; i <= high; i++)
            nums[i] = result[i - low];
    }
}
