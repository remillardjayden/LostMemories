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
    public static void openMap(Wall[][] map, Player user, Character[][] platform) {
        for(int r = 0; r < 25; r++) {
            for(int c = 0; c < 25; c++) {
                if(map[r][c] == null) {
                    if(platform[r][c] != user) {
                        System.out.print("     ");
                    } else {
                        System.out.print(user + " ");
                    }
                } else if(map[r][c] != null){
                    System.out.print(map[r][c] + " ");
                }
            }
            System.out.println("\n");
        }
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
        Player user = new Player(20, name, "Forward", placeX, placeY);
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
        new Item("Banana", "Just a banana?");
        new Item("Steve", "OUH");
        new Item("Stick", "It's sticky");
        // Enemies
        new Enemy("Bat", 50, "Left");
        for(int r = 0; r < 25; r++) {
            for(int c = 0; c < 25; c++) {
                if(r == user.getY() && c == user.getX()) {
                    platform[r][c] = user;
                }
            }
        }
        for(int i = 0; i < Item.allItems.size(); i++) {
            user.pickUp(Item.allItems.get(i));
            System.out.println(user.getInv());
        }
        user.dropItem(0);
        System.out.println(user.getInv());
        user.fixInv();
        System.out.println(user.getInv());
    }
}
// Far Away For You
// [Peek], [Move (Left, Right, Forward [L, R, F])], Inspect, Open Map, Return, [Inventory System]