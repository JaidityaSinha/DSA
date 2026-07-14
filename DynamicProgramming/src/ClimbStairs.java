public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int prevprev = 1;
        int prev = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prevprev + prev;
            prevprev = prev;
            prev = curr;
        }


        return prev;
    }
}
