package BinarySearch.src;

public class FindMinInRotSortedArrayII {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == nums[low] && nums[low] == nums[high]) {
                ans = Math.min(nums[mid], ans);
                low++;
                high--;
                continue;
            }


            // Right Sorted
            if (nums[mid] <= nums[high]) {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }

            // Left Sorted
            else {
                ans = Math.min(nums[low], ans);
                low = mid + 1;
            }
        }

        return ans;
    }
}
