import java.util.*;

public class DijkstraSearch {
    private final Map<Vertex, Integer> distTo = new HashMap<>();//map to store distances to vertices
    private final Map<Vertex, Vertex> edgeTo = new HashMap<>();//map to store paths
    private  final PriorityQueue<Vertex> pq;//algorithm priority queue;

    public DijkstraSearch(Vertex source) {
        super(source);
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingInt(distTo::get));

        distTo.put(source, 0);
        pq.add(source);
    }
    public void search(WeightedGraph graph) {
        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            for (WeightedGraph.Edge edge : graph.getEdges(v)) {
                relax(edge, v);
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
}

