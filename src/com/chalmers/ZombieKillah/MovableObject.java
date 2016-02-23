package com.chalmers.ZombieKillah;


/**
 * Created by Philip Laine on 20/02/16.
 */
public class MovableObject extends GameObject {
    protected float speed;

    public MovableObject (String path, int x, int y) {
        super(path, x, y);
        this.speed = 100;
    }

    protected void step(){

    }
}
