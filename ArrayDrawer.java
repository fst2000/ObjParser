public class ArrayDrawer implements Drawer
{
    Drawer[] drawers;

    public ArrayDrawer(Drawer... drawers)
    {
        this.drawers = drawers;
    }

    @Override
    public void draw()
    {
        for (Drawer drawer : drawers)
        {
            drawer.draw();    
        }
    }    
}
