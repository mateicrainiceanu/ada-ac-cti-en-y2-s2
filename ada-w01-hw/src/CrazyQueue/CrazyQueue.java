package CrazyQueue;

import java.util.Stack;

public class CrazyQueue<T> implements MyQueue<T> {

    Stack<T> primary = new Stack<>();
    Stack<T> secondary = new Stack<>();

    @Override
    public void enqueue(T item) {
        primary.push(item);
    }

    private void moveAllToSecondary() {
        while (!primary.isEmpty()) {
            secondary.push(primary.pop());
        }
    }

    private void moveAllToPrimary() {
        while (!secondary.isEmpty()) {
            primary.push(secondary.pop());
        }
    }

    @Override
    public T dequeue() {

        moveAllToSecondary();
        T result = secondary.pop();
        moveAllToPrimary();

        return result;
    }

    @Override
    public boolean isEmpty() {
        return primary.isEmpty();
    }
}
