public class Main {
    public static void main(String[] args) {
        GenericBST<Integer, String> tree = new GenericBST<>();

        tree.insert(5, "five");
        tree.insert(3, "three");
        tree.insert(4, "four");
        tree.insert(1, "one");
        tree.insert(7, "seven");
        tree.insert(15, "fifteen");
        tree.insert(17, "seventeen");

        tree.inorder();
    }
}