package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class GameObject {
    protected BufferedImage image;
    protected Rectangle2D.Double frame;
    protected Direction direction;
    protected boolean collidable, visible;

    enum Direction {
        EAST,
        WEST,
        NORTH,
        NORTHWEST,
        NORTHEAST,
        SOUTH,
        SOUTHWEST,
        SOUTHEAST
    }

     public GameObject(String path, double x, double y) {
         this.direction = Direction.NORTH;
         this.collidable = true;
         this.visible = true;

         try {
             this.image = ImageIO.read(new File(path + ".png"));
         } catch(IOException e){
             e.printStackTrace();
             //System.exit(1);
         }

         this.frame = new Rectangle2D.Double(x, y, image.getWidth(), image.getHeight());
     }

    public BufferedImage getImage() {
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
}
