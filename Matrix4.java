public class Matrix4
{
    float[] m;
    public Matrix4(float[] m)
    {
        this.m = m;
    }
    float get(int i, int j)
    {
        return m[4 * i + j];
    }
    void set(int i, int j, float value)
    {
        m[4 * i + j] = value;
    }
}
