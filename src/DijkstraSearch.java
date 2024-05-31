import java.util.*;

public class DijkstraSearch {
    private final Map<Vertex, Integer> distTo = new HashMap<>();//map to store distances to vertices
    private final Map<Vertex, Vertex> edgeTo = new HashMap<>();//map to store paths
    private  final PriorityQueue<Vertex> pq;//algorithm priority queue;

    public DijkstraSearch(WeightedGraph graph, Vertex source){
        pq = new PriorityQueue<>(Comparator.comparingInt(distTo::get));//initialize priority queue with comparator
        for (Vertex v : graph.getVertices()) {
            distTo.put(v, Integer.MAX_VALUE);//initializing all distances to infinity
        }
        distTo.put(source, 0);
        pq.add(source);//adding source to the priority queue(pq)
        while (!pq.isEmpty()){
            Vertex v = pq.poll();//removing vertex with the smallest dist
            for (WeightedGraph.Edge edge : graph.getEdges(v)){
                relax(edge, v);//relax edges from the vertex
            }
        }
    }

    private void relax(WeightedGraph.Edge edge, Vertex v){
        Vertex w = edge.getDestination();//gets the dest vertex of the edge
        int weight = edge.getWeight();//gets the weight of edge
        if (distTo.get(w)>distTo.get(v)+weight){
            distTo.put(w, distTo.get(v)+weight);
            edgeTo.put(w, v);
            /*if the program finds the shorter path, it updates distance to the vertex and recordds the path*/
            if (pq.contains(w)){
                pq.remove(w);
                /*removing vertex fom the pq if it exists*/
            }
            pq.add(w);//adding the vertex to the pq with a new distance
        }
    }
    public int distTo(Vertex v){
        return distTo.get(v);
    }
    public boolean hasPathTo(Vertex v){
        return distTo.get(v) < Integer.MAX_VALUE;//checks if there is path to a vertex
    }
    public List<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;//returns null, if there is no path
        List<Vertex> path = new ArrayList<>();
        for (Vertex x = v; x != null; x = edgeTo.get(x)){
            path.add(x);
            /*constructs the path from end to start and adds  vertex to the path*/
        }
        Collections.reverse(path);//reversing the path
        return path;
    }
}

