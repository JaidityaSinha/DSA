import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] height = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

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
