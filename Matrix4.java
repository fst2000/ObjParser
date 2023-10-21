public class Matrix4
{
    float[][] m = new float[4][4];
    public Matrix4()
    {
        for(int i = 0; i < 4; i++)
        {
            m[i][i] = 1;
        }
    }
}
