public class SubsetSumEqualsK {
    public boolean isSubsetSum(int[] arr, int sum) {
        boolean[] prev = new boolean[sum + 1];

        prev[0] = true;

        if (arr[0] <= sum)
            prev[arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for (int j = 1; j <= sum; j++) {
                boolean notTake = prev[j];
                boolean take = false;

                if (j >= arr[i])
                    take = prev[j - arr[i]];

                curr[j] = take || notTake;
            }

            prev = curr;
        }

        return prev[sum];
    }
}
