package CrazyStack;

import java.util.ArrayDeque;
import java.util.Queue;

public class CrazyStack <T> implements MyStack<T> {

    Queue<T> primaryQueue = new ArrayDeque<>();
    Queue<T> secondaryQueue = new ArrayDeque<>();

    @Override
    public void push(T item) {
        primaryQueue.offer(item);
    }

    private T moveAllToSecondaryQueueAndReturnLast() {
        T last = null;
        do {
            last = primaryQueue.poll();
            if (!primaryQueue.isEmpty()) secondaryQueue.offer(last);
        } while (!primaryQueue.isEmpty());

        return last;
    }

    private void moveAllToPrimaryQueue() {
        while (!secondaryQueue.isEmpty()) {
            primaryQueue.offer(secondaryQueue.poll());
        }
    }

    @Override
    public T pop() {
        T result = moveAllToSecondaryQueueAndReturnLast();
        moveAllToPrimaryQueue();
        return result;
    }

    @Override
    public boolean isEmpty() {
        return primaryQueue.isEmpty();
    }
}
