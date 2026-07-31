package StackAndQueue.src.InfixPostfixPrefix;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('^', 3);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('+', 1);
        priority.put('-', 1);

        for (char ch : s.toCharArray()) {

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());

                stack.pop(); // remove '('
            }
            else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && (priority.get(ch) < priority.get(stack.peek())
                        || (priority.get(ch).equals(priority.get(stack.peek())) && ch != '^'))) {
                    sb.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }
}
