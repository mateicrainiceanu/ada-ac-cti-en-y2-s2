package CrazyStack;

public class Main {
    public static void main(String[] args) {
        CrazyStack<Integer> stack = new CrazyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println(" ----------- ");

        CrazyStack<String> stack2 = new CrazyStack<String>();
        stack2.push("abc");
        stack2.push("def");
        stack2.push("ghi");

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
        System.out.println(" ----------- ");

        CrazyStack<Double> stack3 = new CrazyStack<Double>();
        stack3.push(1.1);
        stack3.push(1.2);
        stack3.push(1.3);

        while (!stack3.isEmpty()) {
            System.out.println(stack3.pop());
        }
        System.out.println(" ----------- ");




    }
}
