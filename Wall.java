public class Wall {
    private int wallX;
    private int wallY;
    private String orientation;
    private String value;
    public Wall(int x, int y, String facing, String val) {
        wallX = x;
        wallY = y;
        orientation = facing;
        value = val;
    }
    public int returnX() { return wallX; }
    public int returnY() { return wallY; }
    public String returnOrientation() { return orientation; }
    public String toString() { return value.toUpperCase(); }
}
