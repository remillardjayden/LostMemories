public class Wall {
    private int wallX;
    private int wallY;
    private String direction;
    public Wall(int x, int y, String facing) {
        wallX = x;
        wallY = y;
        direction = facing;
    }
    public int returnX() { return wallX; }
    public int returnY() { return wallY; }
    public String returnDirection() { return direction; }
    public String toString() { return "wall"; }
}
