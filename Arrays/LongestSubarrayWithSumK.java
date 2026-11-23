package Arrays;

public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int sum = arr[0];
        int maxLength = 0;

        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k)
                maxLength = Math.max(maxLength, right - left + 1);

            right++;
            if (right < n)
                sum += arr[right];


        }

        return maxLength;
    }
}
