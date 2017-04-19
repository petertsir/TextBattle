package Items;

import Characters.Hero;

/**
 * Created by peter on 2/16/17.
 * increases the hero's health by a given percentage
 */
public class HealPotion extends Item{
    private int healPower;


    public void heal(Hero hero){
        int startHealth = hero.getHealth();
        int healthDiff = hero.getMaxHealth() - hero.getHealth();

        if (healthDiff < healPower){
            hero.setHealth(hero.getMaxHealth());
        }
        hero.setHealth(startHealth + healPower);
        System.out.println(hero.getName() + " has been healed. \n" + hero.getName()+ "'s health is now: " + hero.getHealth());
    }

    public HealPotion(int healPower) {
        this.healPower = healPower;
    }

    @Override
    public String toString() {
        return "HealthPotion{" + " with the Healing Power of " + healPower + " }";
    }

    @Override
    public void apply(Hero hero){
        heal(hero);
    }
}
