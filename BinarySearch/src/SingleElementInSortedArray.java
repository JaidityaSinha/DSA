package BinarySearch.src;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 1, high = nums.length - 2, n = nums.length;
        // To avoid writing conditional cases for mid

        if (n == 1)
            return nums[0];

        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];

            // We are on left of element
            if ((mid % 2 == 1 && nums[mid - 1] == nums[mid])
                    || mid % 2 == 0 && nums[mid + 1] == nums[mid])
                low = mid + 1;

            // We are on right of element
            else if ((mid % 2 == 0 && nums[mid - 1] == nums[mid])
                    || mid % 2 == 1 && nums[mid + 1] == nums[mid])
                high = mid - 1;
        }

        return 0;
    }
}
