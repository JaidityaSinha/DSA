public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, l = 0, r = 0, numZeroes = 0;

        while (r < nums.length) {
            if (nums[r] == 0)
                numZeroes++;

            if (numZeroes > k) {
                if (nums[l] == 0)
                    numZeroes--;
                l++;
            }


            if (numZeroes <= k) {
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }

            r++;
        }

        return maxLen;
    }
}
