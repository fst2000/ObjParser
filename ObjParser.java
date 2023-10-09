import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ObjParser
{
    File file;
    Scanner s;
    public ObjParser(File file) {
        this.file = file;
        try
        {
            s = new Scanner(file);
            s.useLocale(Locale.US);
        }
        catch(Throwable e) {System.out.println(e);}
    }
    public ArrayList<Face> faces()
    {
        ArrayList<Vector3> points = new ArrayList<>();
        ArrayList<Vector2> uv = new ArrayList<>();
        ArrayList<Vector3> normals = new ArrayList<>();
        ArrayList<Face> faces = new ArrayList<>();
        while(s.hasNextLine())
        {
            String line = s.nextLine();
            if(line.startsWith("v "))
            {
                String[] lines = line.replace("v ", "").split(" ");
                points.add(new Vector3(
                    Float.parseFloat(lines[0]),
                    Float.parseFloat(lines[1]),
                    Float.parseFloat(lines[2])));
            }
            if(line.startsWith("vt "))
            {
                String[] lines = line.replace("vt ", "").split(" ");
                uv.add(new Vector2(
                    Float.parseFloat(lines[0]),
                    Float.parseFloat(lines[1])));
            }
            if(line.startsWith("vn "))
            {
                String[] lines = line.replace("vn ", "").split(" ");
                normals.add(new Vector3(
                    Float.parseFloat(lines[0]),
                    Float.parseFloat(lines[1]),
                    Float.parseFloat(lines[2]))
                );
            }
            if(line.startsWith("f "))
            {
                String[] verts = line.replace("f ", "").split(" ");
                ArrayList<Vertex> faceVertices = new ArrayList<>();
                for(int i = 0; i < verts.length; i++)
                {
                    String[] indexes = verts[i].split("/");
                    faceVertices.add(new Vertex(
                        points.get(Integer.parseInt(indexes[0]) - 1),
                        uv.get(Integer.parseInt(indexes[1]) - 1),
                        normals.get(Integer.parseInt(indexes[2]) - 1)));
                }
                faces.add(new Face(faceVertices));
            }
        }
        return faces;
    }
}
