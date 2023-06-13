public class Player extends Character {
    private int memoryCount;
    private Memory recentMemory;
    private Item[] inventory;
    private int steps;
    private int x, y, prevX, prevY;
    private int dmg;
    public Player(int totalHP, String name, String dir, int x, int y, int damage) {
        super(name, totalHP, dir);
        memoryCount = 0;
        recentMemory = null;
        inventory = new Item[9];
        steps = 0;
        this.x = x;
        this.y = y;
        prevX = x;
        prevY = y;
        dmg = damage;
    }
    public void addMemory(Memory m) {
        recentMemory = m;
    }
    public Memory remember() { return recentMemory; }
    public int getMemoryCount() { return memoryCount; }
    public int getSteps() { return steps; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getPrevX() { return prevX; }
    public int getPrevY() { return prevY; }
    public String move(int direction, Character[][] platform, Wall[][] map) {
        if(direction == 1) {
            if(map[y][x-1] == null && platform[y][x-1] == null) {
                steps++;
                x--;
                return "[N]: You moved left";
            } else if(map[y][x-1] != null) {
                if(map[y][x-1].toString() == "EXIT") {
                    steps++;
                    return "[N]: You enter the next room";
                } else if(!map[y][x-1].getKnowledge()) {
                    super.damage(1);
                    return "[N]: You can't go there, that's a wall.";
                } else {
                    super.damage(5);
                    return "[N]: Are you serious. You knew the wall was there.";
                }
            } else {
                super.damage(platform[y][x-1].getDmg());
                return "[N]: It's a " + platform[y][x-1].getName() + "! You take " + platform[y][x-1].getDmg() + " damage!";
            }
        } else if(direction == 2) {
            if(map[y][x+1] == null && platform[y][x+1] == null) {
                x++;
                steps++;
                return "[N]: You moved right";
            } else if(map[y][x+1] != null) {
                if(map[y][x+1].toString() == "EXIT") {
                    steps++;
                    return "[N]: You enter the next room";
                } else if(!map[y][x+1].getKnowledge()) {
                    super.damage(1);
                    return "[N]: You can't go there, that's a wall.";
                } else {
                    super.damage(5);
                    return "[N]: Are you serious. You knew the wall was there.";
                }
            } else {
                super.damage(platform[y][x+1].getDmg());
                return "[N]: It's a " + platform[y][x+1].getName() + "! You take " + platform[y][x+1].getDmg() + " damage!";
            }
        } else {
            if(map[y-1][x] == null && platform[y-1][x] == null) {
                y--;
                steps++;
                return "[N]: You moved forward";
            } else if(map[y-1][x] != null) {
                if(map[y-1][x].toString() == "EXIT") {
                    steps++;
                    return "[N]: You enter the next room";
                } else if(!map[y-1][x].getKnowledge()) {
                    super.damage(1);
                    return "[N]: You can't go there, that's a wall.";
                } else {
                    super.damage(5);
                    return "[N]: Are you serious. You knew the wall was there.";
                }
            } else {
                super.damage(platform[y-1][x].getDmg());
                return "[N]: It's a " + platform[y-1][x].getName() + "! You take " + platform[y-1][x].getDmg() + " damage!";
            }
        }
    }
    public void setX(int newX) {
        prevX = x;
        x = newX;
    }
    public void setY(int newY) {
        prevY = y;
        y = newY;
    }
    public Item[] getInventory() { return inventory; }
    public void pickUp(Item item) {
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] == null) {
                inventory[i] = item;
                break;
            }
        }
    }
    public void dropItem(int index) {
        inventory[index] = null;
    }
    public void fixInv() {
        Item temp;
        int nulValue = 0;
        for(int i = 0; i < inventory.length-1; i++) {
            if(inventory[i] == null && inventory[i+1] != null) {
                for(int p = 0; p < inventory.length; p++) {
                    if(inventory[p] == null) {
                        nulValue = p;
                        break;
                    }
                }
                for(int x = i+1; x > nulValue; x--) {
                    temp = inventory[x];
                    inventory[x] = inventory[x-1];
                    inventory[x-1] = temp;
                }
            }
        }
    }
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
    public String inspect(Item item) {
        return "Name: " + item.getName() + "\nDescription: " + item.getDesc();
    }
    public String goBack() {
        steps--;
        x = prevX;
        y = prevY;
        return "You returned to your previous location";
    }
    public int getDmg() { return dmg; }
    public void setKnowledge(boolean knows) {}
}