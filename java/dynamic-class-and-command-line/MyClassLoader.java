import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MyClassLoader extends ClassLoader {
    
    private static final String BASE_PATH = "/home/rafael/java-handson/";

    public Class findClass(String name) {
        byte[] b = new byte[]{};
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    public byte[] loadClassData(String name) throws IOException{
        byte[] file = Files.readAllBytes(Paths.get(BASE_PATH + name + ".class"));
        System.out.println(new String(Arrays.copyOfRange(file, 0, 1024)));
        return file;
    }
}
