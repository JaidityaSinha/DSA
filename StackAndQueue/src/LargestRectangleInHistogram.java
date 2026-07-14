import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int height = heights[stack.pop()];

                int prevSmaller = stack.isEmpty() ? -1 : stack.peek();

                int width = i - prevSmaller - 1;

                max = Math.max(max, height * width);
            }

            stack.push(i);
        }


        return max;
    }
}
