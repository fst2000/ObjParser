public class Matrix4
{
    private float[] m = new float[16];
    public Matrix4()
    {
        for(int i = 0; i < 4; i++)
        {
            m[i * 4 + i] = 1;
        }
    }
    void rotateY(float angle)
    {
        float sin = (float)Math.sin(angle * Math.PI / 180);
        float cos = (float)Math.cos(angle * Math.PI / 180);
        set(0, 0, cos);
        set(0, 2, sin);
        set(2, 0, -sin);
        set(2, 2, cos);

        for(int i = 0; i < 3; i++)
        {
            System.out.print(getColumn(i).length() + " ");
        }
        System.out.println();
    }
    private float get(int i, int j)
    {
        return m[i * 4 + j];
    }
    private Vector3 getColumn(int c)
    {
        return new Vector3(get(0, c), get(1, c), get(2, c));
    }
    private void set(int i, int j, float f)
    {
        m[i * 4 + j] = f;
    }
    Vector3 mul(Vector3 v)
    {
        float[] v4 = {v.x, v.y, v.z, 1};
        float[] result = new float[4];
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                result[i] += get(i,j) * v4[i];
            }
        }
        return new Vector3(result[0], result[1], result[2]);
    }
}
