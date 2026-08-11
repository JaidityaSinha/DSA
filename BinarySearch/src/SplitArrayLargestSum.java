package BinarySearch.src;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = -1;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int countSubarrays = countSubarrays(nums, mid);

            if (countSubarrays <= k) {
                high = mid -1;
            }
            else
                low = mid + 1;
        }

        return low;
    }

    private int countSubarrays(int[] nums, int splitVal) {
        int subarrays = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num <= splitVal) {
                sum += num;
            }
            else {
                subarrays++;
                sum = num;
            }
        }

        return subarrays;
    }
}
