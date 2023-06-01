import java.util.ArrayList;
public class Memory {
    private int index;
    private String name;
    private String contents;
    private ArrayList<Memory> allmemories;
    public Memory(int index, String name, String hold) {
        this.index = index;
        this.name = name;
        contents = hold;
        if(allmemories == null) { allmemories = new ArrayList<>(); }
        allmemories.add(this);
    }
    public int getStrength() { return index; }
    public String getName() { return name; }
    public ArrayList<Memory> getMemories() { return allmemories; }
    public String toString() { return contents; }
}