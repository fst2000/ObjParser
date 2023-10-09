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
            
        }
    }    
}
