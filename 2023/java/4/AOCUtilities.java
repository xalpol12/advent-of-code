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

    public static char[][] turnTo2DMatrix(List<String> lines) {
        int rowLength = lines.get(0).length();
        int columnLength = lines.size();
        char[][] charMatrix = new char[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            String row = lines.get(i);
            char[] rowEntries = row.toCharArray();
            for (int j = 0; j < columnLength; j++) {
                charMatrix[i][j] = rowEntries[j];
            }
        }
        return charMatrix;
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
