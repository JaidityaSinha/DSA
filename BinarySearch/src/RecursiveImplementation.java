package BinarySearch.src;

public class RecursiveImplementation {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        return recurse(nums, low, high, target);
    }

    public int recurse(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[mid] > target)
            return recurse(nums, low, mid - 1, target);

        else
            return recurse(nums, mid + 1, high, target);
    }
}
