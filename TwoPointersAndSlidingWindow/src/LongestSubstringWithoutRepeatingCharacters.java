import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxLen = 0;
        int[] lastOccIndex = new int[256];
        Arrays.fill(lastOccIndex, -1);

        while (r < s.length()) {
            if (lastOccIndex[s.charAt(r)] != -1)
                if (lastOccIndex[s.charAt(r)] >= l)
                    l = lastOccIndex[s.charAt(r)] + 1;

            int len = r - l + 1;

            maxLen = Math.max(maxLen, len);

            lastOccIndex[s.charAt(r)] = r;

            r++;
        }

        return maxLen;
    }
}
