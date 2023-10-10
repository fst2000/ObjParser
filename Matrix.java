public class Matrix
{
    static float[][] mul(float[][] m1, float[][] m2)
    {
        float[][] mul = new float[m1.length][m2[0].length];
        if(m1[0].length == m2.length)
        {
            for(int i = 0; i < mul.length; i++)
            {
                for(int j = 0; j < mul[0].length; j++)
                {
                    int val = 0;
                    for(int k = 0; k < m1[0].length; k++)
                    {
                        val += m1[i][k] * m2[k][j];
                    }
                    mul[i][j] = val;
                }
            }
        }
        else System.out.println("Matrices are incompatible");
        return mul;
    }
}
