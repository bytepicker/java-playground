package com.test.automation;

import java.util.AbstractMap;
import java.util.concurrent.ThreadLocalRandom;

public class Basilisk extends AbstractCreature {
    Basilisk(int xCoordinate) {
        super(xCoordinate);
        this.health = 35;
        this.speed = 5;
        this.defence = 11;
        this.attackRange = 2;
        this.damage = new AbstractMap.SimpleEntry<>(6, 10);
    }

    @Override
    public void Attack() {
        int damageValue = ThreadLocalRandom.current().nextInt(this.damage.getKey(), this.damage.getValue() + 1);
        System.out.println(this.getClass().getSimpleName() + " bites " + this.getCurrentEnemy().getClass().getSimpleName());
        this.getCurrentEnemy().Defend(damageValue);
    }

    @Override
    public void UseMagic() {
        System.out.println(this.getClass().getSimpleName() + " casts magic spell and increases defence by 3 points");
        this.defence += 3;
    }
}
