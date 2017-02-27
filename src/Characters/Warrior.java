package Characters;

import Items.Item;

/**
 * Created by peter on 2/14/17.
 */
public class Warrior extends Hero{
    public final double CRITCHANCE = 0.10;

    public Warrior(String name) {
        super(name, 15, 0, 3, 150);
    }

    @Override
    public int getDamageDealt(){
        int damageDealt = super.getDamageDealt();
        if(1-Math.random() <= CRITCHANCE){
            damageDealt *= 2;
            System.out.println(this.getName() + "dealt a critical blow!");
        }
        return damageDealt;
    }

    @Override
    public void attack(Player enemy) {
        int damageDealt = getDamageDealt();
        int enemyHealth = enemy.getHealth();

        enemy.setHealth(enemyHealth - damageDealt);
        System.out.print(enemy.getName() + "has received: " + damageDealt + "." + " " + enemy.getName() + " now has: " + enemy.getHealth() + " health left.");

    }
}

