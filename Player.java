public class Player extends Character {
    private int memoryCount;
    private Memory recentMemory;
    private Item[] inventory;
    private int steps;
    private int x, y;
    public Player(int totalHP, String name, String dir, int x, int y) {
        super(name, totalHP, dir);
        memoryCount = 0;
        recentMemory = null;
        inventory = new Item[9];
        steps = 0;
        this.x = x;
        this.y = y;
    }
    public void addMemory(Memory m) {
        recentMemory = m;
    }
    public Memory remember() { return recentMemory; }
    public int getMemoryCount() { return memoryCount; }
    public int getSteps() { return steps; }
    public int getX() { return x; }
    public int getY() { return y; }
    public String getInv() {
        String fin = "[";
        for(int i = 0; i < 8; i++) {
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
    public String goBack() {
        steps--;
        return "You returned to your previous location";
    }
}