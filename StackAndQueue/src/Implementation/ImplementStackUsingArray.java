package StackAndQueue.src.Implementation;

public class ImplementStackUsingArray {

    int size = 0;

    public ImplementStackUsingArray(int size) {
        this.size = size;
    }

    int[] stack = new int[size];
    int index = 0;
    int peek = -1;

    public void push(int n) {
        if (index != size) {
            stack[index++] = n;
            peek++;
        }
    }

    public int pop() {
        if (peek != -1) {
            index--;
            return stack[peek--];
        }
        else throw new NullPointerException();
    }

    public int peek() {
        return stack[peek];
    }

    public int size() {
        return index;
    }

}
