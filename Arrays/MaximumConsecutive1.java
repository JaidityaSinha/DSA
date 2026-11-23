package Arrays;

public class MaximumConsecutive1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int consCount = 0;
        int maxCons = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                consCount++;
                maxCons = Math.max(maxCons, consCount);
            }
            else
                consCount = 0;
        }

        return maxCons;
    }
}
