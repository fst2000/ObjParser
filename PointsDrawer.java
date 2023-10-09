import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;

public class PointsDrawer implements Drawer
{
    Collection<Vector> points;
    Int sizeX;
    Int sizeY;
    public PointsDrawer(Collection<Vector> points, Int sizeX, Int sizeY)
    {
        this.points = points;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
    public void draw(Graphics g)
    {
        sizeX.accept(sX -> sizeY.accept(sY -> 
        {
            int centerX = sX / 2;
            int centerY = sY / 2;
            int size = (sX + sY) / 16;
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, sX, sY);
            g.setColor(Color.RED);
            for (Vector v : points)
            {
                v.accept((x, y, z) ->
                {
                    g.fillOval(centerX + (int)(x * size), sY - (centerY + (int)(z * size)), 2, 2);
                });
            }   
        }));
    }    
}
