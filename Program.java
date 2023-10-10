import java.io.File;

public class Program
{
    public static void main(String[] args)
    {
        int sizeX = 500;
        int sizeY = 500;
        GameFrame frame = new GameFrame(sizeX, sizeY);
        ObjParser parser = new ObjParser(new File("Heart.obj"));
        DrawPanel panel = new DrawPanel(sizeX, sizeY, new EdgesDrawer(parser.faces(), sizeX, sizeY));
        frame.add(panel);
        frame.setVisible(true);

        float[][] m1 = {{1, 2}, {2, 3}, {4, 5}};
        float[][] m2 = {{1, 2, 3}, {4, 5, 6}};
        float[][] m3 = Matrix.mul(m1, m2);
        System.out.println("Matrix 1 size " + m1[0].length + " " + m1.length);
        System.out.println("Matrix 2 size " + m2[0].length + " " + m2.length);
        for(int i = 0; i < m3[0].length; i++)
        {
            for(int j = 0; j < m3[1].length; j++)
            {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}