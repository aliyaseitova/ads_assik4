public class BreadthFirstSearch extends Search {

    public BreadthFirstSearch(Vertex source) {
        super(source);
    }
    public void search(WeightedGraph graph) {
        Queue<Vertex> queue = new LinkedList<>();
        marked.add(source);
        queue.add(source);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (WeightedGraph.Edge edge : graph.getEdges(v)) {
                Vertex w = edge.getDestination();
                if (!marked.contains(w)) {
                    marked.add(w);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}