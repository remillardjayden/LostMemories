import java.util.ArrayList;
public class Memory {
    private int index;
    private String name;
    private String contents;
    public static ArrayList<Memory> allMemories;
    public Memory(int index, String name, String hold) {
        this.index = index;
        this.name = name;
        contents = hold;
        if(allMemories == null) { allMemories = new ArrayList<>(); }
        allMemories.add(this);
    }
    public int getStrength() { return index; }
    public String getName() { return name; }
    public ArrayList<Memory> getMemories() { return allMemories; }
    public String toString() { return contents; }
}