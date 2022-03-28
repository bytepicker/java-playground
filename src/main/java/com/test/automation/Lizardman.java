package com.test.automation;

import java.util.AbstractMap;
import java.util.concurrent.ThreadLocalRandom;

public class Lizardman extends AbstractCreature {
    Lizardman(int xCoordinate) {
        super(xCoordinate);
        this.health = 14;
        this.speed = 4;
        this.defence = 6;
        this.attackRange = 10;
        this.damage = new AbstractMap.SimpleEntry<>(2, 3);
    }

    @Override
    public void attack() {
        int damageValue = ThreadLocalRandom.current().nextInt(this.damage.getKey(), this.damage.getValue() + 1);
        System.out.println(this.getClass().getSimpleName() + " shoots an arrow at " + this.getCurrentEnemy().getClass().getSimpleName());
        this.getCurrentEnemy().defend(damageValue);
    }

    @Override
    public void useMagic() {
        System.out.println(this.getClass().getSimpleName() + " casts magic spell and increases damage by 1 point");
        this.damage = new AbstractMap.SimpleEntry<>(this.damage.getKey() + 1, this.damage.getValue() + 1);
    }
}
