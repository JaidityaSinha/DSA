public class MinimumInsertionOrDeletion {
    public int minOperations(String s1, String s2) {
       return s1.length() + s2.length() - 2 * longestCommonSubsequence(s1, s2);
    }

    private int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(); int m = text2.length();
        // right shift by 1
        int[] prev = new int[m + 1];


        for (int i = 1; i < n + 1; i++) {
            int[] curr = new int[m + 1];

            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }

            prev = curr;
        }


        return prev[m];
    }
}
