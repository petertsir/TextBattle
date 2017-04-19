package Characters;
import Items.*;

/**
 * Created by peter on 2/14/17.
 */
public class Hero extends Player {
    private Item[] inventory;
    private int x = (int) (10+ Math.random() * (500));
    private int y = (int) (10 + Math.random() * (120));
    private int c = (int) (10  + Math.random() * (120));
    private Item[] mageOptions = {new DamagePotion(x), new HealPotion(y), new ManaPotion(c), Empty.empty};
    private Item[] regOptions = {new DamagePotion(x), new HealPotion(y), Empty.empty};

    public Item[] getMageOptions() {
        return mageOptions;
    }

    public Item[] getRegOptions() {
        return regOptions;
    }



    public void setInventory(int inventorySize) {
        for (int i = 0; i < inventorySize; i ++){
            this.inventory[i] = Empty.empty;
        }
    }
    /**
     * constructor
     */
    public Hero(String name, int maxDamage, int minDamage, int inventorySize, int maxHealth) {
        super(name, maxHealth, maxDamage, minDamage);
        this.inventory = new Item[inventorySize];
        setInventory(inventorySize);
    }

    public void useItem(int itemIndex) {

        inventory[itemIndex].apply(this);
        inventory[itemIndex] =  Empty.empty;
    }

    public Item accessInventory(int itemIndex){
        Item revealed = inventory[itemIndex];
        return revealed;
    }

    public void showInventory() {

        for(int i = 0; i < inventory.length; i ++) {
            System.out.print(i + ". " + inventory[i].toString() + "\n" );
        }
    }
    /**
    * accepts the true possition in the array(non-zero based) and the item
    * */
    public void addToInventory(Item item, int itemIndex){
        inventory[itemIndex] = item;
        System.out.println(item.toString() + " is in position " + itemIndex);
    }

    public void addToInventory(Item item) {

        for (int i = 0; i < inventory.length; i++) {
             //note to self, figure out a way to make this program  RETURN the strings
            if (inventory[i] == Empty.empty) {
                inventory[i] = item;
                System.out.println(item + " is in position " + i);
                break;
            }
            else {
               System.out.println("Your inventory is full");
            }
        }

    }

    /*public void randomizeItemPower() {
        this.x = (int) (Math.random() * (500 - 10) + 500);
        this.y = (int) (10 + Math.random() * (120));
        this.c = (int) (10  + Math.random() * (120));

    }
    */
}
