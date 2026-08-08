package BinarySearch.src;

public class FindSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = -1;

        for (int num : nums)
            high = Math.max(num, high);

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum = findSumAfterDividing(nums, mid);

            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            }

            else
                low = mid + 1;
        }

        return ans;
    }

    private int findSumAfterDividing(int[] nums, int divisor) {
        int sum = 0;

        for (int num : nums) {
            sum = (int) (sum + Math.ceil((double) num / divisor));
        }

        return sum;
    }
}
