import java.util.Arrays;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];

        Arrays.sort(
                words, (a, b) -> a.length() - b.length()
        );

        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (checkDiff(words[i], words[prev]) && 1 + dp[prev] > dp[i]) {
                    dp[i] =  1 + dp[prev];
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    private boolean checkDiff(String word1, String word2) {
        if (word1.length() != word2.length() + 1)
            return false;

        int first = 0, second = 0;
        while (first < word1.length()) {
            if (second < word2.length() && word1.charAt(first) == word2.charAt(second)) {
                first++;
                second++;
            }
            else {
                first++;
            }

        }

        return second == word2.length();
    }
}
