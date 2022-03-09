package com.test.automation;

public interface CreatureActions {
    void Attack();

    void Defend(int attackPoints);

    void FindEnemy();

    void Move(int xCoordinate);

    void UseMagic();

    void Die();
}
