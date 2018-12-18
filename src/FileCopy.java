import java.io.*;

public class FileCopy {
    public static void main (String[] args) {
        if (args.length!=2) {System.err.println("Формат java FileCopy откуда куда"); System.exit(0);}
        else {try {copy(args[0], args[1]);}
        catch (IOException e) {System.err.println(e.getMessage());}
    }}

    public static void copy(String from_name, String to_name) throws IOException{
        File from = new File(from_name);
        File to = new File(to_name);
        if (!from.exists()) abort("File from doesn't exisis");
        if (from.isDirectory()) abort("Impossible to copy catalog");
        if (!from.canRead()) abort("Can't read file From");
        if (to.isDirectory()) {
            to = new File(to_name, from.getName());
        }
        if (to.exists()) {
            if (!to.canWrite()) abort("Can't write to file to");
            System.out.print("Rewrite existing file to? Y/N ");
            //System.out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String response = in.readLine();
            if (!response.equals("Y") && !response.equals("y"))
                abort("file has not been rewrite");
            else {
                String parent = to.getParent();
                if (parent == null) {
                    parent = System.getProperty("user.dir");
                }
                File dir = new File(parent);
                if (!dir.exists()) abort("Catalog doesn't exist");
                if (dir.isFile()) abort("Catalog to is not catalog");
                if (!dir.canWrite()) abort("Can't write to catalog");
            }
            FileInputStream inp_str = null;
            FileOutputStream out_str = null;
            try {
                inp_str = new FileInputStream(from);
                out_str = new FileOutputStream(to);
                byte[] buffer = new byte[4096];
                int bytes_read;
                while ((bytes_read = inp_str.read(buffer)) != -1) {
                    out_str.write(buffer, 0, bytes_read);
                }
            } finally {
                if (inp_str != null) try {
                    inp_str.close();
                } catch (IOException e) {
                }
                if (out_str != null) try {
                    out_str.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private static void  abort (String msg) throws IOException{
        throw new IOException("FileCopy: "+msg);
        }

        }

