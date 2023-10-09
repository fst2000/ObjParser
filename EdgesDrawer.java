import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class EdgesDrawer implements Drawer
{
    ArrayList<Face> faces;
    int sizeX;
    int sizeY;
    public EdgesDrawer(ArrayList<Face> faces, int sizeX, int sizeY)
    {
        this.faces = faces;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    public void draw(Graphics g)
    {
        int centerX = sizeX / 2;
        int centerY = sizeY / 4;
        int size = (sizeX + sizeY) / 8;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sizeX, sizeY);
        g.setColor(Color.YELLOW);
        for(int i = 0; i < faces.size() - 1; i++)
        {
            ArrayList<Vertex> verts = faces.get(i).vertices();
            for(int j = 0; j < verts.size() - 1; j++)
            {
                Vector3 pos = verts.get(j).position();
                Vector3 nextPos = verts.get(j + 1).position();
                g.drawLine(
                    centerX + (int)(pos.x * size),
                    sizeY - (centerY + (int)(pos.z * size)),
                    centerX + (int)(nextPos.x * size),
                    sizeY - (centerY + (int)(nextPos.z * size)));
            }
        }
        System.out.println(faces.size());
    }    
}
