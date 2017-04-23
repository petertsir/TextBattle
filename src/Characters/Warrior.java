package Characters;

import Items.Item;

/**
 * Created by peter on 2/14/17.
 */
public class Warrior extends Hero{
    private final double CRITCHANCE = 0.10;

    public Warrior(String name) {
        super(name, 15, 0, 3, 150);
    }

    @Override
    public int calcDamage(){
        int damageDealt = super.calcDamage();
        if(Math.random() <= CRITCHANCE){
            damageDealt *= 2;
            System.out.println(this.getName() + " dealt a critical blow!");
        }
        return damageDealt;
    }


}

