import java.util.ArrayList;
import java.util.List;

// 1. Parse
// 2. Filter all digits
// 3. For each line get only first and last digit
// 4. Sum entries

public class FirstPart {
    public static void main(String[] args) {
        String filePath = "input.txt";
        List<String> lines = AOCUtilities.parse(filePath);

        List<String> digits = filterDigits(lines);
        List<String> firstAndLastDigits = filterFirstAndLast(digits);
        
        int sum = sumAllLines(firstAndLastDigits);
        AOCUtilities.print(sum);
    }

    public static List<String> filterDigits(List<String> lines) {
        List<String> digitLines = new ArrayList<>();
        for (String line : lines) {
            digitLines.add(line.replaceAll("[^0-9]", ""));
        }
        return digitLines;
    }

    public static List<String> filterFirstAndLast(List<String> digitLines) {
        List<String> filtered = new ArrayList<>();
        for (String line : digitLines) {
            int length = line.length();
            if (length == 1) { 
                filtered.add(line + line);
            } else if (length > 1) {
                Character first = line.charAt(0), last = line.charAt(length - 1);
                filtered.add(Character.toString(first) + Character.toString(last));
            }
        }
        return filtered;
    }

    public static int sumAllLines(List<String> digitLines) {
        int sum = 0;

        for (String string : digitLines) {
            sum += Integer.parseInt(string);
        }

        return sum;
    }
}