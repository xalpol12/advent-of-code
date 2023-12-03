import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstPart {

    private static final String FILENAME = "inputs/input.txt";
    private static final Pattern ballsPattern = Pattern.compile("(?:(?:[0-9]+)\\s(?:red|green|blue))");
    private static final int RED_LIMIT = 12;
    private static final int GREEN_LIMIT = 13;
    private static final int BLUE_LIMIT = 14;

    public static void main(String[] args) {       
        List<String> lines = AOCUtilities.parse(FILENAME);
        int idSum = getIdSumOfAllValidGames(lines);
        AOCUtilities.print(idSum);
    }
    
    public static int getIdSumOfAllValidGames(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            String[] splitLine = line.split(":");
            String head = splitLine[0];
            String tail = splitLine[1];
            int gameNumber = Integer.parseInt(head.split(" ")[1]);
            if (isValidGame(tail)) {
                sum += gameNumber;
            }   
        }
        return sum;
    }

    public static boolean isValidGame(String tail) {
        String[] draws = tail.split(";");
        for (String draw : draws) {
            if (!isValidDraw(draw)) return false;
        }
        return true;
    }

    private static boolean isValidDraw(String draw) {
        Matcher matcher = ballsPattern.matcher(draw);
        while (matcher.find()) {
            String match = matcher.group();
            String[] split = match.split(" ");
            String color = split[1];
            int amount = Integer.parseInt(split[0]);
            if (!isWithinLimit(amount, color)) return false;
        }
        return true;
    }

    private static boolean isWithinLimit(int value, String color) {
        switch (color) {
            case "red": return value <= RED_LIMIT;
            case "green": return value <= GREEN_LIMIT;
            case "blue": return value <= BLUE_LIMIT;
            default: return false;
        }
    }
}