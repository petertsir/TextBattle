package Characters;

/**
 * Created by peter on 2/14/17.
 */
public class Mage extends Hero {
    private int maxMana;
    private int mana = maxMana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public Mage(String name) {
        super(name, 45, 20, 4, 60);
        this.maxMana = 40;
    }
    @Override
    public void attack(Player enemy) {
        int damageDealt = (int) Math.random() * (getMaxDamage() - getMinDamage() + getMinDamage());
        int enemyHealth = enemy.getHealth();

        if(this.mana>=10) {
            enemy.setHealth(enemyHealth - damageDealt);
            System.out.print(enemy.getName() + "has received: " + damageDealt + "." + " " + enemy.getName() + " now has: " + enemy.getHealth() + " health left.");
            this.mana -= 10;
        }
        else{
            System.out.println("Oh no! " +this.getName()+ " has run out of Mana!");
        }
    }
}
