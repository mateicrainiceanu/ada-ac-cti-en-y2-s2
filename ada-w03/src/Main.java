public class Main {
    public static void main(String[] args) {

        IntegerBST tree = new IntegerBST();

        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(15);
        tree.insert(17);


        tree.inorder();

    }
}