import java.util.ArrayList;
public class Item {
    private String name;
    private String description;
    public static ArrayList<Item> allItems;
    private int dmg;
    private Memory linkedMemory;
    public Item(String name, String desc, int damage, Memory rember) {
        this.name = name;
        description = desc;
        dmg = damage;
        if(allItems == null) { allItems = new ArrayList<Item>(); }
        allItems.add(this);
        linkedMemory = rember;
    }
    public String getName() { return name; }
    public String getDesc() { return description; }
    public int getDmg() { return dmg; }
    public Memory getLinkedMemory() { return linkedMemory; }
    public String toString() { return "ITEM"; }
}
