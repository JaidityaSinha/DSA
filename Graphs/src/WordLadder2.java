import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        Queue<List<String>> q = new ArrayDeque<>();
        List<String> start = new ArrayList<>();
        start.add(beginWord);
        q.add(start);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level = 0;

        while (!q.isEmpty()) {

            List<String> vector = q.remove();

            // New level reached
            if (vector.size() > level) {
                level++;

                for (String word : usedOnLevel)
                    set.remove(word);

                usedOnLevel.clear();
            }

            String word = vector.getLast();

            if (word.equals(endWord)) {
                if (ans.isEmpty()) {
                    ans.add(new ArrayList<>(vector));
                }
                else if (ans.getFirst().size() == vector.size()) {
                    ans.add(new ArrayList<>(vector));
                }
            }

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String replacedWord = new String(arr);

                    if (set.contains(replacedWord)) {

                        vector.add(replacedWord);
                        q.add(new ArrayList<>(vector));
                        usedOnLevel.add(replacedWord);
                        vector.removeLast();
                    }
                }

                arr[i] = original;
            }
        }

        return ans;
    }
}
