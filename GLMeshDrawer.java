import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.*;

public class GLMeshDrawer implements Drawer
{
    ArrayList<Face> faces;
    int sizeX;
    int sizeY;
    Matrix4 rotYMatrix = new Matrix4();
    float angle;
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
        
        glBegin(GL_TRIANGLES);
        for (Face face : faces)
        {
            Vector3 p1 = face.vertices().get(0).position();
            Vector3 p2 = face.vertices().get(1).position();
            Vector3 p3 = face.vertices().get(2).position();

            float color = Vector3.dot(
                new Vector3(0, 0, -1),
                Vector3.normalize(
                    Vector3.cross(
                        Vector3.sum(Vector3.inverse(p1), p2),
                        Vector3.sum(Vector3.inverse(p1), p3))));

            glColor3f(color, color, color);

            for (var vert : face.vertices)
            {
                rotYMatrix.rotateY(angle);
                angle += 0.001f;
                Vector3 pos = vert.position();
                Vector3 rPos = rotYMatrix.mul(pos);
                glVertex3f(rPos.x, rPos.y, rPos.z);
            }
        }
        glEnd();
    }
}
