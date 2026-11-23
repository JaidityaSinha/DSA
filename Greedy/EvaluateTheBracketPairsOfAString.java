package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateTheBracketPairsOfAString {
    public String evaluate(String s, List<List<String>> knowledge) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                start = i;

            else if (s.charAt(i) == ')') {
                end = i;
                String key = s.substring(start + 1, end);
                list.add(map.getOrDefault(key, "?"));
            }
        }

        StringBuilder sb = new StringBuilder(s);

        for (String word : list) {
            int l = sb.indexOf("(");
            int r = sb.indexOf(")", l);

            sb.replace(l, r + 1, word);
        }

        return sb.toString();
    }
}
