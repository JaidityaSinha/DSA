package Greedy;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0, r = 0;

        int i = 0;
        while (r < nums.length - 1) {
            int farthest = 0;

            for (int j = l; j <= r; j++)
                farthest = Math.max(farthest, j + nums[j]);

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}
