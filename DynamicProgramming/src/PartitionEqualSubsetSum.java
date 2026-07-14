public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;


        if ((sum & 1) != 0)
            return false;

        int S = sum / 2;


        return isSubsetSum(nums, S);
    }

    public boolean isSubsetSum(int[] arr, int S) {
        boolean[] prev = new boolean[S + 1];

        prev[0] = true;

        if (arr[0] <= S)
            prev[arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            boolean[] curr = new boolean[S + 1];
            curr[0] = true;
            for (int j = 1; j <= S; j++) {
                boolean notTake = prev[j];
                boolean take = false;

                if (j >= arr[i])
                    take = prev[j - arr[i]];

                curr[j] = take || notTake;
            }

            prev = curr;
        }

        return prev[S];
    }
}
