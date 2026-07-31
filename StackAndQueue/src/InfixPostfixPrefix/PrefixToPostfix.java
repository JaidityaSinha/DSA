package StackAndQueue.src.InfixPostfixPrefix;

import java.util.Stack;

public class PrefixToPostfix {
    public static String prefixToPostfix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z') ||
                    (ch >= '0' && ch <= '9')) {

                stack.push(String.valueOf(ch));
            }
            else {
                String left = stack.pop();
                String right = stack.pop();

                stack.push(left + right + ch);
            }
        }

        return stack.pop();
    }
}
