package CrazyStack;

public interface MyStack<T> {
    void push(T item);    // insert a new object of type T onto stack
    T pop();   // removes and returns object on top of stack
    boolean isEmpty();  // test if stack is empty
}