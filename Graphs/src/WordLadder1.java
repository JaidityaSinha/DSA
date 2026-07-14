import java.util.*;

public class WordLadder1 {
    static class Pair {
        StringBuilder word;
        int length;

        public Pair(StringBuilder word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(new StringBuilder(beginWord), 1));

        Set<String> set = new HashSet<>(wordList);
        int maxSequence = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();

            if (curr.word.toString().equals(endWord))
                maxSequence = Math.max(maxSequence, curr.length);

            for (int i = 0; i < curr.word.length(); i++) {
                char original = curr.word.charAt(i);

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    curr.word.setCharAt(i, ch);
                    String newWord = curr.word.toString();
                    if (set.contains(newWord)) {
                        queue.add(new Pair(new StringBuilder(newWord), curr.length + 1));
                        set.remove(newWord);
                    }
                }

                curr.word.setCharAt(i, original);
            }
        }

        return maxSequence;
    }
}
