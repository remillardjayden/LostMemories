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
    public static void slowWrite(String txt) {
        for(int i = 0; i < txt.length(); i++) {
            System.out.print(txt.charAt(i));
            slmp(75);
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
    public static void openMap(Wall[][] map, Player user, Character[][] platform) {
        for(int r = 0; r < 25; r++) {
            for(int c = 0; c < 25; c++) {
                if(map[r][c] == null) {
                    if(platform[r][c] != user) {
                        System.out.print("____ ");
                    } else {
                        System.out.print("USER ");
                    }
                } else if(map[r][c] != null){
                    System.out.print(map[r][c] + " ");
                }
            }
            System.out.println("\n");
        }
    }
    public static String peek(int direction, Character[][] platform, Wall[][] map, Player user) {
        if(direction == 1) {
            if(platform[user.getY()][user.getX()-1] == null) {
                if(map[user.getY()][user.getX()-1] != null) {
                    return "There's a wall";
                }
            } else if(platform[user.getY()][user.getX()-1] != null) {
                return "There's an enemy there";
            }
        } else if(direction == 1) {
            if(platform[user.getY()-1][user.getX()] == null) {
                if(map[user.getY()-1][user.getX()] != null) {
                    return "There's a wall";
                }
            } else if(platform[user.getY()-1][user.getX()] != null) {
                return "There's an enemy there";
            }
        } else {
            if(platform[user.getY()][user.getX()+1] == null) {
                if(map[user.getY()][user.getX()+1] != null) {
                    return "There's a wall";
                }
            } else if(platform[user.getY()][user.getX()+1] != null) {
                return "There's an enemy there";
            }
        }
        return "There's nothing there";
    }
    public static void main(String[] args) {
        Scanner use = new Scanner(System.in);
        System.out.println("N: Enter your name: ");
        String name = use.nextLine();
        use.close();
        Random rand= new Random();
        Character[][] platform = new Character[25][25];
        Wall[][] map = new Wall[25][25];
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
        if(map[placeY][placeX] != null) {
            while(map[placeY][placeX] != null) {
                placeX = rand.nextInt(23)+1;
                placeY = rand.nextInt(23)+1;
            }
        }
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
        new Memory(0, "Fall.", "$#!@^*: Falling falling, down you go. When you do land, no one will know. . .");
        new Memory(1, "Away.", name + "?: Where are you taking me? Someone help! Please! Anyone!");
        new Memory(2, "Run.", "R: After him! Don't let him escape.\nL: We've got you now, kid! You're not getting away this time.");
        new Memory(3, "Accountable.", "R: It was you... wasn't it? You're the one that-");
        new Memory(4, "Whispers.", "R + L: Maybe we should talk to him, he seems a little... off.");
        new Memory(5, "Altered.", name.substring(0,1) + ": Oh god... God no I'm a horrible person. I just...");
        new Memory(6, "Youth.", name.substring(0,1) + ": What can I do? I guess I should find a place to stay...");
        new Memory(7, "Finale.", "*drip*...*drip*...*drip*\nD: *wheeze*..I guess this is how I go...Goodbye..*thud*\n" + name.substring(0,1) + ": What have I done..?");
        new Memory(8, "Overcome.", "D: There you are, buddy. I knew you'd come around at some- *STAB* ...oh..");
        new Memory(9, "Retreat.", "D: I know you're here! I can hear you! Come on out, I don't bite! I'm just a little drunk, I'm sorry."); 
        new Memory(10, "Yourself.",  name.substring(0,1) + ": Where do I go? I can't go back, I guess I'll just sleep here..");
        new Memory(11, "Outrun.", "D: Do you think you can escape?! Get back here you little brat!");
        new Memory(12, "Upbringing.", "M: I can't believe you would do that to them! They're just a kid! You stupid a-\n*BANG* ... *thud*");
        // Items
        new Item("Stick", "It's sticky", 3);
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
        openMap(map, user, platform);
        // Start of story
        System.out.print("[" + user.getName().charAt(0) + "]: ");
        slowWrite("Man this is such a weird maze.. how long have I been walking?");
    }
}
// Far Away For You
// Peek, Move (Left, Right, Forward [L, R, F]), Inspect, Open Map, Return, Inventory System