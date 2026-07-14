public class BinarySubarraysWithSumK {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return
                subsWithSumLessThanEqualToK(nums, goal) -
                        subsWithSumLessThanEqualToK(nums, goal - 1);
    }

    private static int subsWithSumLessThanEqualToK(int[] nums, int goal) {
        if (goal < 0)
            return 0;

        int sum = 0, count = 0, l = 0, r = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }


            count += r - l + 1;

            r++;

        }

        return count;
    }
}
