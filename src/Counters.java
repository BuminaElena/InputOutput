import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Counters {

    public static void count(String filename) {
        File f;
        LineNumberReader in;
        int count_line = 0;
        int count_char = 0;
        int count_words = 0;
        try {
            f = new File(filename);
            in = new LineNumberReader(new FileReader(f));
            String s= "";
            while ((s=in.readLine())!=null) {
                count_line++;
                for (int i=0; i<s.length(); i++) {
                    if (Character.isWhitespace(s.charAt(i))) count_words++;
                    count_char++;
                }
                count_words++;
            }
            System.out.println("Всего строк " + count_line);
            System.out.println("Всего слов " + count_words);
            System.out.println("Всего символов " + count_char);
        }
        catch (IOException e) {e.getMessage();}
        finally {}
    }

}
