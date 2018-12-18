import java.io.File;

public class Delete {
    public static void main (String[] args) {
        if (args.length !=1 ) {System.err.println("Формат команды java Delete file_name"); System.exit(0);}
        try {delete(args[0]);}
        catch(IllegalArgumentException e) {System.err.println(e.getMessage());}
    }

    public static void delete(String filename) {
        File f = new File(filename);
        if (! f.exists()) {fail("Нет такого файла или каталога "+filename);}
        if (! f.canWrite()) {fail("Файл защищен от записи "+filename);}
        if (f.isDirectory()&&(f.list().length>0)) {fail("Каталог не пустой "+filename);}
        boolean success = f.delete();
        if (!success) fail("Удаление не удалось");
    }

    protected static void fail(String msg) throws IllegalArgumentException {
        throw new IllegalArgumentException(msg);
    }
}
