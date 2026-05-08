import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimWithPriorityQueue implements IMST {


    static class NodePriority implements Comparable<NodePriority> {
        int node;
        int priority;

        NodePriority(int node, int priority) {
            this.node = node;
            this.priority = priority;
        }

        @Override
        public int compareTo(NodePriority other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof NodePriority)
                return this.node == ((NodePriority) obj).node;
            return false;
        }
    }

    private static final int INF = Integer.MAX_VALUE;


    private boolean[] inMST;
    private int[] parent;
    private int[] key;



    public Iterable<WeightedEdge> mstEdgeList(IWeightedGraph G) {
        int V = G.getNrVertices();

        inMST = new boolean[V];
        key = new int[V];
        parent = new int[V];

        Arrays.fill(inMST, false);
        Arrays.fill(key, INF);
        Arrays.fill(parent, -1);

        for (int v = 0; v < V; v++) {
            if (!inMST[v]) {
                doPrimWithJavaPQ(G, v);
            }
        }
        Queue<WeightedEdge> mst = new LinkedList<>();
        for (int u = 0; u < V; u++) {
            if (parent[u] != -1) {
                WeightedEdge e = new WeightedEdge(parent[u], u, key[u]);
                mst.add(e);
            }
        }
        return mst;
    }
    private void doPrimWithJavaPQ(IWeightedGraph G, int src) {
        PriorityQueue<NodePriority> pq = new PriorityQueue<>();

        key[src] = 0;
        pq.add(new NodePriority(src, key[src]));

        while (!pq.isEmpty()) {
            int v = pq.remove().node;

            inMST[v] = true;

            for (WeightedEdge e : G.edgesAdjacentTo(v)) {
                int vv = e.other(v);
                int weight = e.weight();

                if (!inMST[vv] && key[vv] > weight) {
                    pq.remove(new NodePriority(vv, key[vv]));
                    key[vv] = weight;
                    pq.add(new NodePriority(vv, key[vv]));
                    parent[vv] = v;  //
                }
            }
        }
    }

}
