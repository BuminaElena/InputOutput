import java.io.*;

public class Head extends FileViewer{

    public Head(String filename) {super(filename);}
    public Head (String directory, String filename) {super(directory,filename);}
    public void setFile(String directory, String filename) {
        if ((filename==null)||(filename.length()==0))  return;
        File f;
        LineNumberReader in = null;
        try {
            f = new File(directory, filename);
            in = new LineNumberReader(new FileReader(f));
            textarea.setText("");
            String s = "";
            for (int i=0; (i<3)&&(s!=null); i++) {
                in.setLineNumber(i);
                s = in.readLine();
                textarea.append(s+'\n');
            }
            this.setTitle("FileViewer: "+filename);
            textarea.setCaretPosition(0);
        }
        catch (IOException e) {
            textarea.setText(e.getClass().getName()+": "+e.getMessage());
            this.setTitle("FileViewer: "+filename+"IOException");
        }
        finally {try {if (in!=null) in.close();}  catch (IOException e) {}}
    }
}