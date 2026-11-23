package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LargestConsSeq {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        for (int num : set) {
            if (set.contains(num - 1))
                continue;
            int length = 1;
            while (true) {
                if (set.contains(num + 1)) {
                    length++;
                    num++;
                }
                else
                    break;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }
}
