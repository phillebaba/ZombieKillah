package com.chalmers.ZombieKillah;

/**
 * Created by Sebastian Lind on 2016-02-23.
 */
public class Weapond extends GameObject {

    private int damage;

    public Weapond (String path, int posX, int posY, boolean isVisable){
        super(path, posX, posY, isVisable);
        this.collidable = false;
        this.damage = 50;
        this.isVisable = false;
    }

    public void equipWeapond(){
        this.isVisable = true;
    }

    public void unEquipdWeapond(){
        this.isVisable = false;
    }
}
