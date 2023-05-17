public class Player extends Character {
    private int memoryCount;
    private Memory recentMemory;
    private Memory[] allMemories;
    public Player(int totalHP, String name, Memory[] memories) {
        super(name, totalHP);
        memoryCount = 0;
        recentMemory = null;
        allMemories = memories;
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
}