import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PeopleGraph {

    private ArrayList<String> people;
    private SimpleGraphMatrix graph;

    public PeopleGraph(int count) {
        this.graph = new SimpleGraphMatrix(count);
        this.people = new ArrayList<>(count);
    }

    static PeopleGraph fromFile (String filename) {
        try {
            Scanner input = new Scanner(new File(filename));


            // int
            int count = input.nextInt();

            PeopleGraph graph = new PeopleGraph(count);

            input.nextLine();
            while (input.hasNextLine() && count > 0) {
                graph.addPerson(input.nextLine());
                count--;
            }

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.isEmpty()) continue;
                String [] tokens = line.split(" ");
                graph.addConnection(tokens[0], tokens[1]);
            }

            graph.print();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void addPerson(String person) {
        people.add(person);
    }

    public void addConnection(String person1, String person2) {
        int idx1 =  people.indexOf(person1);
        int idx2 = people.indexOf(person2);

        graph.addUndirectedEdge(idx1, idx2);
    }

    public void print() {
        graph.printGraph();
    }

}
