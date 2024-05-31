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

