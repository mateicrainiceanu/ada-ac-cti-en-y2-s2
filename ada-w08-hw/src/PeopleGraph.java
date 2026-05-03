import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PeopleGraph {

    private ArrayList<String> people;
    private SimpleGraphMatrix graph;

    public PeopleGraph(int count) {
        this.graph = new SimpleGraphMatrix(count);
        this.people = new ArrayList<>(count);
    }

    static PeopleGraph fromFile(String filename) {
        try {
            Scanner input = new Scanner(new File(filename));

            int count = input.nextInt();
            PeopleGraph pg = new PeopleGraph(count);

            input.nextLine();
            while (input.hasNextLine() && count > 0) {
                pg.addPerson(input.nextLine());
                count--;
            }

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.isEmpty()) continue;
                String[] tokens = line.split(" ");
                pg.addConnection(tokens[0], tokens[1]);
            }

            return pg;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPerson(String person) {
        people.add(person);
    }

    public void addConnection(String person1, String person2) {
        int idx1 = people.indexOf(person1);
        int idx2 = people.indexOf(person2);
        graph.addUndirectedEdge(idx1, idx2);
    }


    private ArrayList<String> bfsComponent(int startNode, boolean[] visited) {
        ArrayList<String> component = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(people.get(node));
            for (int neighbor : graph.nodesAdjacentTo(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return component;
    }

    public void printBiggestInfluenceGroup() {
        int n = people.size();
        boolean[] visited = new boolean[n];
        ArrayList<String> biggest = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ArrayList<String> component = bfsComponent(i, visited);
                if (component.size() > biggest.size()) {
                    biggest = component;
                }
            }
        }

        System.out.println("Biggest group of influence - size: " + biggest.size());
    }

    public void print() {
        graph.printGraph();
    }

}
