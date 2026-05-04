import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CollaborationGraph {

    private ArrayList<String> scientists;
    private SimpleGraphMatrix graph;

    public CollaborationGraph(int count) {
        this.graph = new SimpleGraphMatrix(count);
        this.scientists = new ArrayList<>(count);
    }

    static CollaborationGraph fromFile(String filename) {
        try {
            Scanner input = new Scanner(new File(filename));
            ArrayList<String[]> articles = new ArrayList<>();
            LinkedHashSet<String> uniqueScientists = new LinkedHashSet<>(); // preserves the order and also removes duplicates

            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] authors = line.split(" ");
                articles.add(authors);
                for (String author : authors)
                    uniqueScientists.add(author);
            }

            CollaborationGraph cg = new CollaborationGraph(uniqueScientists.size());
            for (String name : uniqueScientists)
                cg.addScientist(name);

            for (String[] authors : articles)
                for (int i = 0; i < authors.length; i++)
                    for (int j = i + 1; j < authors.length; j++)
                        cg.addCollaboration(authors[i], authors[j]);

            return cg;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addScientist(String name) {
        scientists.add(name);
    }

    public void addCollaboration(String scientist1, String scientist2) {
        int idx1 = scientists.indexOf(scientist1);
        int idx2 = scientists.indexOf(scientist2);
        if (!graph.hasEdge(idx1, idx2))
            graph.addUndirectedEdge(idx1, idx2);
    }

    public int collaborativeDistance(String name1, String name2) {
        int start = scientists.indexOf(name1);
        int end = scientists.indexOf(name2);

        if (start == -1 || end == -1) return -1;
        if (start == end) return 0;

        int[] dist = new int[scientists.size()];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.nodesAdjacentTo(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    if (neighbor == end) return dist[neighbor];
                    queue.add(neighbor);
                }
            }
        }

        return -1;
    }
}