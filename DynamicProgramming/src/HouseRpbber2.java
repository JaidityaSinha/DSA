public class HouseRpbber2 {
    public int rob(int[] nums) {
        int[] temp1 = new int[nums.length];
        int[] temp2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                temp1[i] = nums[i];

            if(i != nums.length - 1)
                temp2[i] = nums[i];
        }

        return Math.max(robber1(temp1), robber1(temp2));
    }

    public int robber1(int[] nums) {
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
