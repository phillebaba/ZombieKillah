package com.chalmers.ZombieKillah;

import java.awt.geom.Rectangle2D;

/**
 * Created by Jesper Rask on 20/02/16.
 */
public class Zombie extends Character {

    public Zombie(double x, double y){
        super("Zombie", x, y);
        this.speed = 0.1;
    }

    public void move(Rectangle2D.Double destination){
        double angle = Math.toDegrees(Math.atan2(destination.getCenterX() - frame.getCenterX(), destination.getCenterY() - frame.getCenterY()));
        angle = angle + Math.ceil(-angle / 360) * 360;
        angle += 22.5;

        if(angle >= 0 && angle < 90) {
           direction = Direction.SOUTH;
        } else if(angle >= 90 && angle < 180) {
            direction = Direction.EAST;
        } else if(angle >= 180 && angle < 270) {
            direction = Direction.NORTH;
        } else if(angle >= 270 && angle < 360) {
            direction = Direction.WEST;
        }
        
        super.step();
    }

}