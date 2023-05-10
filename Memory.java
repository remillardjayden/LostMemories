public class Memory {
    private int index;
    private String name;
    private String contents;
    public Memory(int index, String name, String hold) {
        this.index = index;
        this.name = name;
        contents = hold;
    }
    public int getStrength() { return index; }
    public String getName() { return name; }
    public String toString() { return contents; }
}