import java.util.ArrayList;
import java.lang.Math;
public class Enemy extends Character {
    private int x, y;
    private String description;
    private int dmg;
    public static ArrayList<Enemy> allEnemies;
    private boolean playerKnows;
    public Enemy(String name, int totalHP, String dir, String desc, int damage) {
        super(name, totalHP, dir);
        if(allEnemies == null) { allEnemies = new ArrayList<Enemy>(); }
        allEnemies.add(this);
        description = desc;
        dmg = damage;
        playerKnows = false;
        x = (int)(Math.random()*15);
        y = (int)(Math.random()*15);
    }
    public String getDesc() { return description; }
    public int getDmg() { return dmg; }
    public boolean getKnowledge() { return playerKnows; }
    public void setKnowledge(boolean knows) { playerKnows = knows; }
    public int getX() { return x; }
    public int getY() { return y; }
}
