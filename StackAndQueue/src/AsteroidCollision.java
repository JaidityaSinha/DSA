package StackAndQueue.src;

import java.util.ArrayDeque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0 || stack.peek() < 0) {
                stack.push(asteroid);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid)
                stack.pop();

            if (stack.isEmpty() || stack.peek() < 0)
                stack.push(asteroid);
            else if (stack.peek() == -asteroid)
                stack.pop();
        }


        int[] ans = new int[stack.size()];

        int i = 0;
        while (!stack.isEmpty()) {
            ans[ans.length - 1 - i] = stack.pop();
            i++;
        }

        return ans;
    }
}
