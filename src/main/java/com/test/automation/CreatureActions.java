package com.test.automation;

public interface CreatureActions {
    void attack();

    void defend(int attackPoints);

    void approachEnemy();

    void move(int xCoordinate);

    void useMagic();

    void die();
}
