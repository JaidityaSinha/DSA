public class FrogJump {
    int minCost(int[] height) {
        int prevprev = 0;
        int prev = 0;


        for (int i = 1; i < height.length; i++) {
            int oneJump = prev + Math.abs(height[i] - height[i - 1]);

            int doubleJump = Integer.MAX_VALUE;

            if (i > 1)
                doubleJump = prevprev + Math.abs(height[i] - height[i - 2]);

            int curr = Math.min(oneJump, doubleJump);

            prevprev = prev;
            prev = curr;
        }

        return prev;
    }
}
