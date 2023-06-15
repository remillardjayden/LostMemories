public class Npc {
    private String name;
    private String[] voicelines;
    private String[] options;
    private int x, y;
    public Npc(String name, String[] voices, String[] choices, int x, int y) {
        this.name = name;
        voicelines = voices;
        options = choices;
        this.x = x;
        this.y = y;
    }
    public String getCoords() { return "(" + x + ", " + y + ")"; }
    public int getX() { return x; }
    public int getY() { return y; }
    public String getName() { return name; }
    public String[] getVoices() { return voicelines; }
    public String[] getOptions() { return options; }
}
