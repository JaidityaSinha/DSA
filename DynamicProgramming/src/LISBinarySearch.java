import java.util.ArrayList;
import java.util.List;

public class LISBinarySearch {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > temp.getLast())
                temp.add(num);
            else {
                int index = lowerBound(num, temp);
                temp.set(index, num);
            }
        }

        return temp.size();
    }

    private int lowerBound(int target, List<Integer> temp) {
        int low = 0;
        int high = temp.size() - 1;
        int result = temp.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (temp.get(mid) >= target) {
                result = mid;
                high = mid - 1;
            }

            else
                low = mid + 1;
        }

        return result;
    }
}
