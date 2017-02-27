package Characters;
import Enemies.Dragon;
import Enemies.Enemy;
import Enemies.EvilGriffin;
import Enemies.Goblin;
import Items.*;

import java.util.Scanner;

/**
 * Created by peter on 2/13/17.
 */
public class Battle {
    private Hero hero;
    private Enemy enemy;
    private int selection;

    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.createCharacter();
        battle.loadInventory();
        battle.createMonster();
        battle.combat();
    }





    public void createCharacter() {
        Scanner console = new Scanner(System.in);
        System.out.print("Choose a name for your character: ");
        String name = console.nextLine();
        System.out.print("Choose a class for your character(1 for Warrior, 2 for Rogue, 3 for Mage): ");
        int selection = console.nextInt();
        if (selection == 1) {
            Warrior warrior = new Warrior(name);
            this.hero = warrior;
        } else if (selection == 2) {
            Mage mage = new Mage(name);
            this.hero = mage;
        } else if (selection == 3) {
            Rogue rogue = new Rogue(name);
            this.hero = rogue;
        }
    }

    public void createMonster() {
        Enemy[] enemies = {new Goblin(), new Dragon(), new EvilGriffin(), new Goblin(), new Goblin(), new Goblin(), new Goblin(), new EvilGriffin(), new EvilGriffin(), new EvilGriffin(), new Dragon()};
        this.enemy = enemies[(int) (Math.random() * (enemies.length - 0) + 0)];
        System.out.println(hero.getName() + " has enountered a " + enemy.getName());
    }

    public void combat() {
        int roundNum = 1;
        while (hero.getHealth() > 0 || enemy.getHealth()>0) {
            System.out.println("++++++++++++++++++++++++++++++++++++ ROUND " + roundNum + " ++++++++++++++++++++++++++++++++++++");
            if (itemSelection() == true) {
                System.out.println(hero.getName() + " used a " + hero.accessInventory(selection - 1) + "");
            }
            hero.attack(enemy);
            enemy.receiveDamage(hero.getDamageDealt());

            enemy.attack(hero);
            hero.receiveDamage(enemy.getDamageDealt());
            roundNum++;
        }
        if(hero.getHealth() > enemy.getHealth()){
            System.out.println(hero.getName()+ " wins!");
        }
        else { System.out.println(enemy.getName()+ " wins!"); }
    }

    public boolean itemSelection() {
        hero.showInventory();
        Scanner console = new Scanner(System.in);
        System.out.println("Type an inventory slot number to use an item, or type 0 to skip: ");
        this.selection = console.nextInt();
        if (selection == 1) {
            hero.useItem(0);
            return true;
        } else if (selection == 2) {
            hero.useItem(1);
            return true;
        } else if (selection == 3) {
            hero.useItem(2);
            return true;
        } else {
            return false;
        }
    }

    public void loadInventory() {
        hero.randomizeItemPower();
        Item[] mageOptions = hero.getMageOptions();
        Item[] regOptions = hero.getRegOptions();
        int randItem;
        if(hero.getClass().isAssignableFrom(Mage.class)) {
            for (int i = 0; i <= mageOptions.length; i++) {
                randItem = (int) (Math.random() * (mageOptions.length));
                hero.addToInventory(mageOptions[randItem], i);
            }
        }
        else{
            for (int i = 0; i <= regOptions.length; i ++) {
                randItem = (int) ((Math.random() * (regOptions.length)));
                hero.addToInventory(regOptions[randItem], i);
            }
        }
    }

}

