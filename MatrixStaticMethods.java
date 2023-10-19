public class MatrixStaticMethods
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
    static Vector3 mul(float[][] m, Vector3 v)
    {
        Vector3 mul = new Vector3(0,0,0);
        if(m[0].length == 3 && m.length == 3)
        {
            mul.x = m[0][0] * v.x + m[0][1] * v.y + m[0][2] * v.z;
            mul.y = m[1][0] * v.x + m[1][1] * v.y + m[1][2] * v.z;
            mul.z = m[2][0] * v.x + m[2][1] * v.y + m[2][2] * v.z;
        }
        else System.out.println("Matrix is incompatible for Vector3");
        return mul;
    }
    static Vector3 rotZ(Vector3 v, float angle)
    {
        float sin = (float)Math.sin(angle * (Math.PI / 180));
        float cos = (float)Math.cos(angle * (Math.PI / 180));
        float[][] rotM = 
        {
            {cos, -sin, 0},
            {sin, cos, 0},
            {0, 0, 1}
        };
        return mul(rotM, v);
    }
}
