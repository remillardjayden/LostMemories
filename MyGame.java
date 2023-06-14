import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class MyGame {
    public static void slp(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static void slmp(int time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public static void superSlowWrite(String txt) {
        for(int i = 0; i < txt.length(); i++) {
            System.out.print(txt.charAt(i));
            slmp(160);
        }
        System.out.println();
    }
    public static void slowWrite(String txt) {
        for(int i = 0; i < txt.length(); i++) {
            System.out.print(txt.charAt(i));
            slmp(50);
        }
        System.out.println();
    }
    public static void quickWrite(String txt) {
        for(int i = 0; i < txt.length(); i++) {
            System.out.print(txt.charAt(i));
            slmp(20);
        }
        System.out.println();
    }
    public static void playerText(Player user, String txt) {
        System.out.print("[" + user.getName().charAt(0) + "]: ");
        slowWrite(txt);
        slmp(500);
    }
    public static void openMap(Wall[][] map, Player user, Character[][] platform, Item[][] items) {
        for(int r = 0; r < 25; r++) {
            for(int c = 0; c < 25; c++) {
                if(map[r][c] == null) {
                    if(platform[r][c] == null) {
                        if(items[r][c] == null) {
                            System.out.print("____ ");
                        } else {
                            System.out.print("???? ");
                        }
                    } else if(platform[r][c] == user) {
                        System.out.print("USER ");
                    }
                } else {
                    System.out.print(map[r][c] + " ");
                }
            }
            System.out.println("\n");
        }
    }
	public static Wall[][] newMap(Random rand, Player user) {
		Wall[][] newMap = new Wall[25][25];
        int orientation;
        int xPlace = 0;
        int yPlace = 0;
		for(int r = 0; r < 25; r++) {
            for(int c = 0; c < 25; c++) {
                if(r == 0 || c == 0 || r == 24 || c == 24) {
                    orientation = rand.nextInt(2) + 1;
                    if(orientation == 1) { 
                        newMap[r][c] = new Wall(c, r, "Horizontal", "wall");
                    } else {
                        newMap[r][c] = new Wall(c, r, "Vertical", "wall");
                    }
                    if(c == 0 && r == 12 || c == 24 && r == 12) {
                        newMap[r][c] = new Wall(c, r, "Vertical", "exit");
                    } else if (r == 0 && c == 12 || r == 24 && c == 12) {
                        newMap[r][c] = new Wall(c, r, "Horizontal", "exit");
                    }
                }
                if(c % 3 == 0 && r % 2 == 0) {
                    xPlace = rand.nextInt(23)+1;
                    yPlace = rand.nextInt(23)+1;
					while(xPlace == user.getX() && yPlace == user.getY()) {
						xPlace = rand.nextInt(23)+1;
						yPlace = rand.nextInt(23)+1;
					}
                    orientation = rand.nextInt(2) + 1;
                    if(orientation == 1) { 
                        newMap[yPlace][xPlace] = new Wall(yPlace, xPlace, "Horizontal", "wall");
                    } else {
                        newMap[yPlace][xPlace] = new Wall(yPlace, xPlace, "Vertical", "wall");
                    }
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            xPlace = rand.nextInt(23)+1;
            yPlace = rand.nextInt(23)+1;
            while(newMap[yPlace][xPlace] != null) {
                xPlace = rand.nextInt(23)+1;
                yPlace = rand.nextInt(23)+1;
            }
            orientation = rand.nextInt(2) + 1;
            if(orientation == 1) { 
                newMap[yPlace][xPlace] = new Wall(yPlace, xPlace, "Horizontal", "door");
            } else {
                newMap[yPlace][xPlace] = new Wall(yPlace, xPlace, "Vertical", "door");
            }
        }
		return newMap;
	}
    public static void peek(int direction, Character[][] platform, Wall[][] map, Player user, Item[][] items) {
        if(direction == 1) {
            if(platform[user.getY()][user.getX()-1] == null) {
                if(map[user.getY()][user.getX()-1] != null) {
                    System.out.println("There's a wall");
                    map[user.getY()][user.getX()-1].setKnowledge(true);
                }
            } else if(platform[user.getY()][user.getX()-1] != null) {
                platform[user.getY()][user.getX()-1].setKnowledge(true);
                System.out.println("There's an enemy there");
            } else if(items[user.getY()][user.getX()-1] != null){
                System.out.println("There's something there..");
            } else {
                System.out.println("There's nothing obstructing you");
            }
        } else if(direction == 2){
            if(platform[user.getY()][user.getX()+1] == null) {
                if(map[user.getY()][user.getX()+1] != null) {
                    map[user.getY()][user.getX()+1].setKnowledge(true);
                    System.out.println("There's a wall");
                }
            } else if(platform[user.getY()][user.getX()+1] != null) {
                platform[user.getY()][user.getX()+1].setKnowledge(true);
                System.out.println("There's an enemy there");
            } else if(items[user.getY()][user.getX()+1] != null){
                System.out.println("There's something there..");
            } else {
                System.out.println("There's nothing obstructing you");
            }
        } else if(direction == 3) {
            if(platform[user.getY()-1][user.getX()] == null) {
                if(map[user.getY()-1][user.getX()] != null) {
                    System.out.println("There's a wall");
                    map[user.getY()-1][user.getX()].setKnowledge(true);
                }
            } else if(platform[user.getY()-1][user.getX()] != null) {
                platform[user.getY()-1][user.getX()].setKnowledge(true);
                System.out.println("There's an enemy there");
            } else if(items[user.getY()-1][user.getX()] != null){
                System.out.println("There's something there..");
            } else {
                System.out.println("There's nothing obstructing you");
            }
        } else if(direction == 4) {
            if(platform[user.getY()+1][user.getX()] == null) {
                if(map[user.getY()+1][user.getX()] != null) {
                    System.out.println("There's a wall");
                    map[user.getY()+1][user.getX()].setKnowledge(true);
                }
            } else if(platform[user.getY()+1][user.getX()] != null) {
                platform[user.getY()+1][user.getX()].setKnowledge(true);
                System.out.println("There's an enemy there");
            } else if(items[user.getY()+1][user.getX()] != null){
                System.out.println("There's something there..");
            } else {
                System.out.println("There's nothing obstructing you");
            }
        }
    }
    public static void main(String[] args) {
        int counter = 1;
        Random rand= new Random();
        Character[][] platform = new Character[25][25];
        Wall[][] map = new Wall[25][25];
        Item[][] items = new Item[25][25];
        int xPlace = 0;
        int yPlace = 0;
        int orientation;
        for(int r = 0; r < 25; r++) {
            for(int c = 0; c < 25; c++) {
                if(r == 0 || c == 0 || r == 24 || c == 24) {
                    orientation = rand.nextInt(2) + 1;
                    if(orientation == 1) { 
                        map[r][c] = new Wall(c, r, "Horizontal", "wall");
                    } else {
                        map[r][c] = new Wall(c, r, "Vertical", "wall");
                    }
                    if(c == 0 && r == 12 || c == 24 && r == 12) {
                        map[r][c] = new Wall(c, r, "Vertical", "exit");
                    } else if (r == 0 && c == 12 || r == 24 && c == 12) {
                        map[r][c] = new Wall(c, r, "Horizontal", "exit");
                    }
                }
                if(c % 3 == 0 && r % 2 == 0) {
                    xPlace = rand.nextInt(23)+1;
                    yPlace = rand.nextInt(23)+1;
                    orientation = rand.nextInt(2) + 1;
                    if(orientation == 1) { 
                        map[yPlace][xPlace] = new Wall(yPlace, xPlace, "Horizontal", "wall");
                    } else {
                        map[yPlace][xPlace] = new Wall(yPlace, xPlace, "Vertical", "wall");
                    }
                }
            }
        }
        int placeX = rand.nextInt(23)+1;
        int placeY = rand.nextInt(23)+1;
        while(map[placeY][placeX] != null) {
            placeX = rand.nextInt(23)+1;
            placeY = rand.nextInt(23)+1;
        }
        Scanner use = new Scanner(System.in);
        System.out.println("N: Enter your name: ");
        String name = use.nextLine();
        Player user = new Player(20, name, "Forward", placeX, placeY, 1);
        for(int i = 0; i < 3; i++) {
            xPlace = rand.nextInt(23)+1;
            yPlace = rand.nextInt(23)+1;
            while(map[yPlace][xPlace] != null) {
                xPlace = rand.nextInt(23)+1;
                yPlace = rand.nextInt(23)+1;
            }
            orientation = rand.nextInt(2) + 1;
            if(orientation == 1) { 
                map[yPlace][xPlace] = new Wall(yPlace, xPlace, "Horizontal", "door");
            } else {
                map[yPlace][xPlace] = new Wall(yPlace, xPlace, "Vertical", "door");
            }
        }
        // Memories
        new Memory(0, "Fall.", "[$#!@^*]: Falling falling, down you go. When you do land, no one will know. . .");
        new Memory(1, "Away.", name + "[?]: Where are you taking me? Someone help! Please! Anyone!");
        new Memory(2, "Run.", "[R]: After them! Don't let them escape.\n[L]: We've got you now, kid! You're not getting away this time.");
        new Memory(3, "Accountable.", "[R]: It was you... wasn't it? You're the one that-");
        new Memory(4, "Whispers.", "[R + L]: Maybe we should talk to them, they seem a little... off.");
        new Memory(5, "Altered.", "[" + name.substring(0,1) + "]: Oh god... God no I'm a horrible person. I just...");
        new Memory(6, "Youth.", "[" + name.substring(0,1) + "]: What can I do? I guess I should find a place to stay...");
        new Memory(7, "Finale.", "*drip*...*drip*...*drip*\n[D]: *wheeze*..I guess this is how I go...Goodbye..*thud*\n[" + name.substring(0,1) + "]: What have I done..?");
        new Memory(8, "Overcome.", "[D]: There you are, kid. I knew you'd come around at some- *STAB* ...oh..");
        new Memory(9, "Retreat.", "[D]: I know you're here! I can hear you! Come on out, I don't bite! I'm just a little drunk, I'm sorry."); 
        new Memory(10, "Yourself.",  "[" + name.substring(0,1) + "]: Where do I go? I can't go back, I guess I'll just sleep here..");
        new Memory(11, "Outrun.", "[D]: Do you think you can escape?! Get back here you little brat!");
        new Memory(12, "Upbringing.", "[M]: I can't believe you would do that to them! They're just a kid! You stupid a-\n*BANG* ... *thud*");
        // Items
        new Item("Stick", "It's sticky", 1, Memory.allMemories.get(0));
        new Item("Bloody Rock", "It's a bloody rock, mate. Leave it be.", 2, Memory.allMemories.get(1));
        new Item("Rope", "It seems used", 4, Memory.allMemories.get(2));
        new Item("Broken Toy", "Destroyed beyond repair", 8, Memory.allMemories.get(3));
        new Item("Walkie Talkie", "No more batteries, no more voices", 16, Memory.allMemories.get(4));
        new Item("Shattered Mirror", "You look destroyed within", 32, Memory.allMemories.get(5));
        new Item("Dead Dove", "Life wasted, peace gone.", 0, Memory.allMemories.get(6));
        new Item("Skeleton Skull", "Bits of flesh remain", 64, Memory.allMemories.get(7));
        new Item("Red Shirt", "It seems like blood..", 0, Memory.allMemories.get(8));
        new Item("Gas Lamp", "It's entirely used up, someone must've been scared", 128, Memory.allMemories.get(9));
        new Item("Wilting Lilac", "It's almost died, must've been stepped on", 0, Memory.allMemories.get(10));
        new Item("Flaming Track Shoes", "Someone was going a bit too quick", 256, Memory.allMemories.get(11));
        new Item("Bottle", "Contents decay the mind", 0, Memory.allMemories.get(12));
        // Enemies
        new Enemy("Bat", 50, "Left", "He's Booberry", 5);
        new Enemy("Bat", 50, "Right", "He's Count Dracula", 5);
        for(int r = 0; r < 25; r++) {
            for(int c = 0; c < 25; c++) {
                if(r == user.getY() && c == user.getX()) {
                    platform[r][c] = user;
                }
            }
        }
        user.pickUp(Item.allItems.get(0));
        // Start of story
        playerText(user, "Man this is such a weird maze.. how long have I been walking?");
        playerText(user, "No matter... guess I'll look for the exit..");
        boolean exit = false;
        while(user.getHealth() > 0 && !exit) {
            System.out.println("[N]: What would you like to do?\n1: Move\n2: Peek\n3: Open Map\n4: Open Inventory");
            int option = use.nextInt();
            while(option < 1 || option > 4) {
                System.out.println("[N]: Sorry, that isn't valid, try again.");
                slmp(500);
                System.out.println("[N]: What would you like to do?\n1: Move\n2: Peek\n3: Open Map\n4: Open Inventory");
                option = use.nextInt();
            }
            if(option == 1) {
                System.out.println("[N]: Which direction would you like to move?\n1: Left\n2: Right\n3: Up\n4: Down");
                int move = use.nextInt();
                while(move < 1 || move > 4) {
                    System.out.println("[N]: Sorry, that isn't valid, try again.");
                    slmp(500);
                    System.out.println("[N]: Which direction would you like to move?\n1: Left\n2: Right\n3: Up\n4: Down");
                    move = use.nextInt();
                }
                user.move(move, platform, map, items);
            } else if(option == 2) {
                System.out.println("[N]: Which direction would you like to peek?\n1: Left\n2: Right\n3: Up\n4: Down");
                int peek = use.nextInt();
                while(peek < 1 || peek > 4) {
                    System.out.println("[N]: Sorry, that isn't valid, try again.");
                    slmp(500);
                    System.out.println("[N]: Which direction would you like to peek?\n1: Left\n2: Right\n3: Up\n4: Down");
                    peek = use.nextInt();
                }
                peek(peek, platform, map, user, items);
            } else if(option == 3) {
                System.out.println("[N]: You open your map. . .");
                slmp(500);
                openMap(map, user, platform, items);
            } else {
                System.out.println("[N]: You open your inventory. . .");
                slmp(500);
                user.getInv();
                slmp(500);
                System.out.println("[N]: What would you like to do?\n1: Inspect an item\n2: Drop an item\n3: Return to original menu");
                option = use.nextInt();
                while(option < 1 || option > 3) {
                    System.out.println("[N]: Sorry, that isn't valid, try again.");
                    slmp(500);
                    System.out.println("[N]: What would you like to do?\n1: Inspect an item\n2: Drop an item\n3: Return to original menu");
                    option = use.nextInt();
                }
                if(option == 1) {
                    System.out.println("[N]: Which item would you like to inspect?");
                    slmp(500);
                    int count = 0;
                    for(int i = 0; i < user.getInventory().length; i++) {
                        if(user.getInventory()[i] != null) {
                            System.out.println(i + ": " + user.getInventory()[i].getName());
                            slmp(250);
                            count++;
                        }
                    }
                    option = use.nextInt();
                    while(option < 0 || option > count) {
                        System.out.println("[N]: Sorry, that isn't valid, try again.");
                        System.out.println("[N]: Which item would you like to inspect?");
                        slmp(500);
                        count = 0;
                        for(int i = 0; i < user.getInventory().length; i++) {
                            if(user.getInventory()[i] != null) {
                                System.out.println(i + ": " + user.getInventory()[i].getName());
                                slmp(250);
                                count++;
                            }
                        }
                        option = use.nextInt();
                    }
                    System.out.println(user.inspect(user.getInventory()[option]));
                } else if(option == 2) {
                    System.out.println("[N]: Which item would you like to drop?");
                    slmp(500);
                    int count = 0;
                    for(int i = 0; i < user.getInventory().length; i++) {
                        if(user.getInventory()[i] != null) {
                            System.out.println(i + ": " + user.getInventory()[i].getName());
                            slmp(250);
                            count++;
                        }
                    }
                    option = use.nextInt();
                    while(option < 0 || option > count) {
                        System.out.println("[N]: Sorry, that isn't valid, try again.");
                        System.out.println("[N]: Which item would you like to drop?");
                        slmp(500);
                        count = 0;
                        for(int i = 0; i < user.getInventory().length; i++) {
                            if(user.getInventory()[i] != null) {
                                System.out.println(i + ": " + user.getInventory()[i].getName());
                                slmp(250);
                                count++;
                            }
                        }
                        option = use.nextInt();
                    }
                    user.dropItem(option);
                }
            }
			if(user.getX() == 0 || user.getY() == 0 || user.getX() == 24 || user.getY() == 24 || map[user.getY()][user.getX()] != null) {
                counter++;
                platform[user.getY()][user.getX()] = null;
				if(user.getX() == 0) {
					user.setX(23);
				} else if(user.getY() == 0) {
					user.setY(23);
				} else if(user.getX() == 24) {
					user.setX(1);
				} else if(user.getY() == 24){
					user.setY(1);
				}
                platform[user.getY()][user.getX()] = user;
				map = newMap(rand, user);
                if(counter == 5) {
                    int xLocation = rand.nextInt(23)+1;
                    int yLocation = rand.nextInt(23)+1;
                    while(map[yLocation][xLocation] != null || platform[yLocation][xLocation] != null) {
                        xLocation = rand.nextInt(23)+1;
                        yLocation = rand.nextInt(23)+1;
                    }
                    int check = 0;
                    for(int i = 0; i < 13; i++) {
                        if(user.getInventory()[i] == null) {
                            check = i;
                            break;
                        }
                    }
                    Item placed = Item.allItems.get(check);
                    items[yLocation][xLocation] = placed;
                    counter = 0;
                }
			}
        }
        use.close();
    }
}
// Peek, Move (Left, Right, Forward [L, R, F]), Inspect, Open Map, Return, Inventory System
// Ending: Relive memories, fill in gaps, end with a *thud* and then silence