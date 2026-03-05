public class LinkedListStack <A> {
    // to use as new LinkedListStack.Node<Integer>()
    static public class Node <T> {
        private T value;
        private Node<T> next;
    }

    private Node<A> root;

    public void push(A val) {
        Node <A> node = new Node<>();
        node.value = val;
        node.next = root;
        root = node;
    }

    public A pop() {
        Node<A> oldRoot = root;
        root = root.next;
        return oldRoot.value;
    }

}
