import java.util.Scanner;

public class Main {

    private static final String FILENAME = "ada-w09-hw/g.txt";

    public static void main(String[] args) {

        try {
            WeightedGraphMatrix wgm = WeightedGraphMatrix.readFromFile(FILENAME);

            //wgm.printGraph();

            PrimWithPriorityQueue pq = new PrimWithPriorityQueue();

            System.out.println(pq.mstEdgeList(wgm));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}