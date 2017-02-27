package Items;

import Characters.Hero;
import Characters.Player;

/**
 * Created by peter on 2/17/17.
 * increases the hero's damage by a given percentage
 */

public class DamagePotion extends Item {
    private double percentIncrease;

    public void increaseDamage(Characters.Hero hero) {
        hero.setMaxDamage((int) (hero.getMinDamage() * (1 + (this.percentIncrease / 100))));
    }

    public DamagePotion(double percentIncrease) {
        this.percentIncrease = percentIncrease;
    }

    @Override
    public String toString() {
        return "DamagePotion{" +
                "percentIncrease=" + percentIncrease +
                '}';
    }

    @Override
    public void apply(Hero hero){
        increaseDamage(hero);
    }
}