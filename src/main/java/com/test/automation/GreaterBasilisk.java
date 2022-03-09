package com.test.automation;

import java.util.AbstractMap;

public class GreaterBasilisk extends Basilisk {
    GreaterBasilisk(int xCoordinate) {
        super(xCoordinate);
        this.health = 40;
        this.speed = 7;
        this.defence = 12;
        this.attackRange = 2;
        this.damage = new AbstractMap.SimpleEntry<>(6, 10);
    }

    @Override
    public void UseMagic() {
        System.out.println(this.getClass().getSimpleName() + " casts  magic spell and increases health by 5 points");
        this.health += 5;
    }
}
