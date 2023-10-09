import java.util.ArrayList;

public class Face
{
    ArrayList<Vertex> vertices;
    public Face(ArrayList<Vertex> vertices)
    {
        this.vertices = vertices;
    }
    ArrayList<Vertex> vertices()
    {
        return vertices;
    }
}
