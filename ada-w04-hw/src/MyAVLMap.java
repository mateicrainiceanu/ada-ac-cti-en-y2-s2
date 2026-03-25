
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MyAVLMap<Key extends Comparable<Key>, Value> implements MySortedMap<Key, Value> {
    private Node<Key, Value> root;             // root of BST

    static class Node<Key, Value> {
        private Key key;      // sorted by key
        private Value val;         // associated data

        private int height;     //height of node
        private Node<Key, Value> left, right;  // left and right subtrees

        public Node(Key key, Value val, int height) {
            this.key = key;
            this.val = val;
            this.height = height;
        }
    }


    /**
     * Initializes an empty Map.
     */
    public MyAVLMap() {
        root = null;
    }

    /**
     * Searches if a key is contained in the Map.
     *
     * @param key - the key to be searched
     * @return true if this map contains a mapping for the specified key
     */
    @Override
    public boolean containsKey(Key key) {
        return containsKey(root, key);
    }

    private boolean containsKey(Node<Key, Value> node, Key key) {
        if (node == null) return false;
        if (node.key.compareTo(key) == 0)
            return true;

        if (node.key.compareTo(key) < 0) return containsKey(node.right, key);
        return containsKey(node.left, key);
    }

    /**
     * Searches the associated value of a key.
     *
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    @Override
    public Value get(Key key) {
        System.out.println("!!! get() not yet implemented");
        return null;
    }


    /**
     * @return all keys as an Iterable in ascending order
     */
    @Override
    public Iterable<Key> getKeys() {
        Queue<Key> q= new LinkedList<Key>();
        keys(root, q);
        return q;
    }

    private void keys(Node<Key, Value> x, Queue<Key> q) {
        if (x==null) return;
        keys(x.left, q);
        q.add(x.key);
        keys(x.right,q);
    }

    /**
     * @return all entries as an Iterable in ascending order of keys
     */
    @Override
    public Iterable<Map.Entry<Key, Value>> getEntries() {
        Queue<Map.Entry<Key, Value>> q = new LinkedList<Map.Entry<Key, Value>>();
        getEntries(root, q);
        return q;
    }

    private void getEntries(Node<Key, Value> node, Queue<Map.Entry<Key, Value>> q) {
        if (node == null) return;

        getEntries(node.left, q);
        q.add(new AbstractMap.SimpleEntry<>(node.key, node.val));
        getEntries(node.right, q);
    }



    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a value for the key, the old value
     * is replaced by the specified value.
     *
     * @param key - the new key
     * @param val - the new value
     */
    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            remove(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node<Key, Value> put(Node<Key, Value> x, Key key, Value val) {
        if (x == null) return new Node<Key, Value>(key, val, 0);
        if (key.compareTo(x.key)<0) {
            x.left = put(x.left, key, val);
        } else if (key.compareTo(x.key)>0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
            return x;
        }
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }

    private int height(Node<Key, Value> x) {
        if (x == null) return -1;
        return x.height;
    }


    /**
     * Restores the AVL balance property of the subtree.
     *
     * @param x the root of the subtree
     * @return the subtree with restored AVL balance property
     */
    private Node<Key, Value> balance(Node<Key, Value> x) {
        if (balanceFactor(x) < -1) {
            if (balanceFactor(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        } else if (balanceFactor(x) > 1) {
            if (balanceFactor(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }

    /**
     * The balance factor is defined  as the difference between
     * height of the left subtree and height of the right subtree
     * A subtree with a balance factor of -1, 0 or 1 is AVL
     *
     * @param x the root of a subtree
     * @return the balance factor of the subtree
     */
    private int balanceFactor(Node<Key, Value> x) {
        return height(x.left) - height(x.right);
    }

    /**
     * Rotates the given subtree to the right.
     *
     * @param y the root of the subtree
     * @return the right rotated subtree
     */
    private Node<Key, Value> rotateRight(Node<Key, Value> y) {
        //System.out.println("rotate right at " + y.key);
        Node<Key, Value> x = y.left;
        y.left = x.right;
        x.right = y;
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return x;
    }

    /**
     * Rotates the given subtree to the left.
     *
     * @param x the root of the subtree
     * @return the left rotated subtree
     */
    private Node<Key, Value> rotateLeft(Node<Key, Value> x) {
        //System.out.println("rotate left at " + x.key);
        Node<Key, Value> y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));
        return y;
    }

    /**
     * Removes the mapping containing given key from this map if it is present.
     *
     * @param key - key whose mapping is to be removed
     */
    @Override
    public void remove(Key key) {
        System.out.println("!!! remove() not yet implemented in MyAVLTreeMap! ");
        root = delete(root, key);
    }
    
    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        if (node == null) return null;

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node<Key, Value> succ = successor(node);
            if (succ == null) throw new RuntimeException("Unexpected null in successor call");
            node.key = succ.key;
            node.val = succ.val;

            node.right = delete(node.right, succ.key);
        }


        return balance(node);
    }

    private Node<Key, Value> successor(Node<Key, Value> node){
            if (node.right == null) return null;
            return min(node.right);
    }

    private Node<Key, Value> min(Node<Key, Value> node) {
        if (node.left == null) return node;
        return min(node.left);
    }


}