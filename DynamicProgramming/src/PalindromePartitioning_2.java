import java.util.Arrays;

public class PalindromePartitioning_2 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int min = (int) 1e9;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cuts = 1 + dp[j + 1];
                    min = Math.min(min, cuts);
                }
            }

            dp[i] = min;
        }

        return dp[0] - 1;
    }

    private boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        }

        return true;
    }
}
