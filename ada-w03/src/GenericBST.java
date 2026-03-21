public class GenericBST<K extends Comparable<K>, V> {

    public static class Node<A extends Comparable<A>, B> {
        A key;
        B value;
        Node<A, B> left;
        Node<A, B> right;

        public Node(A key, B value) {
            this.value = value;
            this.key = key;
        }
    }

    private Node<K, V> root;

    public void insert(final K key, final V value) {
        root = insert(root, key, value);
    }

    private Node<K, V> insert(Node<K, V> node, final K key, final V value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0){
            node.right = insert(node.right, key, value);
        } else { //key is equal to node.key
            // just modify the value;
            node.value = value;
        }

        return node;
    }


    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<K, V> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);
    }



}
