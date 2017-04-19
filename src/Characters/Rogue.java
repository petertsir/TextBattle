package Characters;

/**
 * Created by peter on 2/14/17.
 */
public class Rogue extends Hero {
    public final double SECOND_ATTACK_CHANCE = 0.2;

    public Rogue(String name) {
        super(name, 25, 0, 3, 100);
    }

    @Override
    public void attack(Player enemy) {
        int loops = 1;
        if (Math.random() <= SECOND_ATTACK_CHANCE) {
            loops = 2;
        }
        for (int i = 1; i <= loops; i++) {
            int damageDealt = calcDamage();
            enemy.setHealth(enemy.getHealth() - damageDealt);
            System.out.print(enemy.getName() + "has received: " + damageDealt + "." + " " + enemy.getName() + " now has: " + enemy.getName() + " health left.");
            if (loops == 2) {
                System.out.println(this.getName() + "gets a second attack!");
            }
        }
    }
}

