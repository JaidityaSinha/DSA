package StackAndQueue.src;

import java.util.Stack;

public class MinStack {
    Stack<Long> stack;
    long min = Long.MIN_VALUE;      // Long to avoid int overflow
    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            min = value;
            stack.push((long) value);
        }
        else {
            if (value > min)
                stack.push((long) value);
            else {
                stack.push(2 * (long) value - min);
                min = value;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long x = stack.pop();

        if (x < min) {
            min = 2 * min - x;
        }
    }

    public int top() {
        long x = stack.peek();

        return (int) Math.max(min, x);
    }

    public int getMin() {
        return (int) min;
    }
}
