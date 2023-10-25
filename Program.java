import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Program
{
    public static void main(String[] args)
    {
        int sizeX = 500;
        int sizeY = 500;
        ObjParser parser = new ObjParser(new File("Soldier.obj"));
        ArrayList<Face> mesh = parser.faces();
        Drawer drawer = new GLMeshDrawer(mesh, "Knight.png", sizeX, sizeY, new Matrix4());
        GLWindow window  = new GLWindow(sizeX, sizeY, drawer);
        window.run();
    }
}