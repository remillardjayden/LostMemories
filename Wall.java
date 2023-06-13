public class Wall {
    private int wallX;
    private int wallY;
    private String orientation;
    private String value;
    private boolean playerKnows;
    public Wall(int x, int y, String facing, String val) {
        wallX = x;
        wallY = y;
        orientation = facing;
        value = val;
        playerKnows = false;
    }
    public int returnX() { return wallX; }
    public int returnY() { return wallY; }
    public String returnOrientation() { return orientation; }
    public boolean getKnowledge() { return playerKnows; }
    public void setKnowledge(boolean knows) { playerKnows = knows; }
    public String toString() { return value.toUpperCase(); }
}
