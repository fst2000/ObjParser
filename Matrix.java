public class Matrix
{
    float[] m;
    public Matrix(float[] m)
    {
        this.m = m;
    }
    float element(int i, int j)
    {
        return m[4 * i + j];
    }
}
