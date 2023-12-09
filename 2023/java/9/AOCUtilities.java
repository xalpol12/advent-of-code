import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AOCUtilities {
    private static long timerStart = 0;

    public static List<String> parse(String filePath) {
        List<String> content = new ArrayList<>();
        Path file = Paths.get(filePath);
        try {
            content = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String readAsString(String filePath) {
        String content = "";
        Path file = Paths.get(filePath);
        try {
            content = new String(Files.readAllBytes(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
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

    public static void timerStart() {
        timerStart = System.nanoTime();
    }

    public static void timerStop() {
        long timeStop = System.nanoTime(); 
        long elapsedTime = timeStop - timerStart;
        System.out.println("Execution time: " + (double) elapsedTime / 1_000_000 + " ms");
    }
}
