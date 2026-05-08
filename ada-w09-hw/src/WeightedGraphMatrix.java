import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WeightedGraphMatrix implements IWeightedGraph {
    private static final int NO_EDGE = Integer.MAX_VALUE;

    private final int[][] matrix;
    private final int nrVertices;
    private int nrEdges;

    public WeightedGraphMatrix(int nrVertices) {
        this.nrVertices = nrVertices;
        this.nrEdges = 0;
        this.matrix = new int[nrVertices][nrVertices];
        for (int i = 0; i < nrVertices; i++)
            for (int j = 0; j < nrVertices; j++)
                matrix[i][j] = NO_EDGE;
    }

    static WeightedGraphMatrix readFromFile(String filename) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        int nrVertices = in.nextInt();

        WeightedGraphMatrix wgm = new WeightedGraphMatrix(nrVertices);

        while (in.hasNextLine()) {

            int either = in.nextInt();
            int other = in.nextInt();
            int weight = in.nextInt();

            wgm.addUndirectedEdge(either, other,  weight);

        }
        
        return wgm;

    }

    @Override
    public int getNrVertices() {
        return nrVertices;
    }

    @Override
    public int getNrEdges() {
        return nrEdges;
    }

    @Override
    public void addUndirectedEdge(int either, int other, int w) {
        if (!hasEdge(either, other))
            nrEdges++;
        matrix[either][other] = w;
        matrix[other][either] = w;
    }

    @Override
    public Iterable<Integer> nodesAdjacentTo(int node) {
        List<Integer> adjacent = new ArrayList<>();
        for (int i = 0; i < nrVertices; i++)
            if (matrix[node][i] != NO_EDGE)
                adjacent.add(i);
        return adjacent;
    }

    @Override
    public Iterable<WeightedEdge> edgesAdjacentTo(int node) {
        List<WeightedEdge> edges = new ArrayList<>();
        for (int i = 0; i < nrVertices; i++)
            if (matrix[node][i] != NO_EDGE)
                edges.add(new WeightedEdge(node, i, matrix[node][i]));
        return edges;
    }

    @Override
    public Iterable<WeightedEdge> allEdges() {
        List<WeightedEdge> edges = new ArrayList<>();
        for (int i = 0; i < nrVertices; i++)
            for (int j = i + 1; j < nrVertices; j++)
                if (matrix[i][j] != NO_EDGE)
                    edges.add(new WeightedEdge(i, j, matrix[i][j]));
        return edges;
    }

    @Override
    public boolean hasVertex(int node) {
        return node >= 0 && node < nrVertices;
    }

    @Override
    public boolean hasEdge(int either, int other) {
        return hasVertex(either) && hasVertex(other) && matrix[either][other] != NO_EDGE;
    }

    @Override
    public int edgeWeight(int either, int other) {
        if (!hasEdge(either, other))
            throw new IllegalArgumentException("No edge between " + either + " and " + other);
        return matrix[either][other];
    }

    @Override
    public void initFromFile(String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n != nrVertices)
                throw new IllegalArgumentException("File vertex count doesn't match matrix size");
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                int either = Integer.parseInt(parts[0]);
                int other = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                addUndirectedEdge(either, other, w);
            }
        }
    }

    @Override
    public void printGraph() {
        System.out.print("   ");
        for (int i = 0; i < nrVertices; i++)
            System.out.printf("%4d", i);
        System.out.println();
        for (int i = 0; i < nrVertices; i++) {
            System.out.printf("%2d ", i);
            for (int j = 0; j < nrVertices; j++) {
                if (matrix[i][j] == NO_EDGE)
                    System.out.print("   -");
                else
                    System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}