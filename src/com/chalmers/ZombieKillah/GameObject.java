package com.chalmers.ZombieKillah;

import java.awt.geom.Rectangle2D;

/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class GameObject {
    private boolean allive;
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

    public GameObject(String path, double x, double y) {
        this.allive = true;
        this.image = new Image(path);
        this.direction = Direction.NORTH;
        this.collidable = true;
        this.respondable = false;
        this.visible = true;
        this.indestructable = false;

        this.frame = new Rectangle2D.Double(x, y, Controller.getGridDimension(), Controller.getGridDimension());
    }

    public void onCollision(GameObject object) {

    }

    public final void takeDamage(float damage) {
        if (!indestructable && damage > 0) {
            health -= damage;
        }
    }

    public final void kill() {
        allive = false;
        respondable = false;
        visible = false;
        collidable = false;
        health = 0;
    }

    public boolean isAllive() {
        return allive;
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
