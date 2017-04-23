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
        boolean secondAttackCondition = false;
        if (Math.random() <= SECOND_ATTACK_CHANCE) {
            loops = 2;
            secondAttackCondition = true;
        }
        for (int i = 1; i <= loops; i++) {
            super.attack(enemy);
            if (secondAttackCondition) {
                if (this.getHealth()== 0){
                    System.out.println("\n" + this.getName() + " gets a second attack! *Que spooky music* FROM BEYOND THE GRAVE!!!");

                }
                System.out.println("\n" + this.getName() + " gets a second attack!");
                secondAttackCondition = false;
            }
        }
    }
}
