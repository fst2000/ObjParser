import java.util.ArrayList;

import org.lwjgl.opengl.GL13;

import static org.lwjgl.opengl.GL11.*;

public class GLMesh
{

    public static void drawMesh(ArrayList<Face> faces, int textureId, Matrix4 transform, int sizeX, int sizeY)
    {
        glCullFace(GL_NONE);
        glDepthFunc(GL_LESS);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_TEXTURE_2D);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, textureId);
        glViewport(0, 0, sizeX, sizeY);
        glBegin(GL_TRIANGLES);
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
