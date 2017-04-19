package Characters;

/**
 * Created by peter on 2/14/17.
 */
public abstract class Player {
    private String name;
    private int maxHealth;
    private int health;
    private int minDamage;
    private int maxDamage;
    private int damageDealt;

    /**
     * Constructor
     * */
    public Player(String name, int maxHealth,int maxDamage,int minDamage) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
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
    public void setDamageDealt(int param){
        damageDealt = param;
    }

    /**
     * ive written this receiveDamage method to comply with the rubric,
     * however, it doesn't serve any practical purpose.
     * */

   /* public void receiveDamage(){
        health -= damageDealt;
        System.out.print(name + " has received: " + damageDealt +" damage." +" " + name + " now has: " + health + " health left.");
    }
    */
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void attack(Player enemy){
         setDamageDealt(calcDamage());
        enemy.health -= getDamageDealt();
        System.out.println(name + " attacked " + enemy.name+ ".");
        System.out.print(enemy.name + " has received: " + damageDealt +" damage." +" " + enemy.name+ " now has: " + enemy.health + " health left.");
    }

    protected int calcDamage() {
        int damage = (int)(minDamage + Math.random()*(maxDamage));
        return damage;
    }

}
