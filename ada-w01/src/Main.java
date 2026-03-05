import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedListStack<Integer> list = new LinkedListStack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());

        System.out.println("____________\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("____________\n");

        Queue<Integer> queue = new ArrayDeque<>(); // doesnt sort the elements
        //Queue<Integer> queue = new PriorityQueue<>(); // sorts the elements
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());


    }
}