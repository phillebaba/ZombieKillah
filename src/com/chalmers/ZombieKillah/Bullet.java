package com.chalmers.ZombieKillah;

/**
 * Class that make a projectile object extends MovableOject
 * Removes itself if it intersects with an other
 * object.
 * @author Jesper Rask
 * @version 1.0.0 24/02/16
 */
public class Bullet extends MovableObject {
    private double damage;

    /**
     * Initializes a new object who represents a bullet
     * @param damage
     * @param direction
     * @param x
     * @param y
     */
    public Bullet(double damage, Direction direction, double x, double y){
        super("Bullet", x, y);
        this.speed = 8;
        this.damage = damage;
        this.direction = direction;
        this.respondable = false;
    }

    /**
     * Checks so it doesn't collide with itself or the player object if its another
     * object it removes itself and calls for the kill method
     * @param object This is the object which has been collided with
     */
    @Override
    public void onCollision(GameObject object) {
        super.onCollision(object);

        if (object instanceof Player == false && object instanceof Bullet == false) {
            kill();
        }
    }

    public double getDamage() {
        return damage;
    }
}
