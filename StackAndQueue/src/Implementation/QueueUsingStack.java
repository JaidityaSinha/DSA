package StackAndQueue.src.Implementation;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int n) {
        s1.push(n);
    }

    public int pop() {
        if (!s2.isEmpty())
            return s2.pop();
        else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
            return s2.pop();
        }
    }

    public int peek() {
        if (!s2.isEmpty())
            return s2.peek();
        else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
            return s2.peek();
        }
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
