import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class EdgesDrawer implements Drawer
{
    ArrayList<Face> faces;
    int sizeX;
    int sizeY;
    int centerX;
    int centerY;
    int drawSize;
    public EdgesDrawer(ArrayList<Face> faces, int sizeX, int sizeY)
    {
        this.faces = faces;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        centerX = sizeX / 2;
        centerY = sizeY / 4;
        drawSize = (sizeX + sizeY) / 4;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sizeX, sizeY);
        g.setColor(Color.YELLOW);
        for(int i = 0; i < faces.size(); i++)
        {
            ArrayList<Vertex> verts = faces.get(i).vertices();
            for(int j = 0; j < verts.size() - 1; j++)
            {
                drawLine(g, verts.get(j).position(), verts.get(j + 1).position());
            }
            drawLine(g, verts.get(verts.size() - 1).position(), verts.get(0).position());
        }
        System.out.println(faces.size());
    }
    private void drawLine(Graphics g, Vector3 start, Vector3 end)
    {
                g.drawLine(
                    centerX + (int)(start.x * drawSize),
                    sizeY - (centerY + (int)(start.z * drawSize)),
                    centerX + (int)(end.x * drawSize),
                    sizeY - (centerY + (int)(end.z * drawSize)));
    }
}
