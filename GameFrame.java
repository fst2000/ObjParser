import javax.swing.JFrame;

public class GameFrame extends JFrame
{
    public GameFrame(int sizeX, int sizeY)
    {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(sizeX, sizeY);
        setResizable(false);
    }
}
