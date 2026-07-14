public class LongestCommonSubstring {
    public int longCommSubstr(String s1, String s2) {
        int n = s1.length(); int m = s2.length();
        // right shift by 1
        int[] prev = new int[m + 1];

        int max = 0;

        for (int i = 1; i < n + 1; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    max = Math.max(max, curr[j]);
                }
            }

            prev = curr;
        }


        return max;
    }
}
