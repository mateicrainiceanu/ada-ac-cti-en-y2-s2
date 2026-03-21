
import java.util.LinkedList;


/**
 * A Generic BST implementation
 */
public class GenericBST<K extends Comparable<K>, V> {
    public static class Node<A extends Comparable<A>, B> {
        A key;           // sorted by Key
        B val;         // associated data
        Node<A, B> left, right;  // left and right subtrees

        Node(A key, B val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node {" + this.key + "," + this.val + "}";
        }

    }

    private Node<K, V> root;

    public GenericBST() {
        root = null;        // initializes empty BST
    }

    /**
     * Print keys in ascending order by
     * doing an inorder tree walk
     */
    public void inorder() {
        System.out.println("----- INORDER TRAVERSAL OF BST -------");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<K, V> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public void preorder() {
        System.out.println("----- PREORDER TRAVERSAL OF BST -------");
        preorder(root);
        System.out.println();

    }

    private void preorder(Node<K, V> node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder() {
        System.out.println("----- POSTORDER TRAVERSAL OF BST -------");
        postorder(root);
        System.out.println();

    }

    private void postorder(Node<K, V> node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }


    /**
     * Searches for a given key in the BST
     * returns true if the key is contained in the BST and false otherwise
     */
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node<K, V> node, K key) {
        if (node == null) return false;
        if (node.key.compareTo(key) == 0) return true;
        if (node.key.compareTo(key) < 0) return contains(node.right, key);
        return contains(node.left, key);
    }

    /**
     * Inserts the specified key-value pair, overwriting the old
     * value in the node with the new value if the BST already contains the key.
     */
    public void put(K key, V val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        root = put(root, key, val);
    }

    private Node<K, V> put(Node<K, V> x, K key, V val) {
        if (x == null) return new Node<>(key, val);

        if (key.compareTo(x.key) < 0)
            x.left = put(x.left, key, val);
        else if (key.compareTo(x.key) > 0)
            x.right = put(x.right, key, val);
        else x.val = val;

        return x;
    }


    /**
     * Deletes the node containing the specified key
     */
    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = deleteRecursive(root, key);
    }

    private Node<K, V> deleteRecursive(Node<K, V> node, K key) {
        if (node == null) return null;

        if (key.compareTo(node.key) < 0) {
            node.left = deleteRecursive(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = deleteRecursive(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node<K, V> succ = successor(node);
            if (succ == null) throw new RuntimeException("Unexpected null in successor call");
            node.key = succ.key;
            node.val = succ.val;

            node.right = deleteRecursive(node.right, succ.key);
        }

        return node;
    }

    public int getHeight() {
        return getMaxHeightFrom(root);
    }

    private int getMaxHeightFrom(Node<K, V> node) {
        if (node == null) return 0;
        int heightLeft = getMaxHeightFrom(node.left);
        int heightRight = getMaxHeightFrom(node.right);

        return Math.max(heightLeft, heightRight) + 1;
    }

    public boolean isBST() {
        return !isNoBST(root);
    }

    private boolean isNoBST(Node<K, V> n) {
        if (n == null) return false;
        if (n.left != null && n.key.compareTo(n.left.key) <= 0) return true;
        if (n.right != null && n.key.compareTo(n.right.key) >= 0) return true;

        return isNoBST(n.left) || isNoBST(n.right);
    }

    public Node<K, V> findWithKey(K key) {
        return findWithKey(root, key);
    }

    private Node<K, V> findWithKey(Node<K, V> current, K key) {
        if (current == null) return null;
        if (key.compareTo(current.key) == 0) {
            return current;
        }

        if (key.compareTo(current.key) > 0) return findWithKey(current.right, key);
        return findWithKey(current.left, key);
    }

    public V min() {
        return min(root).val;
    }

    private Node<K, V> min(Node<K, V> node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public V max() {
        return max(root).val;
    }

    private Node<K, V> max(Node<K, V> node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    private Node<K, V> successor(Node <K, V> node) {
        if (node.right == null) return null;
        return min(node.right);
    }

    private Node<K, V> predecessor(Node<K, V> node) {
        if (node.left == null) return null;
        return max(node.left);
    }

    public void printLevels() {
        LinkedList<LinkedList<K>> levels = new LinkedList<>();
        addContents(root, levels, 0);

        System.out.println(levels);
    }

    public void addContents(Node<K, V> node, LinkedList<LinkedList<K>> l, int lvl) {
        if (node == null) return;

        if (l.size() <= lvl) {
            l.add(new LinkedList<>());
        }

        l.get(lvl).add(node.key);

        addContents(node.left, l, lvl + 1);
        addContents(node.right, l ,lvl + 1);

    }

    public Node<K, V> searchIterative(K key) {
        Node <K, V> node = root;

        while (node != null && node.key.compareTo(key) != 0) {
            if (node.key.compareTo(key) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return node;
    }

    public Node<K, V> minIterative() {
        Node <K, V> node = root;

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }



}