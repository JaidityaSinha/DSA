import java.util.Arrays;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length(); int m = t.length();
        int[] prev = new int[m + 1]; // right shift

        prev[0] = 1;

        for (int i = 1; i < m + 1; i++) {
            prev[i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = m; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    prev[j] = prev[j - 1] + prev[j];
            }
        }

        return prev[m];
    }
}
