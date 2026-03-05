package StackClient3;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original stack: " + stack);

        StackModifier<Integer> stackModifier = new StackModifier<>();
        stackModifier.rotateByOne(stack);

        System.out.println("Modified stack: " + stack);

    }
}
