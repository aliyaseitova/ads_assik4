import java.util.*;

public class BreadthFirstSearch {
    private Set<Vertex> visited = new HashSet<>();
    private Map<Vertex, Vertex> edgeTo = new HashMap<>();

    public void bfs(WeightedGraph graph, Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (WeightedGraph.Edge edge : graph.getEdges(v)) {
                Vertex w = edge.getDestination();
                if (!visited.contains(w)) {
                    visited.add(w);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
    public boolean hasPathTo(Vertex v) {
        return visited.contains(v);
    }

    public List<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;
        List<Vertex> path = new ArrayList<>();
        for (Vertex x = v; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        Collections.reverse(path);
        return path;
    }
}