public class Main3 {
    public static void main(String[] args) {
        ISimpleGraph sg = new SimpleGraphMatrix(9);
        sg.addUndirectedEdge(0, 1);
        sg.addUndirectedEdge(0, 2);
        sg.addUndirectedEdge(0, 3);
        sg.addUndirectedEdge(1, 2);
        sg.addUndirectedEdge(3, 2);
        sg.addUndirectedEdge(1, 4);
        sg.addUndirectedEdge(2, 5);
        sg.addUndirectedEdge(3, 6);
        sg.addUndirectedEdge(3, 7);
        sg.addUndirectedEdge(6, 7);
        sg.addUndirectedEdge(3, 8);

        BreadthFirstSearch bfs = new BreadthFirstSearch(sg, 0);

        DepthFirstSearch dfs = new DepthFirstSearch(sg, 0);
    }
}
