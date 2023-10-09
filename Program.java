import java.io.File;

public class Program
{
    public static void main(String[] args)
    {
        int sizeX = 500;
        int sizeY = 500;
        GameFrame frame = new GameFrame(sizeX, sizeY);
        ObjParser parser = new ObjParser(new File("Knight.obj"));
        DrawPanel panel = new DrawPanel(sizeX, sizeY, new PointsDrawer(parser.points(), c -> c.consume(sizeY), c -> c.consume(sizeY)));
        for(var v : parser.points())
        {
            v.accept((x, y, z) -> System.out.println(x + " " + " " + y + " " + z));
        }
        frame.add(panel);
        frame.setVisible(true);
    }
}