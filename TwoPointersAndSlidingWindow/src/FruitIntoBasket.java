import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        int maxLen = 0, l = 0, r = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while (r < fruits.length) {
            freq.put(fruits[r], freq.getOrDefault(fruits[r], 0) + 1);

           if (freq.size() > 2) {
                freq.put(fruits[l], freq.get(fruits[l]) - 1);
                if (freq.get(fruits[l]) == 0)
                    freq.remove(fruits[l]);
                l++;
           }

           if (freq.size() <= 2) {
               int len = r - l + 1;
               maxLen = Math.max(maxLen, len);
           }

            r++;
        }

        return maxLen;
    }
}
