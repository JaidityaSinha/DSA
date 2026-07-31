package StackAndQueue.src.Implementation;

public class StackUsingLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;
    int size = 0;

    public void push(int n) {
        Node temp = new Node(n);
        temp.next = top;
        top = temp;
        size++;
    }

    public int pop() {
        Node temp = top;
        int val = temp.data;

        temp = null;
        size--;
        return val;
    }

    public int peek() {
        return top.data;
    }

}
