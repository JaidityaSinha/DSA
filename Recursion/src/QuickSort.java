import static java.util.Collections.swap;

public class QuickSort {
    public void sort (int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        quickSort(nums, low, high);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = getPartition(nums, low, high);

            quickSort(nums, low, partition - 1);
            quickSort(nums, partition + 1, high);
        }
    }

    private int getPartition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (nums[i] <= pivot && i < high)
                i++;
            while (nums[j] > pivot && j > low)
                j--;

            if (i < j)
                swap(nums, i, j);
        }

        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
