package StackAndQueue.src;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmallerElement {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            while (!stack.isEmpty() && stack.peek() >= curr)
                stack.pop();

            arr[i] = (stack.isEmpty()) ? -1 : stack.peek();

            stack.push(curr);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr)
            list.add(num);

        return list;
    }
}
