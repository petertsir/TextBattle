package Characters;

/**
 * Created by peter on 2/14/17.
 */
public abstract class Player {
    private String name;
    private int maxHealth;
    private int health = maxHealth;
    private int minDamage;
    private int maxDamage;
    private int damageDealt;

    public Player(String name, int maxHealth,int maxDamage,int minDamage) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void receiveDamage(int damage){
        health -= damage;
        System.out.print(name + "has received: " + damage +"." +" " + name + " now has: " + health + " health left.");
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void attack(Player enemy){
        damageDealt = calcDamage();
        enemy.health -= damageDealt;
        System.out.println(name + " attacked " + enemy.name+ ".");
    }

    protected int calcDamage() {
        damageDealt = (int) Math.random()*(maxDamage-minDamage) + minDamage;
        return damageDealt;
    }

}
