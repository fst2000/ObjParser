import java.io.File;

public class Program
{
    public static void main(String[] args)
    {
        int sizeX = 500;
        int sizeY = 500;
        GameFrame frame = new GameFrame(sizeX, sizeY);
        ObjParser parser = new ObjParser(new File("Human.obj"));
        DrawPanel panel = new DrawPanel(sizeX, sizeY, new EdgesDrawer(parser.faces(), sizeX, sizeY));
        frame.add(panel);
        frame.setVisible(true);
    }
}