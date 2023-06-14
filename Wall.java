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
    public int getX() { return wallX; }
    public int getY() { return wallY; }
    public String getOrientation() { return orientation; }
    public boolean getKnowledge() { return playerKnows; }
    public void setKnowledge(boolean knows) { playerKnows = knows; }
    public String getValue() { return value; }
    public String toString() { return value.toUpperCase(); }
}
