import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        backtrack(0, s, current);

        return list;
    }

    private void backtrack(int index, String s, List<String> current) {
        if (index == s.length()) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++)
            if (isPalindrome(s, index, i)) {
                current.add(s.substring(index, i + 1));
                backtrack(i + 1, s, current);
                current.removeLast();
            }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end)
            if (s.charAt(start++) != s.charAt(end--))
                return false;

        return true;
    }
}
