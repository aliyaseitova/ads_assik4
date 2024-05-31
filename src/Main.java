public class Main {
    public static void main(String[] args) {
        Vertex a = new Vertex("1", "Aliya");
        Vertex b = new Vertex("2", "Besh");
        Vertex c = new Vertex("3", "Astana");


        WeightedGraph graph = new WeightedGraph();
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);

        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 2);
        graph.addEdge(b, c, 5);

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.bfs(graph, a);
        System.out.println("BFS path from A to C: " + bfs.pathTo(c));

        DijkstraSearch dijkstra = new DijkstraSearch(graph, a);
        System.out.println("Dijkstra path from A to C: " + dijkstra.pathTo(c));
        System.out.println("Dijkstra distance from A to C: " + dijkstra.distTo(c));
    }
}
