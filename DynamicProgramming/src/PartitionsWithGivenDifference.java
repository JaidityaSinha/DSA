public class PartitionsWithGivenDifference {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        if (totalSum - diff < 0 || ((totalSum - diff) & 1) != 0)
            return 0;

        return perfectSum(arr, (totalSum - diff) / 2);
    }

    private int perfectSum(int[] nums, int target) {
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

}
