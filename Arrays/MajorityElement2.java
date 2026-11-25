package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int cand1 = Integer.MIN_VALUE, cand2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == cand1)
                count1++;

            else if (num == cand2)
                count2++;

            else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            }

            else {
                count1--;
                count2--;
            }

        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == cand1)
                count1++;
            else if (num == cand2)
                count2++;
        }

        int threshold = nums.length / 3;

        if (count1 > threshold)
            list.add(cand1);
        if (count2 > threshold)
            list.add(cand2);

        return list;
    }
}
