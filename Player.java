public class Player {
    private int memoryCount;
    private String name;
    private int totalHp;
    private int currentHp;
    private Memory recentMemory;
    private Memory[] allMemories;
    public Player(int totalHp, String name, Memory[] memories) {
        this.name = name;
        this.totalHp = totalHp;
        currentHp = totalHp;
        memoryCount = 0;
        recentMemory = null;
        allMemories = memories;
    }
    public void addMemory(Memory m) {
        recentMemory = m;
        allMemories[m.getStrength()] = m;
    }
    public Memory remember() { return recentMemory; }
    public String getName() { return name; }
    public int getMemoryCount() { return memoryCount; }
    public String getHp() { return currentHp + "/" + totalHp; }
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