package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Adds an image to the incoming object, with different images depending on which direction
 * the object is pointing at
 * Created 01/03/16
 * @author Daniel Posch, Jesper Rask, Sebastian Lind, Philip Laine
 * @version 1.0.0 01/03/16
 */
public class Image {
    private BufferedImage north;
    private BufferedImage south;
    private BufferedImage west;
    private BufferedImage east;
    private BufferedImage currentImage;

    /**
     * Adds an image to the incoming object, with different images depending on which direction
     * the object is pointing at
     * @param path Gets the right image depending on what object is used
     */
    public Image(String path) {
        this.south = loadImage(path + "-south" + ".png");
        this.north = loadImage(path + "-north" + ".png");
        this.west = loadImage(path + "-west" + ".png");
        this.east = loadImage(path + "-east" + ".png");

        currentImage = north;
    }

    private BufferedImage loadImage(String path)  {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    public void updateImage(GameObject.Direction direction) {
        switch (direction) {
            case NORTH:
                currentImage = north;
                break;

            case SOUTH:
                currentImage = south;
                break;

            case WEST:
                currentImage = west;
                break;

            case EAST:
                currentImage = east;
                break;
        }
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }
}