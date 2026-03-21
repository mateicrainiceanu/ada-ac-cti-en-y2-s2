public class Main {
    public static void main(String[] args) {
        GenericBST<Integer, Integer> bst = new GenericBST<>();

        bst.put(5, 5);
        bst.put(3, 3);
        bst.put(2, 2);
        bst.put(1, 1);
        bst.put(6, 6);
        bst.put(7, 7);
        bst.put(8, 8);

        bst.inorder();
        bst.preorder();
        bst.postorder();

        System.out.println("------ TEST CONTAINS ----------");
        System.out.print(bst.contains(1) + " ");
        System.out.print(bst.contains(2) + " ");
        System.out.print(bst.contains(3) + " ");
        System.out.print(bst.contains(5) + " ");
        System.out.print(bst.contains(6) + " ");
        System.out.print(bst.contains(7) + " ");
        System.out.print(bst.contains(8) + " ");
        System.out.print(bst.contains(4) + " ");
        System.out.print(bst.contains(-10) + " ");
        System.out.println(bst.contains(20) + " ");

        System.out.println("------ isBST TEST -------");
        System.out.println(bst.isBST());

        System.out.println("------ findWithKey -------");
        System.out.println(bst.findWithKey(6));
        System.out.println(bst.findWithKey(4));

        System.out.println("----Min and max-----");
        System.out.println("Min is: " + bst.min());
        System.out.println("Max is: " + bst.max());

        System.out.println("Height " + bst.getHeight());

        System.out.println("--------- PRINT ON LEVELS ---------");
        bst.printLevels();

        System.out.println("---------- search iterative -----------");
        System.out.println(bst.searchIterative(10));
        System.out.println(bst.searchIterative(8));

        System.out.println("---------- min iterative -----------");
        System.out.println(bst.minIterative());

        System.out.println("-------- TESTING DELETE ---------");
        bst.delete(3);
        bst.inorder();
        bst.delete(5);
        bst.inorder();
        bst.delete(1);
        bst.inorder();
        bst.delete(8);
        bst.inorder();
        bst.delete(7);
        bst.inorder();
        bst.delete(6);
        bst.inorder();
        bst.delete(2);
        bst.inorder();

    }
}