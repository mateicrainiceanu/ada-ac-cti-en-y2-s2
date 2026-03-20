public class IntegerBST <K extends Comparable<K>, V> {

    public static class Node <A extends Comparable<A>, B> {
        A value;
        B key;
        Node left;
        Node right;

        public Node(A value, B key) {
            this.value = value;
            this.key = key;
        }
    }

    private Node<K, V> root;

    private void insert(final K key, final V value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, final K key, final V value) {
        if (node == null) {
            return new Node<K, V>(key, value);
        }

        if (key.compareTo(node.left.key) < 0) {
            insert(node.left, key, value);
        } else if (key.compareTo(node.right.key) > 0){
            insert(node.right, key, value);
        } else { //key is equal to node.key
            // just modify the value;
            node.value = value;
        }

        return node;
    }


    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);
    }



}
