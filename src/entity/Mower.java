package entity;

public class Mower {
	private int x;
    private int y;
    private char orientation;

    public Mower(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void executeInstructions(String instructions, Lawn lawn) {
    	instructions.chars()
        .mapToObj(instruction -> (char) instruction)
        .forEach(instruction -> {
            switch (instruction) {
                case 'G' -> rotateLeft();
                case 'D' -> rotateRight();
                case 'A' -> moveForward(lawn);
            }
        });

    }
    
    private void rotateLeft() {
        orientation = switch (orientation) {
            case 'N' -> 'W';
            case 'E' -> 'N';
            case 'S' -> 'E';
            case 'W' -> 'S';
            default -> throw new IllegalArgumentException("Orientation invalide: " + orientation);
        };
    }

    private void rotateRight() {
        orientation = switch (orientation) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> throw new IllegalArgumentException("Orientation invalide: " + orientation);
        };
    }

    
	/*
	 * private void moveForward(Lawn lawn) { switch (orientation) { case 'N': if (y
	 * < lawn.getMaxY()) y++; break; case 'E': if (x < lawn.getMaxX()) x++; break;
	 * case 'S': if (y > 0) y--; break; case 'W': if (x > 0) x--; break; } }
	 */
    
    private void moveForward(Lawn lawn) {
        switch (orientation) {
            case 'N' -> { if (y < lawn.getMaxY()) y++; }
            case 'E' -> { if (x < lawn.getMaxX()) x++; }
            case 'S' -> { if (y > 0) y--; }
            case 'W' -> { if (x > 0) x--; }
            default -> throw new IllegalArgumentException("Orientation invalide: " + orientation);
        };
    }


    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}
