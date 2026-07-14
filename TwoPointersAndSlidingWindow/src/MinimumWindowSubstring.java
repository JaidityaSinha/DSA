import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int minLength = (int)1e9, sIdx = -1, l = 0, r = 0, count = 0;
        int[] hash = new int[256];

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0)
                count++;

            hash[s.charAt(r)]--;

            while (count == t.length()) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    sIdx = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0)
                    count--;

                l++;
            }

            r++;
        }

        if (sIdx == -1)
            return "";

        return s.substring(sIdx, sIdx + minLength);
    }
}
