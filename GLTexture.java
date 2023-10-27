import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static org.lwjgl.opengl.GL11.*;

public class GLTexture
{
    static BufferedImage loadImage(String localPath)
    {
        BufferedImage image;
        try {
            image = ImageIO.read(Program.class.getResource(localPath));
        } catch (IOException e)
        {
            image = null;
            e.printStackTrace();
        }
        return image;
    }
    static int loadTexture(BufferedImage image)
    {
        int width = image.getWidth();
        int height = image.getHeight();

        int[] pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);
        ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * 3);
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
        int id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB8, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE, buffer);
        return id;
    }
}
