package CrazyQueue;

public class Main {
    public static void main(String[] args) {
        CrazyQueue<Integer> intQueue = new CrazyQueue<Integer>();
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);

        while  (!intQueue.isEmpty())
            System.out.print(intQueue.dequeue() + " -> ");
        System.out.println();

        CrazyQueue<String> stringQueue = new CrazyQueue<String>();
        stringQueue.enqueue("abc");
        stringQueue.enqueue("def");
        stringQueue.enqueue("ghi");

        while (!stringQueue.isEmpty())
            System.out.print(stringQueue.dequeue() + " -> ");
        System.out.println();

        CrazyQueue<Double> doubleCrazyQueue = new CrazyQueue<Double>();
        doubleCrazyQueue.enqueue(1.0);
        doubleCrazyQueue.enqueue(2.0);
        doubleCrazyQueue.enqueue(3.0);

        while (!doubleCrazyQueue.isEmpty())
            System.out.print(doubleCrazyQueue.dequeue() + " -> ");
        System.out.println();

    }
}
