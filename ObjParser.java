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
    public ArrayList<Vector> points()
    {
        ArrayList<Vector> points = new ArrayList<>();
        while(s.hasNextLine())
        {
            String line = s.nextLine();
            if(line.startsWith("v "))
            {
                String[] lines = line.replace("v ", "").split(" ");
                points.add(new SimpleVector(
                    Float.parseFloat(lines[0]),
                    Float.parseFloat(lines[1]),
                    Float.parseFloat(lines[2])));
            }

        }
        return points;
    }
}
