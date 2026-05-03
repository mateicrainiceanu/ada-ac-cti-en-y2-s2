import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        String FILENAME = "ada-w08-hw/articles.txt";

        CollaborationGraph cg = CollaborationGraph.fromFile(FILENAME);

        Scanner input = new Scanner(System.in);
        System.out.print("First scientist: ");
        String name1 = input.nextLine().trim();
        System.out.print("Second scientist: ");
        String name2 = input.nextLine().trim();

        int distance = cg.collaborativeDistance(name1, name2);

        if (distance == -1)
            System.out.println("No collaboration path found between " + name1 + " and " + name2);
        else
            System.out.println("Collaborative distance between " + name1 + " and " + name2 + ": " + distance);
    }
}