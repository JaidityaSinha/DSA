package StackAndQueue.src.InfixPostfixPrefix;

import java.util.Stack;

public class PostfixToInfix {
    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z') ||
                    (ch >= '0' && ch <= '9')) {

                stack.push(String.valueOf(ch));
            }
            else {
                String right = stack.pop();
                String left = stack.pop();

                stack.push("(" + left + ch + right + ")");
            }
        }

        return stack.pop();
    }
}
