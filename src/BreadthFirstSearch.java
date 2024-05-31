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
