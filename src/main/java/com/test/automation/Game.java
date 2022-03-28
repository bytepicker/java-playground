package com.test.automation;

import java.util.*;

public class Game {
    private Lizardman lizardman;
    private Basilisk basilisk;

    public boolean battleIsNotOver() {
        return basilisk.isAlive() && lizardman.isAlive();
    }

    public boolean atLeastOneCanAttack() {
        return basilisk.canReachEnemy() || lizardman.canReachEnemy();
    }

    public boolean flipCoin() {
        return (new Random().nextInt(51) > 25);
    }

    public void action() {
        System.out.println("===== Game starts =====");
        basilisk = new Basilisk(0);
        lizardman = new Lizardman(25);

        basilisk.setCurrentEnemy(lizardman);
        lizardman.setCurrentEnemy(basilisk);

        while (!atLeastOneCanAttack()) {
            if (flipCoin()) {
                basilisk.approachEnemy();
            } else {
                lizardman.approachEnemy();
            }
        }

        System.out.println("===== Battle begins! =====");
        while (battleIsNotOver()) {
            if (flipCoin()) {
                if (!basilisk.canReachEnemy()) {
                    basilisk.approachEnemy();
                } else {
                    if (flipCoin()) {
                        basilisk.attack();
                    } else {
                        basilisk.useMagic();
                    }
                }
            } else {
                if (!lizardman.canReachEnemy()) {
                    lizardman.approachEnemy();
                } else {
                    if (flipCoin()) {
                        lizardman.attack();
                    } else {
                        lizardman.useMagic();
                    }
                }
            }
        }

        System.out.println(basilisk.isAlive() ? "Basilisk wins!" : "Lizardman wins!");
        System.out.println("===== Battle ended =====");
    }
}