public abstract class Character {
    private String name;
    private int totalHP;
    private int currentHP;
    private boolean isDead;
    public Character(String name, int hp) {
        this.name = name;
        totalHP = hp;
        currentHP = hp;
        isDead = false;
    }
    public String getName() { return name; }
    public String getHP() { return currentHP + "/" + totalHP; }
    public void fullHeal() { currentHP = totalHP; }
    public void heal(int heal) {
        if(currentHP + heal > totalHP) { fullHeal(); } 
        else { currentHP += heal; }
    }
    public void damage(int dmg) {
        currentHP -= dmg;
        if(currentHP <= 0) { isDead = true; }
    }
    public boolean isDead() { return isDead; }
}
