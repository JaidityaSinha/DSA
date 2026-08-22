package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;
        int sCount = 0;

        for (int i = 0; i < g.length; i++) {
            if (sCount >= s.length) {
                return ans;
            }

            if (s[sCount] >= g[i]) {
                ans++;
                sCount++;
            }

            else {
                sCount++;
                i--;
            }
        }

        return ans;
    }
}
