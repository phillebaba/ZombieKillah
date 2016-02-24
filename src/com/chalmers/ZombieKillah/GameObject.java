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
    protected boolean collidable, isVisable;
    protected int posX, posY;

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

     public GameObject(String path, int posX, int posY, boolean isVisable) {
         this.direction = Direction.NORTH;
         this.collidable = true;
         this.posX = posX;
         this.posY = posY;
         this.isVisable = isVisable;

         try {
             this.image = ImageIO.read(new File(path));
         } catch(IOException e){
             e.printStackTrace();
             System.exit(1);
         }

         this.frame = new Rectangle2D.Double(posX, posY, image.getWidth(), image.getHeight());
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
}
