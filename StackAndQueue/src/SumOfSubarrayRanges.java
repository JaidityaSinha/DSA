package StackAndQueue.src;

import java.util.ArrayDeque;
import java.util.Stack;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMax(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[] nge = findNge(arr);
        int[] pge = findPge(arr);

        for (int i = 0; i < n; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;

            long contribution = (long) left * right * arr[i];
            sum += contribution;
        }

        return sum;
    }

    private int[] findNge(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;
        int[] nge = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] <= curr)
                stack.pop();

            nge[i] = (stack.isEmpty()) ? n : stack.peek();

            stack.push(i);
        }

        return nge;
    }

    private int[] findPge(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] pge = new int[n];

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] < curr)
                stack.pop();

            pge[i] = (stack.isEmpty()) ? -1 : stack.peek();

            stack.push(i);
        }

        return pge;
    }


    public long sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            long contribution = (long) left * right * arr[i];
            sum += contribution;
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
        ArrayDeque<Integer> stack = new ArrayDeque<>();
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
