package com.chalmers.ZombieKillah;

import java.awt.geom.Rectangle2D;

/**
 * Creates a game object for the game, this object is supposed to check if the object collides with anything,
 * and removes health if isn't indestructable.
 * Created 20/02/16
 * @author Philip Laine
 * @author Sebastian Lind
 * @author Daniel Posch
 * @Version 1.0.0 20/02/16
 */
public abstract class GameObject {
    private boolean alive;
    protected Image image;
    protected Rectangle2D.Double frame;
    protected Direction direction;
    protected boolean collidable, respondable, visible, indestructable;
    protected float health;

    enum Direction {
        EAST,
        WEST,
        NORTH,
        SOUTH,
    }

    /**
     *
     * @param path
     * @param x
     * @param y
     */

    public GameObject(String path, double x, double y) {
        this.alive = true;
        this.image = new Image(path);
        this.direction = Direction.NORTH;
        this.collidable = true;
        this.respondable = true;
        this.visible = true;
        this.indestructable = false;

        this.frame = new Rectangle2D.Double(x, y, AbstractController.getGridDimension(), AbstractController.getGridDimension());
    }

    /**
     * This method is meant to be overriden by subclasses so that they cant
     * detect and implement logic for collisions events with other objects.
     * Will only be called if both objects are collidable.
     * @param object This is the object which has been collided with
     */
    public void onCollision(GameObject object) {

    }

    /**
     *  This method is used to remove health from this objects.
     * @param damage This is the amount of damage to be taken by the GameObject
     */
    public final void takeDamage(double damage) {
        if (!indestructable && damage > 0 && health > 0) {
            health -= damage;
        }
    }

    /**
     * This method is used to remove the GameObject from the game
     * when it is deemed to be dead. Will hide and no collide the object
     * until the next update loop where it will be removed from any reference.
     */
    public final void kill() {
        alive = false;
        respondable = false;
        visible = false;
        collidable = false;
        health = 0;
    }

    public boolean isAlive() {
        return alive;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle2D.Double getFrame() {
        return frame;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean getIndestrutable() {
        return indestructable;
    }
}
