import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILENAME = "ada-w10-hw/cities.txt";

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File(FILENAME));
            int N = in.nextInt();
            int M = in.nextInt();

            IUnionFind uf = new UnionFindUpForest(N);

            for (int i = 0; i < M; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                uf.union(a, b);
            }

            if (uf.count() == 1) {
                System.out.println("All " + N + " cities are already connected.");
                return;
            }

            System.out.println("Cities are NOT fully connected (" + uf.count() + " components).");
            System.out.println("Proposed roads to add (" + (uf.count() - 1) + "):");

            // Collect one representative city per component
            List<Integer> roots = new ArrayList<>();
            boolean[] seen = new boolean[N];
            for (int i = 0; i < N; i++) {
                int root = uf.find(i);
                if (!seen[root]) {
                    seen[root] = true;
                    roots.add(i);   // use i as the representative of its component
                }
            }

            // Connect consecutive component representatives with K-1 roads
            for (int i = 0; i + 1 < roots.size(); i++) {
                System.out.println("  " + roots.get(i) + " - " + roots.get(i + 1));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + FILENAME);
        }
    }
}