public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            int changes = r - l + 1 - maxFreq;

            if (changes > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            if (changes <= k) {
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }


            r++;

        }

        return maxLen;
    }
}
