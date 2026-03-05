package StackClient3;

import java.util.Stack;

public class StackModifier <T> {
    public void rotateByOne(Stack<T> stack) {
        T first = stack.pop();
        Stack<T> temp = new Stack<T>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        stack.push(first);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
