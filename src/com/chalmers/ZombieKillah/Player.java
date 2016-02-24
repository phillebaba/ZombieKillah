package com.chalmers.ZombieKillah;

/**
 * Created by Philip Laine on 20/02/24.
 */
public class Player extends Character {

    public Player(double x, double y) {
        super("Player", x, y);
    }

    public void turn(Direction direction) {
        this.direction = direction;
        super.step();
    }
}
