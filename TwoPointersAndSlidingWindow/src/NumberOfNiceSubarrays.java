public class NumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }

        return subsWithSumLessThanEqualToK(nums, k)
                - subsWithSumLessThanEqualToK(nums, k - 1);
    }

    private int subsWithSumLessThanEqualToK(int[] nums, int k) {
        int l = 0, r = 0, sum = 0, count = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum > k) {
                sum -= nums[l];
                l++;
            }

            count += r - l + 1;

            r++;
        }

        return count;
    }
}
