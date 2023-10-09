import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
    Drawer drawer;
    public DrawPanel(int sizeX, int sizeY, Drawer drawer)
    {
        setSize(sizeX, sizeY);
        this.drawer = drawer;
    }
    @Override
    public void paint(Graphics g)
    {
        drawer.draw(g);
    }
}
