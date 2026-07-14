import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subsWithAtMostKDistinct(nums, k) - subsWithAtMostKDistinct(nums, k - 1);
    }

    private int subsWithAtMostKDistinct(int[] nums, int k) {
        int count = 0, l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.replace(nums[l], map.get(nums[l]) - 1);

                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);

                l++;
            }

            count += r - l + 1;
            r++;
        }

        return count;
    }
}
