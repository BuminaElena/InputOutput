import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class EasyTailViewer extends EasyFileViewer {
    public static void fileView (String filename) {
        File f;
        LineNumberReader in = null;
        int len;
        try {
            f = new File(filename);
            in = new LineNumberReader(new FileReader(f));
            String s = "";
            int count = 0;
            List<String> str = new ArrayList<>();
            while ((s=in.readLine())!=null) {
                //s=in.readLine();
                str.add(s);
                //System.out.println(str.get(count));
                count ++;
            }
            for (int i=str.size()-3; i<str.size(); i++) {
                System.out.println(str.get(i));
            }}
        catch (IOException e) {e.getMessage();}
        finally {try {if (in!=null) in.close();}  catch (IOException e) {}}
    }
}

