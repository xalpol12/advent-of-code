import java.util.HashSet;
import java.util.List;

public class FirstPart {

    private static final String FILE_PATH = "inputs/input.txt";
    
    public static void main(String[] args) {
        List<String> lines = AOCUtilities.parse(FILE_PATH);
        int sum = getSumOfWinningPoints(lines);
        AOCUtilities.print(sum);
    }

    private static int getSumOfWinningPoints(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            sum += sumInOneCard(line);
        }
        return sum;
    }

    private static int sumInOneCard(String card) {
        String numbers = card.split(": ")[1];
        String[] splitNumbers = numbers.split("\\|");
        
        // split each number, 1 or 2 spaces delim
        String[] winning = splitNumbers[0].trim().split("\\s+"); 
        String[] chosen = splitNumbers[1].trim().split("\\s+");

        HashSet<Integer> chosenNumbers = new HashSet<>();
        for (String s : chosen) {
            chosenNumbers.add(Integer.parseInt(s));
        }

        int matches = 0;
        for (String win : winning) {
            if (chosenNumbers.contains(Integer.parseInt(win))) {
                matches++;
            }
        }

        return (int) Math.pow(2, matches - 1);
    }
    
}
