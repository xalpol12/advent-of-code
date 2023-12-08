import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FirstPart {
    private static final String FILE_PATH = "inputs/input.txt";
    public static void main(String[] args) {
        List<String> lines = AOCUtilities.parse(FILE_PATH);

        String movementInstruction = lines.get(0);
        MoveInstruction instruction = new MoveInstruction(movementInstruction);

        Map<String, Node> map = createMap(lines.subList(2, lines.size()));

        String destination = "ZZZ";
        System.out.println(countSteps(instruction, map, destination));
    }

    private static Map<String, Node> createMap(List<String> lines) {
        Map<String, Node> map = new HashMap<>();

        for (String line: lines) {
            String[] values = splitLine(line);
            Node node = new Node(values[1], values[2]);
            map.put(values[0], node);
        }

        return map;
    }

    private static String[] splitLine(String line) {
        String[] arr = new String[3];
        String[] splitString = line.split("=");
        String head = splitString[0].trim();
        String leftVal = splitString[1].split(",")[0].trim().substring(1, 4);
        String rightVal = splitString[1].split(",")[1].trim().substring(0, 3);
        arr[0] = head;
        arr[1] = leftVal;
        arr[2] = rightVal;
        return arr;
    }

    private static int countSteps(MoveInstruction intruction, Map<String, Node> map, String destination) {
        int counter = 0;
        String currentLocation = "AAA";

        while (!currentLocation.equals(destination)) {
            switch (intruction.getCurrentDirection()) {
                case 'L' -> currentLocation = map.get(currentLocation).leftVal;
                case 'R' -> currentLocation = map.get(currentLocation).rightVal;
            }
            counter++;
        }

        return counter;
    }
}