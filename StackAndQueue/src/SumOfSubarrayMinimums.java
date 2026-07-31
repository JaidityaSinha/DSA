package StackAndQueue.src;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    private static final int INT_MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            long contribution = (long) left * right * arr[i];
            sum = (int) ((sum + contribution) % INT_MOD);
        }

        return sum;
    }

    private int[] findNse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] >= curr)
                stack.pop();

            nse[i] = (stack.isEmpty()) ? n : stack.peek();

            stack.push(i);
        }

        return nse;
    }

    private int[] findPse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > curr)
                stack.pop();

            pse[i] = (stack.isEmpty()) ? -1 : stack.peek();

            stack.push(i);
        }

        return pse;
    }
}
