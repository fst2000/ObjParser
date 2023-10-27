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
        Matrix4 transform = new Matrix4();
        GLWindow window  = new GLWindow(sizeX, sizeY);
        window.run(() ->
        {
            int id = GLTexture.loadTexture(GLTexture.loadImage("Knight.png"));
            return () ->
            {
                GLMesh.drawMesh(mesh, id, transform, sizeX, sizeY);
            };
        });
    }
}