package com.chalmers.ZombieKillah;

/**
 * Created by Sebastian Lind on 2016-02-23.
 */
public class Weapon extends GameObject {

    private int damage;

    public Weapon(String path, int posX, int posY){
        super(path, posX, posY);
        this.collidable = false;
        this.damage = 50;
    }
}
