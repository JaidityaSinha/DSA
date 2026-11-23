package Greedy;

import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] firstPosition = new int[26];
        int[] lastPosition = new int[26];

        Arrays.fill(firstPosition, -1);

        for (int i = 0; i < n; i++) {
            int character = s.charAt(i) - 'a';

            if (firstPosition[character] == -1) {
                firstPosition[character] = i;
            }

            lastPosition[character] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        for (int character = 0; character < 26; character++) {
            if (firstPosition[character] == -1) {
                continue;
            }

            int left = firstPosition[character];
            int right = lastPosition[character];
            boolean isValid = true;

            for (int i = left; i <= right; i++) {
                int currentCharacter = s.charAt(i) - 'a';

                if (firstPosition[currentCharacter] < left) {
                    isValid = false;
                    break;
                }

                right = Math.max(right, lastPosition[currentCharacter]);
            }

            if (isValid) {
                validIntervals.add(new int[]{left, right});
            }
        }

        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> answer = new ArrayList<>();
        int previousEnd = -1;

        for (int[] interval : validIntervals) {
            int left = interval[0];
            int right = interval[1];

            if (left > previousEnd) {
                answer.add(s.substring(left, right + 1));
                previousEnd = right;
            }
        }

        return answer;
    }
}