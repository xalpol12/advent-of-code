import java.util.List;

public class SecondPart {
    private static final String FILE_NAME = "inputs/input.txt";
    public static void main(String[] args) {
        List<String> lines = AOCUtilities.parse(FILE_NAME);

        String[] timeValues = lines.get(0).split(":")[1].trim().split("\\s+");
        String[] distanceValues = lines.get(1).split(":")[1].trim().split("\\s+");

        String totalTime = "";
        for (String timeVal : timeValues) {
            totalTime += timeVal;
        }

        String totalDistance = "";
        for (String distanceVal : distanceValues) {
            totalDistance += distanceVal;
        }


        System.out.println(findAllPossible(Long.parseLong(totalTime), Long.parseLong(totalDistance)));
    }

    public static int findAllPossible(long time, long distance) {
        int possibilities = 0;

        for (int i = 0; i < time; i++) {
            if (i * (time - i) > distance) {
                possibilities++;
            }
        }

        return possibilities;
    }
}
