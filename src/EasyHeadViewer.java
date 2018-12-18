import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class EasyHeadViewer extends EasyFileViewer {
    public static void fileView(String filename) {
        File f;
        LineNumberReader in = null;
        int len;
        try {
            f = new File(filename);
            in = new LineNumberReader(new FileReader(f));
            //String s = in.readLine();
            for (int i=0; i<3; i++) {
            in.setLineNumber(i);
            String s = in.readLine();
            System.out.println(s+" "+in.getLineNumber());}
        }
        catch (IOException e) {e.getMessage();}
        finally {try {if (in!=null) in.close();}  catch (IOException e) {}}
    }
}
