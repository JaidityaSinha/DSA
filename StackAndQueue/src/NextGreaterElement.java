package StackAndQueue.src;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];

           while (!stack.isEmpty() && stack.peek() <= curr)
               stack.pop();

           if (stack.isEmpty())
               arr[i] = -1;
           else
               arr[i] = stack.peek();

           stack.push(curr);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        return list;
    }
}
