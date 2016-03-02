package com.chalmers.ZombieKillah;

/**
 * Created by Sebastian Lind on 2016-02-24.
 */
public class Wall extends GameObject {

    public Wall (double x, double y){
        super("Wall", x, y);
        indestructable = true;
    }

}
