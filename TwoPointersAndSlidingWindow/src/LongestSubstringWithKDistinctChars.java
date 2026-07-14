public class LongestSubstringWithKDistinctChars {
    public int longestKSubstr(String s, int k) {
        int l = 0, r = 0, maxLen = -1;
        int[] freq = new int[26];
        int distinct = 0;

        while (r < s.length()) {
            if (freq[s.charAt(r) - 'a'] == 0)
                distinct++;
            freq[s.charAt(r) - 'a']++;


            if (distinct > k) {
                freq[s.charAt(l) - 'a']--;

                if (freq[s.charAt(l) - 'a'] == 0)
                    distinct--;
                l++;
            }

            if (distinct == k) {
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }

            r++;
        }

        return maxLen;
    }

}
