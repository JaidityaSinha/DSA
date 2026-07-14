public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public int minDifference(int[] arr) {
        int totSum = 0;
        for (int num : arr)
            totSum += num;

        boolean[][] dp = new boolean[arr.length][totSum + 1];

        for (int i = 0; i < arr.length; i++)
            dp[i][0] = true;

        if (arr[0] <= totSum)
            dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= totSum; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;

                if (j >= arr[i])
                    take = dp[i - 1][j - arr[i]];

                dp[i][j] = take || notTake;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < totSum / 2; i++) {
            if (dp[arr.length - 1][i]) {
                int s1 = i;
                int s2 = totSum - i;
                min = Math.min(min, Math.abs(s1 - s2));
            }

        }

        return min;
    }

}
