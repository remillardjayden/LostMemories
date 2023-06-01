public class Wall {
    private int wallX;
    private int wallY;
    public Wall(int x, int y) {
        wallX = x;
        wallY = y;
    }
    public int returnX() { return wallX; }
    public int returnY() { return wallY; }
    public String toString() { return "wall"; }
}
