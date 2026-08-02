package BinarySearch.src;

public class SearchElementInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            // Left sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] >= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            // Right Sorted
            else {
                if (target <= nums[high] && target >= nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }

        return -1;
    }
}
