package StackAndQueue.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        if (k == num.length())
            return "0";

        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0  && stack.peekLast() > ch) {
                stack.removeLast();
                k--;
            }
            stack.addLast(ch);
        }

        while (k > 0) {
            stack.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;


        while (!stack.isEmpty()) {
            char ch = stack.removeFirst();

            if (leadingZero && ch == '0')
                continue;

            leadingZero = false;
            sb.append(ch);
        }

        return (sb.isEmpty()) ? "0" : sb.toString();

    }
}
