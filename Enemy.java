import java.util.ArrayList;
public class Enemy extends Character {
    public ArrayList<Enemy> allEnemies;
    public Enemy(String name, int totalHP, String dir) {
        super(name, totalHP, dir);
        if(allEnemies == null) { allEnemies = new ArrayList<Enemy>(); }
        allEnemies.add(this);
    }
}
