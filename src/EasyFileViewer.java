import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EasyFileViewer {
    //String filename;
    public static void fileView(String fileName) {
        File f;
        FileReader in = null;
        try {
            f = new File(fileName);
            in = new FileReader(f);
            char[] buffer = new char[4096];
            int len;
            while ((len = in.read(buffer))!=-1) {
                String s = new String(buffer,0,len);
                System.out.println(s);
            }
        }
        catch (IOException e) {e.getMessage();}
        finally {try {if (in!=null) in.close();}  catch (IOException e) {}}
    }

    public static void main(String[] args) {
        //fileView("from");
        //EasyTailViewer.fileView("from");
        Counters.count("from");
    }
}
