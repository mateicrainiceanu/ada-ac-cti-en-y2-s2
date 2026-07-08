import java.util.LinkedList;
import java.util.Queue;

    /**
     * Implements BreadthFirstSearch on simple undirected graph
     */
    public class BreadthFirstSearch {
        enum Color {WHITE, GREY, BLACK}

        private static final int INFINITY = Integer.MAX_VALUE;
        private ISimpleGraph G;
        private Color[] color;     // color[v] = status of node v
        private int[] parent;      // parent[v] = previous node on shortest path from source s to v
        private int[] distTo;      // dist[v] = number of edges that define the
        // shortest path from source s to v

        /**
         * Performs the BFS search starting from the source vertex {@code s}
         * in the undirected graph {@code G}.
         * Only vertices in the same connected component with s will be reached.
         * Vertices reached by the BFS will have color BLACK.
         *
         * @param G the graph
         * @param s the source vertex
         * @throws IllegalArgumentException unless {@code 0 <= s < V}
         */
        public BreadthFirstSearch(ISimpleGraph G, int s) {

            this.G = G;

            int V = G.getNrVertices();

            color = new Color[V];
            distTo = new int[V];
            parent = new int[V];

            if (!G.hasVertex(s))
                throw new IllegalArgumentException("vertex " + s + " is not between 0 and " + (V - 1));

            bfs(G, s);
        }


        // breadth-first search from a single source
        private void bfs(ISimpleGraph G, int source) {
            int V = G.getNrVertices();

            Queue<Integer> q = new LinkedList<>();

            for (int v = 0; v < V; v++) {
                distTo[v] = INFINITY;
                color[v] = Color.WHITE; // WHITE = vertex is new, unknown
                parent[v] = -1;
            }

            // start BFS with source node
            color[source] = Color.GREY; // GREY = start exploring
            distTo[source] = 0;
            parent[source] = -1;
            q.add(source);

            while (!q.isEmpty()) {
                int v = q.remove(); // remove oldest vertex from queue
                for (int w : G.nodesAdjacentTo(v)) {
                    if (color[w] == Color.WHITE) { // first time encounter of vertex w
                        parent[w] = v;
                        distTo[w] = distTo[v] + 1;
                        color[w] = Color.GREY;  // start exploring w
                        q.add(w);               // put w in queue
                    }
                }
                System.out.print(v + " ");
                color[v] = Color.BLACK;         // finished exploring v
            }
            System.out.println();   // finished exploring all nodes
            //  from the same connected component with source
            // At this point, all nodes from the same connected component are BLACK.
            // Nodes from other connected components are still WHITE.
        }


        /**
         * Is there a path between the source vertex s, that has been
         * set in the constructor, and vertex v given here as parameter?
         *
         * @param v the vertex
         * @return true if there is a path, and false otherwise
         * @throws IllegalArgumentException unless {@code 0 <= v < V}
         */
        public boolean hasPathTo(int v) {
            int V = G.getNrVertices();
            if (!G.hasVertex(v))
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
            return (color[v] == Color.BLACK);
        }

        /**
         * Returns the number of edges in a shortest path between
         * the source vertex s, set in the constructor, and vertex v
         *
         * @param v - the vertex
         * @return the number of edges in such a shortest path
         * (or Integer.MAX_VALUE if there is no such path)
         * @throws IllegalArgumentException unless {@code 0 <= v < V}
         */
        public int distTo(int v) {
            int V = G.getNrVertices();
            if (!G.hasVertex(v))
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
            return distTo[v];
        }

        /**
         * Returns a shortest path between the source vertex s, set
         * in the constructor, and vertex v, or null if no such path.
         *
         * @param v the vertex
         * @return the sequence of vertices on a shortest path, as an Iterable
         * @throws IllegalArgumentException unless {@code 0 <= v < V}
         */
        public Iterable<Integer> pathTo(int v) {
            int V = G.getNrVertices();
            if (!G.hasVertex(v))
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
            if (!hasPathTo(v)) return null;

            LinkedList<Integer> path = new LinkedList<>();
            int x;
            for (x = v; distTo[x] != 0; x = parent[x]) { // start from v, go back until source s
                path.addFirst(x);
            }
            path.addFirst(x);
            return path;
        }
}
