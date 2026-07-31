package StackAndQueue.src;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty())
                    return false;

                char bracket = stack.pop();

                if ((ch == ')' && bracket!= '(') || (ch == ']' && bracket != '[') || (ch == '}' && bracket != '{'))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
