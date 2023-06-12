import java.util.ArrayList;
public class Item {
    private String name;
    private String description;
    public static ArrayList<Item> allItems;
    private int dmg;
    public Item(String name, String desc, int damage) {
        this.name = name;
        description = desc;
        dmg = damage;
        if(allItems == null) { allItems = new ArrayList<Item>(); }
        allItems.add(this);
    }
    public String getName() { return name; }
    public String getDesc() { return description; }
    public int getDmg() { return dmg; }
    public ArrayList<Item> getItems() { return allItems; }
}
