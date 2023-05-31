public class Player extends Character {
    private int memoryCount;
    private Memory recentMemory;
    private Memory[] allMemories;
    private Item[] inventory;
    public Player(int totalHP, String name, Memory[] memories, String dir) {
        super(name, totalHP, dir);
        memoryCount = 0;
        recentMemory = null;
        allMemories = memories;
        inventory = new Item[9];
    }
    public void addMemory(Memory m) {
        recentMemory = m;
        allMemories[m.getStrength()] = m;
    }
    public Memory remember() { return recentMemory; }
    public int getMemoryCount() { return memoryCount; }
    public String accessMemories() {
        String mems = "[";
        for(int i = 0; i < allMemories.length-1; i++) {
            if(allMemories[i] != null) {
                mems += allMemories[i].getName() + ", ";
            } else {
                mems += "UNKNOWN, ";
            }
        }
        if(allMemories[allMemories.length-1] != null) {
            mems += allMemories[allMemories.length-1].getName() + "]";
        } else {
            mems += "UNKNOWN]";
        }
        return mems;
    }
    public String getInv() {
        String fin = "[";
        for(int i = 0; i < 9; i++) {
            if(inventory[i] == null) {
                fin += "_____, ";
            } else {
                fin += inventory[i].getName() + ", ";
            }
        }
        if(inventory[8] == null) {
            fin += "_____]";
        } else {
            fin += inventory[8].getName() + "]";
        }
        return fin;
    }
    public String toString() {
        return super.getName();
    }
}