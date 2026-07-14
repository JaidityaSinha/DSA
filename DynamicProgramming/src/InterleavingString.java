public class InterleavingString {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length())
                return false;

            boolean[] next = new boolean[s2.length() + 1];

            next[s2.length()] = true;


            for (int i = s1.length(); i >= 0; i--) {
                boolean[] curr = new boolean[s2.length() + 1];

                for (int j = s2.length(); j >= 0; j--) {
                    if (i == s1.length() && j == s2.length()) {
                        curr[j] = true;
                        continue;
                    }

                    int k = i + j;

                    if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
                        curr[j] |= next[j];
                    if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
                        curr[j] |= curr[j + 1];
                }

                next = curr;
            }

            return next[0];
        }

    private boolean doesInterleave(int i, int j, String s1, String s2, String s3, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length())
            return true;

        if (dp[i][j] != null)
            return dp[i][j];

        int k = i + j;

        boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            ans |= doesInterleave(i + 1, j, s1, s2, s3, dp);
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
            ans |= doesInterleave(i, j + 1, s1, s2, s3, dp);

        return dp[i][j] = ans;
    }
}
