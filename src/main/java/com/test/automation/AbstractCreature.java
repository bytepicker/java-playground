package com.test.automation;

import java.util.AbstractMap;

public abstract class AbstractCreature implements CreatureActions {
    AbstractCreature(int xCoordinate) {
        this.alive = true;
        this.xCoordinate = xCoordinate;
    }

    protected int health;
    protected int speed; // actually a single turn walk distance
    protected int defence;
    protected int attackRange;
    protected AbstractMap.SimpleEntry<Integer, Integer> damage;

    // service fields
    protected int xCoordinate;
    private boolean alive;
    private AbstractCreature currentEnemy;

    public void setCurrentEnemy(AbstractCreature currentEnemy) {
        this.currentEnemy = currentEnemy;
        System.out.println(this.getClass().getSimpleName() + " sees " + currentEnemy.getClass().getSimpleName());
    }

    public AbstractCreature getCurrentEnemy() {
        return currentEnemy;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean canReachEnemy() {
        boolean enemyLocationIsReachable = false;
        if (this.xCoordinate < currentEnemy.xCoordinate) {
            enemyLocationIsReachable = (this.xCoordinate + this.attackRange >= currentEnemy.xCoordinate);
        }
        if (this.xCoordinate > currentEnemy.xCoordinate) {
            enemyLocationIsReachable = (this.xCoordinate - this.attackRange <= currentEnemy.xCoordinate);
        }
        return enemyLocationIsReachable;
    }

    @Override
    public void defend(int attackPoints) {
        if (attackPoints >= this.defence) {
            this.defence = 0;
            this.health -= (attackPoints - this.defence);
        } else {
            this.defence -= attackPoints;
        }
        System.out.println(this.getClass().getSimpleName() + " gets " + attackPoints + " damage");
        System.out.println(" --- ");

        if (this.health <= 0) {
            this.die();
        }
    }

    @Override
    public void approachEnemy() {
        this.move(currentEnemy.xCoordinate);
    }

    @Override
    public void move(int xCoordinate) {
        this.xCoordinate += this.xCoordinate < currentEnemy.xCoordinate ? this.speed : -this.speed;
        System.out.println(this.getClass().getSimpleName() + " moves towards " + getCurrentEnemy().getClass().getSimpleName());
    }

    @Override
    public void die() {
        this.alive = false;
        System.out.println(this.getClass().getSimpleName() + " dies");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "health=" + health +
                ", speed=" + speed +
                ", defence=" + defence +
                ", attackRange=" + attackRange +
                ", damage=" + damage +
                ", xCoordinate=" + xCoordinate +
                '}';
    }
}