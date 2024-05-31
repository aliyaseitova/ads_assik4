import java.util.*;

public class BreadthFirstSearch {
    private Set<Vertex> visited = new HashSet<>();
    private Map<Vertex, Vertex> edgeTo = new HashMap<>();

    public void bfs(WeightedGraph graph, Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);