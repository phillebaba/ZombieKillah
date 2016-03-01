package com.chalmers.ZombieKillah;

/**
 * Created by Jesper Rask on 2016-02-24.
 */
public class Bullet extends MovableObject {

    public Bullet(Direction direction, double x, double y){
        super("Bullet", x, y);
        this.speed = 10;
        this.direction = direction;
        this.respondable = false;
    }
}
