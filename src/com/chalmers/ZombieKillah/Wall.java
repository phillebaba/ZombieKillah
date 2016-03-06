package com.chalmers.ZombieKillah;

/**
 * Reprensent the wall which is used to keep the
 * player and other movable objects within the bounds
 * of the playing area. Or to be used and obstacles within the
 * map
 * @author Sebastian Lind
 * @version 1.0.0 2016-02-24
 */
public class Wall extends GameObject {
    public Wall (double x, double y){
        super("Wall", x, y);
        indestructable = true;
    }
}
