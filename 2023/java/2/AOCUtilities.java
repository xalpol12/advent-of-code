import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AOCUtilities {

    public static List<String> parse(String filePath) {
        List<String> list = new ArrayList<>();
        Path file = Paths.get(filePath);
        try {
            list = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> void print(T object) {
        System.out.println(object.toString());
    }

    public static <T> void printAll(List<T> objects) {
        for (Object object : objects) {
            System.out.println(object.toString());   
        }
    }
}
