import java.lang.reflect.InvocationTargetException;

import phone.Phone;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    private static final String BASE_PATH = "/home/rafael/java-handson/";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
            SecurityException, IllegalArgumentException, InvocationTargetException, IOException, ClassNotFoundException {
        Phone phone = new Phone();

        phone.calling("9948765478");
        File file = new File(BASE_PATH + "notes.jar");
        URLClassLoader classloa = null;
        try {
            classloa = URLClassLoader.newInstance(new URL[] { file.toURI().toURL() }, Class.class.getClassLoader());
            Class<?> clazz = classloa.loadClass("com.teste.Ipad");
            Object ipad = clazz.getDeclaredConstructor().newInstance();
            clazz.getMethod("hello").invoke(ipad);
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Defining manually class");

        MyClassLoader myClassLoader =  new MyClassLoader();
        Class<?> manuallyClass = myClassLoader.loadClass("ManuallyClass");
        System.out.println("Defined manually class");
        Object manual = manuallyClass.getDeclaredConstructor().newInstance();
        manuallyClass.getDeclaredMethod("print").invoke(manual);

    }
}