public class HouseRobber {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int rob = nums[i];
            if (i > 1)
                rob += prev2;

            int notRob = prev;

            int curr = Math.max(rob, notRob);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }


}
