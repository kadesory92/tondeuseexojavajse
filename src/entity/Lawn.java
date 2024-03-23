package entity;

public class Lawn {
    private int maxX;
    private int maxY;

    public Lawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }
    
    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
    
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
