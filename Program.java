import java.io.File;

public class Program
{
    public static void main(String[] args)
    {
        int sizeX = 500;
        int sizeY = 500;
        ObjParser parser = new ObjParser(new File("Knight.obj"));
		new GLWindow(sizeX, sizeY, new GLMeshDrawer(parser.faces(), sizeX, sizeY)).run();
    }
}