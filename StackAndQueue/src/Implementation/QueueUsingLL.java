    package StackAndQueue.src.Implementation;

    public class QueueUsingLL {
        static class Node {
            int data;
            Node next;
            Node(int new_data) {
                data = new_data;
                next = null;
            }
        }

        Node front, rear;

        public void add(int n) {
            Node new_node = new Node(n);
            if (isEmpty())
                front = rear = new_node;
            else {
                rear.next = new_node;
                rear = new_node;
            }
        }

        public void remove() {
            if (isEmpty()) {
                System.out.println("Queue Underflow");
                return;
            }

            Node temp = front;
            front = front.next;
            if (front == null) rear = null;
            temp = null;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }
