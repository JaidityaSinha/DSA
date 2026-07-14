import java.util.Arrays;

public class CountSubsetsWithSumEqualToK {
    public int perfectSum(int[] nums, int target) {
        int[] prev = new int[target + 1];

        if (nums[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if (nums[0] != 0 && nums[0] <= target)
            prev[nums[0]] = 1;

        for (int i = 1; i < nums.length; i++) {
            int[] curr = new int[target + 1];
            curr[0] = 1;

            for (int sum = 0; sum <= target; sum++) {
                int notPick = prev[sum];

                int pick = 0;

                if (nums[i] <= sum)
                    pick = prev[sum - nums[i]];


                curr[sum] = pick + notPick;
            }

            prev = curr;
        }

        return prev[target];
    }

    private int countSubsets(int index, int[] nums, int target, int[][] dp) {

        if (index == 0) {

            // Case: nums[0] = 0 and target = 0
            if (target == 0 && nums[0] == 0)
                return 2;

            // Either pick element OR don't pick anything
            if (target == 0 || nums[0] == target)
                return 1;

            return 0;
        }

        if (dp[index][target] != -1)
            return dp[index][target];

        int notPick = countSubsets(index - 1, nums, target, dp);
        int pick = 0;

        if (nums[index] <= target)
            pick = countSubsets(index - 1, nums, target - nums[index], dp);


        return dp[index][target] = pick + notPick;
    }
}
