import java.util.*;

public class WeightedGraph {
    private final Map<Vertex, List<Edge>> adjVertices = new HashMap<>();

    public void addVertex(Vertex vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex src, Vertex dest, int weight) {
        adjVertices.get(src).add(new Edge(dest, weight));
        adjVertices.get(dest).add(new Edge(src, weight)); // For undirected graph
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(adjVertices.keySet());
    }

    public List<Edge> getEdges(Vertex vertex) {
        return adjVertices.get(vertex);
    }