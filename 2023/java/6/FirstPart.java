import java.util.List;

// search for index from 0 to Time
// acceleration = index
// currentDistance = acceleration * (Time - index) -> distance = index * Time - index * index
// index * (Time - index) > distance
// distance = index * (Time - index)

public class FirstPart {

    private static final String FILE_NAME = "inputs/input.txt";
    public static void main(String[] args) {
        List<String> lines = AOCUtilities.parse(FILE_NAME);

        String[] timeValues = lines.get(0).split(":")[1].trim().split("\\s+");
        String[] distanceValues = lines.get(1).split(":")[1].trim().split("\\s+");

        int sum = 1;

        for (int i = 0; i < timeValues.length; i++) {
            sum *= findAllPossible(Integer.valueOf(timeValues[i]), Integer.valueOf(distanceValues[i]));
        }
        System.out.println(sum);
    }

    public static int findAllPossible(int time, int distance) {
        int possibilities = 0;

        for (int i = 0; i < time; i++) {
            if (i * (time - i) > distance) {
                possibilities++;
            }
        }

        return possibilities;
    }
}