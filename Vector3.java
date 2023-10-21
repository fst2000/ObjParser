public class Vector3
{
    float x;
    float y;
    float z;
    public Vector3(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    static float dot(Vector3 a, Vector3 b)
    {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }
    static Vector3 cross(Vector3 a, Vector3 b)
    {
        return new Vector3(
            a.y * b.z - a.z * b.y,
            a.z * b.x - a.x * b.z,
            a.x * b.y - a.y * b.x);
    }
    static Vector3 sum(Vector3 a, Vector3 b)
    {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }
    static Vector3 inverse(Vector3 v)
    {
        return new Vector3(-v.x, -v.y, -v.z);
    }
    static Vector3 normalize(Vector3 v)
    {
        return Vector3.scale(v, 1 / v.length());
    }
    float length()
    {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }
    static Vector3 scale(Vector3 v, float value)
    {
        return new Vector3(v.x * value, v.y * value, v.z * value);
    }
}
