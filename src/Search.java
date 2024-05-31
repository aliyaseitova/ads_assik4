public class Search {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;
}
public Search(Vertex source) {
    this.source = source;
    this.marked = new HashSet<>();
    this.edgeTo = new HashMap<>();
}
public boolean hasPathTo(Vertex v) {
    return marked.contains(v);
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

public abstract void search(WeightedGraph graph);
}