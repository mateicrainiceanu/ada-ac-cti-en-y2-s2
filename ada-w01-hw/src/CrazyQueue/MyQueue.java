package CrazyQueue;

public interface MyQueue<T> {
    void enqueue(T item);    // add a new object of type T to queue
    T dequeue();   // removes and returns oldest object in queue
    boolean isEmpty();  // test if queue is empty
}