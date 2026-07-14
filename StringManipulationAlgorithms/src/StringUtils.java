import java.util.*;

public class StringUtils {
    public static int countVowels(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";

        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.contains(Character.toString(ch)))
                count++;

        return count;
    }

    public static String reverseString(String str) {
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length -1; i > -1 ; i--)
            reversed.append(words[i] + " ");

        return reversed.toString().trim();
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() && (str1 + str2).contains(str2));
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static char getMostRepeatedChar(String str) {
        if (str.isEmpty() || str == null)
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];

        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char)i;
            }

        }

/*        Map<Character, Integer> frequencies = new HashMap<>();

        for (var ch : str.toCharArray()) {
            if (frequencies.containsKey(ch))
                frequencies.replace(ch, frequencies.get(ch) + 1);
            else
                frequencies.put(ch, 1);
        }*/

        return result;
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty())
            return "";

        String[] words = str.trim().replaceAll(" +"," ").split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0,1).toUpperCase() +
                             words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }
    // O(n log n)
    public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }
    // O(n)
    public static boolean areAnagram2(String first, String second) {
        if (first == null || second == null)
            return false;

        final int ENGLISH_ALPHABET = 26;

        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        second = second.toLowerCase();

        for (int i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        for (int i = 0; i < second.length(); i++) {
            var index = frequencies[second.charAt(i) - 'a'];
            if (index == 0)
                return false;

            frequencies[index]--;
        }

        return true;
    }

    public static boolean isPalindrome(String str) {
        if (str == null)
            return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }

        return true;
    }
}
