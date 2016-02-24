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
        angle += 22.5;

        System.out.println(angle);
        if(angle >= 0 && angle < 45) {
           direction = Direction.SOUTH;
        } else if(angle >= 45 && angle < 90) {
            direction = Direction.SOUTHEAST;
        } else if(angle >= 90 && angle < 135) {
            direction = Direction.EAST;
        } else if(angle >= 135 && angle < 180) {
            direction = Direction.NORTHEAST;
        } else if(angle >= 180 && angle < 225) {
            direction = Direction.NORTH;
        } else if(angle >= 225 && angle < 270) {
            direction = Direction.NORTHWEST;
        } else if(angle >= 270 && angle < 315) {
            direction = Direction.WEST;
        } else if (angle >= 315 && angle < 360) {
            direction = Direction.SOUTHWEST;
        }
        
        super.step();
    }
}