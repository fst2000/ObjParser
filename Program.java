import java.io.File;

public class Program
{
    public static void main(String[] args)
    {
        int sizeX = 500;
        int sizeY = 500;
        GameFrame frame = new GameFrame(sizeX, sizeY);
        ObjParser parser = new ObjParser(new File("Human.obj"));
		new GLWindow(sizeX, sizeY, new GLMeshDrawer(parser.faces(), sizeX, sizeY)).run();
    }
}