package Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;
        
        for (int i = n - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }

        if (breakPoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }


        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums, i, breakPoint);
                break;
            }
        }

        reverse(nums, breakPoint + 1, n - 1);

        return;
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

}
