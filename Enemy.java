import java.util.ArrayList;
public class Enemy extends Character {
    private String description;
    public ArrayList<Enemy> allEnemies;
    public Enemy(String name, int totalHP, String dir, String desc) {
        super(name, totalHP, dir);
        if(allEnemies == null) { allEnemies = new ArrayList<Enemy>(); }
        allEnemies.add(this);
        description = desc;
    }
    public String getDesc() { return description; }
}
