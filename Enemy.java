import java.util.ArrayList;
public class Enemy extends Character {
    private String description;
    private int dmg;
    public ArrayList<Enemy> allEnemies;
    private boolean playerKnows;
    public Enemy(String name, int totalHP, String dir, String desc, int damage) {
        super(name, totalHP, dir);
        if(allEnemies == null) { allEnemies = new ArrayList<Enemy>(); }
        allEnemies.add(this);
        description = desc;
        dmg = damage;
        playerKnows = false;
    }
    public String getDesc() { return description; }
    public int getDmg() { return dmg; }
    public boolean getKnowledge() { return playerKnows; }
    public void setKnowledge(boolean knows) { playerKnows = knows; }
}
