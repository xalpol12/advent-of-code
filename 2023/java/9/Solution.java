import java.util.List;

class Solution {

    private static final String FILE_PATH = "inputs/input.txt";

    public static void main(String[] args) {
        List<String> lines = AOCUtilities.parse(FILE_PATH);

        System.out.println("=== Executing first part ===");
        AOCUtilities.timerStart();
        System.out.println(sumAllPredictionsForward(lines));
        AOCUtilities.timerStop();
    }

    private static int sumAllPredictionsForward(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            sum += predictNextInLine(line);
        }
        return sum;
    }

    private static int predictNextInLine(String line) {
        String[] split = line.split(" ");

        int[] startingValues = new int[split.length];
        for (int i = 0; i < startingValues.length; i++) {
            startingValues[i] = Integer.parseInt(split[i]);
        } 
        
        return predictForward(startingValues);
    }

    private static int predictForward(int[] values) {
        if (values[values.length - 1] == 0) {
            return 0;
        }

        int[] nextValues = new int[values.length - 1];

        for (int i = 0; i < nextValues.length; i++) {
            nextValues[i] = values[i + 1] - values[i];
        }


        int nextRowSum = predictForward(nextValues);
        return values[values.length - 1] + nextRowSum;
    }
}