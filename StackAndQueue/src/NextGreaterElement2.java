package StackAndQueue.src;

import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 2*n - 1; i >= 0; i--) {
            int curr = nums[i % n];

            while (!stack.isEmpty() && stack.peek() <= curr)
                stack.pop();

            if (i < n)
                nums[i] = (stack.isEmpty()) ? -1 : stack.peek();

            stack.push(curr);
        }

        return nums;
    }
}
