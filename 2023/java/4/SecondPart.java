import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SecondPart {

    private static final String FILE_PATH = "inputs/input.txt";

    public static void main(String[] args) {
        List<String> lines = AOCUtilities.parse(FILE_PATH);
        Map<Integer, Integer> cardsMatchesCache = calculateAllMatches(lines);
        int cardsSum = calculateAllCopies(cardsMatchesCache);
        AOCUtilities.print(cardsSum);
    }

    private static Map<Integer, Integer> calculateAllMatches(List<String> lines) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            cache.put(i, matchesInOneCard(lines.get(i)));
        }

        return cache;
    }

    private static int matchesInOneCard(String card) {
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

        return matches;
    }

    private static int calculateAllCopies(Map<Integer, Integer> cache) {
        int sum = 0;
        int cacheSize = cache.entrySet().size();

        int[] cardsCount = new int[cacheSize];

        for (int i = 0; i < cacheSize; i++) {
            int cardCount = cardsCount[i] + 1; // copies + original
            sum += cardCount;
            int matchesCount = cache.get(i);
            while (matchesCount != 0) {
                cardsCount[i + matchesCount] += cardCount;
                matchesCount--;
            }
        }

        return sum;
    }
}
