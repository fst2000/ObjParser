import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import static org.lwjgl.opengl.GL11.*;

public class GLMeshDrawer implements Drawer
{
    ArrayList<Face> faces;
    int sizeX;
    int sizeY;
    Matrix4 transform;
    float angle;
    public GLMeshDrawer(ArrayList<Face> faces, String texture, int sizeX, int sizeY, Matrix4 transform)
    {
        this.faces = faces;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.transform = transform;
    }
    @Override
    public void draw()
    {
        glCullFace(GL_NONE);
        glDepthFunc(GL_LESS);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);

        glViewport(0, 0, sizeX, sizeY);
        
        glBegin(GL_TRIANGLES);

        transform.rotateY(angle);
        angle += 0.5f;

        for (Face face : faces)
        {
            Vector3 p1 = face.vertices().get(0).position();
            Vector3 p2 = face.vertices().get(1).position();
            Vector3 p3 = face.vertices().get(2).position();
            Vector3 normal = Vector3.normalize(
                    Vector3.cross(
                        Vector3.sum(Vector3.inverse(p1), p2),
                        Vector3.sum(Vector3.inverse(p1), p3)));

            for (var vert : face.vertices)
            {
                Vector3 rNormal = transform.mul(normal);
                float faceBrightness = Vector3.dot(rNormal, new Vector3(0, 0, -1));
                glColor3f(faceBrightness, faceBrightness, faceBrightness);
                Vector3 pos = vert.position();
                pos = transform.mul(pos);
                Vector2 uv = vert.uv();

                glTexCoord2f(uv.x, uv.y);
                glVertex3f(pos.x, pos.y, pos.z);
            }
        }
        glEnd();
    }
}
