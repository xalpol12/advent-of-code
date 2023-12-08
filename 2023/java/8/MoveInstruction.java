public class MoveInstruction {
    private String moveInstruction;
    private int pointer;

    public MoveInstruction(String instruction) {
        moveInstruction = instruction;
        pointer = 0;
    }

    public char getCurrentDirection() {
        char currentDirection = moveInstruction.charAt(pointer);

        if (pointer == moveInstruction.length() - 1) {
            pointer = 0;
        } else {
            pointer++;
        }

        return currentDirection;
    }
}
