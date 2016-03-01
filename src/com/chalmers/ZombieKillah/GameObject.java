package com.chalmers.ZombieKillah;

import java.awt.geom.Rectangle2D;

/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class GameObject {
    protected Image image;
    protected Rectangle2D.Double frame;
    protected Direction direction;
    protected boolean collidable, respondable, visible;
    protected float health;
    protected boolean indestructable;
    protected Image images;

    enum Direction {
        EAST,
        WEST,
        NORTH,
        SOUTH,
    }

    public GameObject(String path, double x, double y) {
        this.image = new Image(path);
        this.direction = Direction.NORTH;
        this.collidable = true;
        this.respondable = false;
        this.visible = true;

        this.frame = new Rectangle2D.Double(x, y, 20, 20);
    }

    public float takeDamage(float damage) {
        if ((!this.getIndestrutable()) && (this.health - damage) > 0){
            this.health -= damage;
            return this.health;
        }
        return 0;
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
