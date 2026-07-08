import java.io.IOException;


/**
 * Implements DepthFirstSearch on simple undirected graph
 */
public class DepthFirstSearch {

    enum Color {WHITE, GREY, BLACK}

    private ISimpleGraph G;

    private Color[] color;      // color[v] = status of node v

    private int[] parent;      // parent[v] = previous node on DFS search


    /**
     * Performs the DFS search starting from the source vertex {@code s}
     * in the undirected graph {@code G}.
     * Only vertices in the same connected component with s will be reached.
     * Vertices reached by the DFS will have color BLACK.
     *
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DepthFirstSearch(ISimpleGraph G, int s) {

        this.G = G;
        int V = G.getNrVertices();

        if (!G.hasVertex(s))
            throw new IllegalArgumentException("vertex " + s + " is not between 0 and " + (V - 1));

        color = new Color[V];
        parent = new int[V];

        for (int v = 0; v < G.getNrVertices(); v++) {
            color[v] = Color.WHITE;
        }
        dfs(G, s);
    }

    // depth-first search from a single source
    private void dfs(ISimpleGraph G, int source) {
        color[source] = Color.GREY;   // start exploring source
        System.out.print(source + " ");
        for (int v : G.nodesAdjacentTo(source)) {
            if (color[v] == Color.WHITE) {  // first time encounter v
                parent[v] = source;
                dfs(G, v);                  // start exploring v
            }
        }
        color[source] = Color.BLACK;     // finished exploring source
    }

    /**
     * Is there a path between the source vertex s, that has been
     * set in constructor, and vertex v?
     *
     * @param v the vertex
     * @return true if there is a path, false otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean isConnectedTo(int v) {
        int V = G.getNrVertices();

        if (!G.hasVertex(v))
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));

        return (color[v] == Color.BLACK);
    }
}