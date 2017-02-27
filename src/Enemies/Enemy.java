package Enemies;

import Characters.Player;

/**
 * Created by peter on 2/25/17.
 */
public class Enemy extends Player {
    public Enemy(String name, int maxHealth, int maxDamage, int minDamage) {
        super(name, maxHealth, maxDamage, minDamage);
    }
}
