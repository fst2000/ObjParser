import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Program
{
    public static void main(String[] args)
    {
        int sizeX = 500;
        int sizeY = 500;
        ArrayList<Face> mesh = ObjParser.faces(new File("Knight.obj"));
        Drawer drawer = new GLMeshDrawer(mesh, new GLTexture("Knight.png"), new Matrix4(), sizeX, sizeY);
        GLWindow window  = new GLWindow(sizeX, sizeY, drawer);
        window.run();
    }
}