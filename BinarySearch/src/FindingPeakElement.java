package BinarySearch.src;

public class FindingPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 1, high = nums.length - 2, n = nums.length;

        // Get rid of edge/conditional cases first
        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            else if (nums[mid] > nums[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
