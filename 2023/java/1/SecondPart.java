import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondPart {
    public static void main(String[] args) {
        String filePath = "input.txt";
        List<String> lines = AOCUtilities.parse(filePath);

        List<String> parsedDigits = parseDigitsWrittenInLetters(lines);
        List<String> onlyDigits = FirstPart.filterDigits(lines);
        List<String> firstAndLastDigits = FirstPart.filterFirstAndLast(onlyDigits);

        int sum = FirstPart.sumAllLines(firstAndLastDigits);
        AOCUtilities.print(sum);
    }

    private static List<String> parseDigitsWrittenInLetters(List<String> lines) {
        List<String> parsedDigits = new ArrayList<>();
        Map<String, Integer> wordDigitAssociation = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            wordDigitAssociation.put(Digit.values()[i].toString().toLowerCase(), i + 1);
        }

        for (String line : lines) {
            StringBuilder sb = new StringBuilder();
            for (char c : line.toCharArray()) {
                 if (Character.isDigit(c)) {
                    sb.append(c);
                 } else {
                    if (wordDigitAssociation.keySet)
                 }
            }
        }

        return parsedDigits;

    }

    private static List<String> getAllAvailableKeys()
}
