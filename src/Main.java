public class Main {
    public static void main(String[] args) {
        Vertex a = new Vertex("1", "Aliya");
        Vertex b = new Vertex("2", "Besh");
        Vertex c = new Vertex("3", "Astana");


        WeightedGraph graph = new WeightedGraph();
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);

    }
}
