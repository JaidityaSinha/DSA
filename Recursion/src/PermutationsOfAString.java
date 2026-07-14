import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsOfAString {
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> findPermutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        recurse(chars, used, stringBuilder);;

        return list;
    }

    private void recurse(char[] s,boolean[] used, StringBuilder stringBuilder) {
        if (stringBuilder.length() == s.length) {
            list.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (used[i])
                continue;

            if (i > 0 && s[i] == s[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            stringBuilder.append(s[i]);
            recurse(s,  used, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            used[i] = false;
        }
    }
}
