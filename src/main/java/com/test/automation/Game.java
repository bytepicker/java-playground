package com.test.automation;

import java.util.*;

public class Game {
    private Basilisk basilisk;
    private GreaterBasilisk greaterBasilisk;

    public boolean battleIsNotOver() {
        return basilisk.isAlive() && greaterBasilisk.isAlive();
    }

    public boolean enemiesAreCloseEnough() {
        return basilisk.canReachEnemy() || greaterBasilisk.canReachEnemy();
    }

    public boolean flipCoin() {
        return (new Random().nextInt(51) > 25);
    }

    public void action() {
        System.out.println("===== Game starts =====");
        basilisk = new Basilisk(0);
        greaterBasilisk = new GreaterBasilisk(25);

        basilisk.setCurrentEnemy(greaterBasilisk);
        greaterBasilisk.setCurrentEnemy(basilisk);

        while (!enemiesAreCloseEnough()) {
            if (flipCoin()) {
                basilisk.FindEnemy();
            } else {
                greaterBasilisk.FindEnemy();
            }
        }

        System.out.println("===== Battle begins! =====");
        while (battleIsNotOver()) {
            if (flipCoin()) {
                if (flipCoin()) {
                    basilisk.Attack();
                } else {
                    basilisk.UseMagic();
                }
            } else {
                if (flipCoin()) {
                    greaterBasilisk.Attack();
                } else {
                    greaterBasilisk.UseMagic();
                }
            }
        }

        System.out.println(basilisk.isAlive() ? "Basilisk wins!" : "Great Basilisk wins!");
        System.out.println("===== Battle ended =====");
    }
}