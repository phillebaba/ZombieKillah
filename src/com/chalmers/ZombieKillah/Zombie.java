package com.chalmers.ZombieKillah;

import java.awt.geom.Rectangle2D;

/**
 * Class which represents the AI enemies in the game
 * and includes a very simple pathfinding algorithm.
 * Will always move in the direction of the player and
 * try to collide with the player
 * @author Jesper Rask
 * @version 1.0.0 20/02/16
 */
public class Zombie extends Character {

    /**
     * Simple constructor which create a
     * zombie at a given position
     * @param x Start position x coordinate
     * @param y Start position y coordinate
     */
    public Zombie(double x, double y){
        super("Zombie", x, y);
        this.speed = 0.1;

        addWeapon(new Hand());
    }

    /**
     * Will calculate a new direction for the Zombie to turn
     * to given the destination and will call for the Zombie
     * to step forward
     * @param destination The destination rectangle which the Zombie wants to go to
     */
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

    /**
     * Overrides on collision method to detect if collision has occured
     * with a bullet, so that the Zombie responds to health damage when
     * hit in a bullet
     * @param object This is the object which has been collided with
     */
    @Override
    public void onCollision(GameObject object) {
        super.onCollision(object);

        if (object instanceof Bullet) {
            Bullet bullet = (Bullet)object;
            takeDamage(bullet.getDamage());

            if (health <= 0) {
                Stats.getInstance().addKill();
                kill();
            }
        }
    }
}