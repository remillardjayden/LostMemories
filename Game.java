import java.util.Random;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Scanner use = new Scanner(System.in);
        System.out.println("N: Enter your name: ");
        String name = use.nextLine();
        use.close();
        Random rand= new Random();
        Memory[] memories = new Memory[13];
        Character[][] platform = new Character[50][50];
        Player user = new Player(20, name, memories);
        Player yes = new Player(0, "u", memories);
        Memory memory1 = new Memory(0, "Fall.", "$#!@^*: Falling falling, down you go. When you do land, no one will know. . .");
        Memory memory2 = new Memory(1, "Away.", name + "?: Where are you taking me? Someone help! Please! Anyone!");
        Memory memory3 = new Memory(2, "Run.", "R: After him! Don't let him escape.\nL: We've got you now, kid! You're not getting away this time.");
        Memory memory4 = new Memory(3, "Accountable.", "R: It was you... wasn't it? You're the one that-");
        Memory memory5 = new Memory(4, "Whispers.", "R + L: Maybe we should talk to him, he seems a little... off.");
        Memory memory6 = new Memory(5, "Altered.", name.substring(0,1) + ": Oh god... God no I'm a horrible person. I just...");
        Memory memory7 = new Memory(6, "Youth.", name.substring(0,1) + ": What can I do? I guess I should find a place to stay...");
        Memory memory8 = new Memory(7, "Finale.", "*drip*...*drip*...*drip*\nD: *wheeze*..I guess this is how I go...Goodbye..*thud*\n" + name.substring(0,1) + ": What have I done..?");
        Memory memory9 = new Memory(8, "Overcome.", "D: There you are, buddy. I knew you'd come around at some- *STAB* ...oh..");
        Memory memory10 = new Memory(9, "Retreat.", "D: I know you're here! I can hear you! Come on out, I don't bite! I'm just a little drunk, I'm sorry."); 
        Memory memory11 = new Memory(10, "Yourself.",  name.substring(0,1) + ": Where do I go? I can't go back, I guess I'll just sleep here..");
        Memory memory12 = new Memory(11, "Outrun.", "D: Do you think you can escape?! Get back here you little brat!");
        Memory memory13 = new Memory(12, "Upbringing.", "M: I can't believe you would do that to them! They're just a kid! You stupid a-\n*BANG* ... *thud*");
        for(int r = 0; r < 50; r++) {
            for(int c = 0; c < 50; c++) {
                if(r == 24 && c == 5) {
                    platform[r][c] = user;
                } else if(r < 5 || c < 5 || r > 44 || c > 44){
                    platform[r][c] = yes;
                }
            }
        }
        for(int r = 0; r < 50; r++) {
            for(int c = 0; c < 50; c++) {
                System.out.print(platform[r][c] + " ");
            }
            System.out.println("");
        }
    }
}
// Far Away For You