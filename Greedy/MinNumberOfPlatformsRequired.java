package Greedy;

import java.util.Arrays;

public class MinNumberOfPlatformsRequired {
    public int minPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j= 0;
        int count = 0, maxCount = Integer.MIN_VALUE;

        while (i < arr.length) {
            if (arr[i] < dep[j]) {
                count++;
                i++;
            }

            else {
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
