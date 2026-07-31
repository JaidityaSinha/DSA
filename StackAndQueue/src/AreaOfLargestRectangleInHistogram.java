package StackAndQueue.src;

import java.util.ArrayDeque;

public class AreaOfLargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int element = stack.pop();
                int nse = i;
                int pse = (stack.isEmpty()) ? -1 : stack.peek();

                int area = heights[element] * (nse - pse - 1);

                max = Math.max(max, area);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int nse = n;
            int element = stack.pop();
            int pse = (stack.isEmpty()) ? -1 : stack.peek();

            int area = heights[element] * (nse - pse - 1);

            max = Math.max(max, area);
        }

        return max;
    }
}
