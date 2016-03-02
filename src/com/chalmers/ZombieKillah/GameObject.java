package com.chalmers.ZombieKillah;

import javax.swing.*;
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
    protected Image images;
    protected JLabel scoreBoardLabel;
    protected int killed;

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
        killed = 0;
        scoreBoardLabel = new JLabel("" + killed, SwingConstants.NORTH_EAST);



        this.frame = new Rectangle2D.Double(x, y, 20, 20);
    }

    public void onCollision(GameObject object) {

    }

    public final void takeDamage(float damage) {
        if (!indestructable && damage > 0) {
            health -= damage;
        }
    }

    protected void kill() {
        allive = false;
        respondable = false;
        visible = false;
        collidable = false;
        health = 0;
        killed++;
        score();
    }

    public void score() {
        scoreBoardLabel.setText(String.valueOf(killed));
        scoreBoardLabel.setVisible(true);
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
