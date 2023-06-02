import java.util.ArrayList;
public class Item {
    private String name;
    private String description;
    public static ArrayList<Item> allItems;
    public Item(String name, String desc) {
        this.name = name;
        description = desc;
        if(allItems == null) { allItems = new ArrayList<Item>(); }
        allItems.add(this);
    }
    public String getName() { return name; }
    public String getDesc() { return description; }
    public ArrayList<Item> getItems() { return allItems; }
}
