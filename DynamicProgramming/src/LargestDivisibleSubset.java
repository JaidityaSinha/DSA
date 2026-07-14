import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int lastIndex = 0;
        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
                    dp[i] =  1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            list.addFirst(nums[lastIndex]);
        }

        return list;
    }
}
