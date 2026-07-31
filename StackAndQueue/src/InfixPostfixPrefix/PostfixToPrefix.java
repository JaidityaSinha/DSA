package StackAndQueue.src.InfixPostfixPrefix;

import java.util.Stack;

public class PostfixToPrefix {public static String postfixToPrefix(String s) {
    Stack<String> stack = new Stack<>();

    for (char ch : s.toCharArray()) {

        if ((ch >= 'a' && ch <= 'z') ||
                (ch >= 'A' && ch <= 'Z') ||
                (ch >= '0' && ch <= '9')) {

            stack.push(String.valueOf(ch));
        }
        else {
            String right = stack.pop();
            String left = stack.pop();

            stack.push(ch + left + right);
        }
    }

    return stack.pop();
}

}
