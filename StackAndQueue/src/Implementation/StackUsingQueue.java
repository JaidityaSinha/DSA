package StackAndQueue.src.Implementation;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue = new ArrayDeque<>();

    public void push(int n) {
        int size = queue.size();

        queue.add(n);

        for (int i = 0; i < size; i++) {
            int temp = queue.remove();
            queue.add(temp);
        }
    }

    public void pop() {
        queue.remove();
    }
}
