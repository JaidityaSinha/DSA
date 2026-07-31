package StackAndQueue.src.Implementation;

public class ImplementQueueUsingArrays {
    int size;

    public ImplementQueueUsingArrays(int size) {
        this.size = size;
    }

    int[] queue = new int[size];
    int currSize = -1;
    int start = -1, end = -1;

    public void push(int n) {
        if (start == -1 && end == -1) {
            start++;
            end++;
            currSize++;

            queue[end] = n;
        }
        else if (start != -1) {
            end = (end + 1) % size;
            currSize++;

            queue[end] = n;
        }
    }

    public int peek() {
        if (start != -1) {
            currSize--;
            return queue[start++];
        }

        else throw new NullPointerException();
    }

    public int pop() {
        int popped = queue[start];

        if (currSize == 1)
            start = end = -1;
        else
            start = (start + 1) % size;

        currSize--;
        return popped;
    }

}
