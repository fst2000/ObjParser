import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.*;

public class GLMeshDrawer implements Drawer
{
    ArrayList<Face> faces;
    int sizeX;
    int sizeY;
    public GLMeshDrawer(ArrayList<Face> faces, int sizeX, int sizeY)
    {
        this.faces = faces;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    @Override
    public void draw()
    {
        glCullFace(GL_NONE);
        glDepthFunc(GL_LESS);
        glEnable(GL_DEPTH_TEST);
        glViewport(0, 0, sizeX, sizeY);
        glColor3f(0.5f, 1f, 0.5f);
        for (Face face : faces)
        {
            glBegin(GL_POLYGON);
            for (var vert : face.vertices)
            {
                Vector3 pos = vert.position();
                glVertex3f(pos.x, pos.y, pos.z);
            }
            glEnd();
        }
    }
}
