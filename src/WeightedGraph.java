import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
    private final Map<Vertex, List<Edge>> adjVertices = new HashMap<>();//adjacency list to store vertices and their edges
    public void addVertex(Vertex vertex) {
        adjVertices.putIfAbsent(vertex, new ArrayList<>());//adding a vertex if it doesnt exist
    }

    public void addEdge(Vertex src, Vertex dest, int weight) {
        adjVertices.get(src).add(new Edge(dest, weight));//adding edge from src to dest
        adjVertices.get(dest).add(new Edge(src, weight));//adding edge from dest ro src in undirected graph
    }
    public List<Vertex> getVertices(){
        return new ArrayList<>(adjVertices.keySet());//returing a list of all vertices
    }
    public List<Edge> getEdges(Vertex vertex){
        return adjVertices.get(vertex);//returns theedges of a given vertex
    }
    public static class Edge{
        private final Vertex destination; //dest vertex of an edge
        private final int weight;//weight of the edge
        public Edge(Vertex destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
        public Vertex getDestination(){
            return destination;
        }

        public int getWeight() {
            return weight;
        }
    }
}
