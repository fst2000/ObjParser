public class Vertex
{
    Vector3 position;
    Vector2 uv;
    Vector3 normal;
    public Vertex(Vector3 position, Vector2 uv, Vector3 normal)
    {
        this.position = position;
        this.uv = uv;
        this.normal = normal;
    }
    Vector3 position()
    {
        return position;
    }
    Vector2 uv()
    {
        return uv;
    }
    Vector3 normal()
    {
        return normal;
    }
}
