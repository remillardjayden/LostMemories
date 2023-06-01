public class Wall {
    private int wallX;
    private int wallY;
    private String orientation;
    public Wall(int x, int y, String facing) {
        wallX = x;
        wallY = y;
        orientation = facing;
    }
    public int returnX() { return wallX; }
    public int returnY() { return wallY; }
    public String returnOrientation() { return orientation; }
    public String toString() { return "WALL"; }
}
