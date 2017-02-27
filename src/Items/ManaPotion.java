package Items;

import Characters.Hero;
import Characters.Mage;

/**
 * Created by peter on 2/26/17.
 */
public class ManaPotion extends Item {
    private int restorationNum;


    public ManaPotion(int restorationNum) {
        this.restorationNum = restorationNum;
    }

    public void restoreMana(Characters.Mage mage){
        int startMana = mage.getMana();
        int manaDiff= mage.getMaxHealth() - mage.getMana();

        if (manaDiff < restorationNum){
            mage.setMana(mage.getMaxMana());
        }
        mage.setMana(startMana + restorationNum);
    }

    @Override
    public void apply(Hero hero) {
        if (hero.getClass().isAssignableFrom(Mage.class)) {
            restoreMana((Mage)hero);
        }
    }
}
