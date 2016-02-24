package com.chalmers.ZombieKillah;

import java.awt.geom.Rectangle2D;

/**
 * Created by Jesper Rask on 20/02/16.
 */
public class Zombie extends Character {

    public Zombie(double x, double y){
        super("Zombie", x, y);
        this.speed = 0.2;
    }

    public void move(Rectangle2D.Double destination){
        double angle = Math.toDegrees(Math.atan2(destination.getX() - frame.getX(), destination.getY() - frame.getY()));
        angle = angle + Math.ceil( -angle / 360 ) * 360;
        if(angle >= 337.5 && angle < 22.5) {
           direction = Direction.WEST;
        } else if(angle >= 22.5 && angle < 66.5) {
            direction = Direction.NORTHEAST;
        } else if(angle >= 66.5 && angle < 112.5) {
            direction = Direction.NORTH;
        } else if(angle >= 112.5 && angle < 157.5) {
            direction = Direction.NORTHWEST;
        } else if(angle >= 157.5 && angle < 202.5) {
            direction = Direction.WEST;
        } else if(angle >= 202.5 && angle < 247.5) {
            direction = Direction.SOUTHWEST;
        } else if(angle >= 247.5 && angle < 292.5) {
            direction = Direction.SOUTH;
        } else if (angle >= 292.5 && angle < 337.5) {
            direction = Direction.SOUTHEAST;
        }
        
        super.step();
    }
}