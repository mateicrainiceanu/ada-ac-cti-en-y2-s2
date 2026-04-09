public class Main {
    public static void main(String[] args) {
        IntegerBTree b = new IntegerBTree(3);

        int[] a={8,9,10,11,15,20, 17, 22, 25,16, 12, 13, 14, 26, 27, 29, 33, 40, 50, 51, 52, 53};

        for (int i=0; i < a.length; i++) {
            System.out.println("Will insert "+a[i]);
            b.insert(a[i]);
            b.displayLevels();
        }

        System.out.println("-------------------------------");
        System.out.println(b.contains(22));
        System.out.println(b.contains(17));
        System.out.println(b.contains(80));
        System.out.println(b.contains(1));

        System.out.println("-------------------------------");
        System.out.println("Height is " + b.height());

        System.out.println("-------------------------------");
        System.out.println(b.level(17));
        System.out.println(b.level(50));
        System.out.println(b.level(10));
        System.out.println(b.level(8));
        System.out.println(b.level(26));

        System.out.println("-------------------------------");
        System.out.println("Min is " + b.min());
        System.out.println("Max is " + b.max());

        System.out.println("-------------------------------");
        b.inorder();

        System.out.println("-------------------------------");
        System.out.println(b.successor(11));
        System.out.println(b.predecessor(11));
    }
}