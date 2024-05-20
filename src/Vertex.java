public class Vertex {
private final String id;//id of vvertex
private final String name;//name of vertex

public Vertex(String id, String name){
    this.id = id;//assigning the id
    this.name = name;//assigning the name
}
public String getId(){
    return id;
}
public String getName(){
    return name;
}
public String toString(){
    return name;
}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;//checks if the objects are the same
        if (obj == null || getClass()!= obj.getClass()) return false;//checking if the obkect is null or of a different class
        Vertex vertex = (Vertex) obj;//cast the object to vertex
        return id.equals(vertex.id);//checks ifthe ids are equal
    }

    @Override
    public int hashCode() {
        return id.hashCode();//returns the hashcode of the id
    }
}
