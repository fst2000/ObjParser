import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static org.lwjgl.opengl.GL11.*;

public class GLTexture
{
    private ByteBuffer buffer;
    private int id;
    public GLTexture(File imageFile)
    {
        id = glGenTextures();
        BufferedImage image;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e)
        {
            image = null;
            e.printStackTrace();
        }
        int width = image.getWidth();
        int height = image.getHeight();

        int[] pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);
        buffer = BufferUtils.createByteBuffer(width * height * 3);
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                int index = y * width + x;
                int p = pixels[index];
                byte r = (byte)((p >> 16) & 0xFF);
                byte g = (byte)((p >> 8) & 0xFF);
                byte b = (byte)(p & 0xFF);
                buffer.put(index, r);
                buffer.put(index, g);
                buffer.put(index, b);
            }
        }
        buffer.flip();
    }
    int GetId()
    {
        return id;
    }
    ByteBuffer GetBuffer()
    {
        return buffer;
    }
}
