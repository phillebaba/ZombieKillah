package com.chalmers.ZombieKillah;

/**
 * Represent a player object which is a sub class to @Character
 *
 * @author  Philip Laine
 * @author  Sebastian Lind
 * @version 1.0.0  20/02/16.
 */
public class Player extends Character {
    /**
     * Initializes a new player object, adds a new gun to weapon ArrayList
     * @param x
     * @param y
     */
    public Player(double x, double y) {
        super("Player", x, y);
        this.speed = 2;

        addWeapon(new Gun());
    }

    /**Changes the direction of the player or
     *  calls for the @step method.
     * @param direction
     */
    public void turn(Direction direction) {
        if (this.direction == direction) {
            super.step();
        } else {
            this.direction = direction;
        }
    }

    /**
     * Checks for Collision if this object collides with an object of type
     * zombie we call for the @takeDamage
     * @param object This is the object which has been collided with
     */
    @Override
    public void onCollision(GameObject object) {
        super.onCollision(object);

        if (object instanceof Zombie) {
            takeDamage(((Zombie) object).getCurrentWeapon().use());
        }
    }
}
