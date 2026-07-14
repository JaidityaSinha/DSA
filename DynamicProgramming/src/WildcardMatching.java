public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(); int m = p.length();
        boolean[] prev = new boolean[m + 1]; //right shift


        prev[0] = true;

        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*')
                prev[j] = prev[j - 1];
            else
                prev[j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            boolean[] curr = new boolean[m + 1];
            curr[0] = false;

            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    curr[j] = prev[j - 1];

                else if (p.charAt(j - 1) == '*') {
                    boolean starIsNothing = curr[j - 1];
                    boolean starIsOneChar = prev[j];

                    curr[j] = starIsNothing || starIsOneChar;
                }

                else
                    curr[j] = false;

            }
            prev = curr;
        }


        return prev[m];
    }
}
