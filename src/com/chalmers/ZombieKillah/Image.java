package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Adds an image to the incoming object, with different images depending on which direction
 * the object is pointing at
 * Created 01/03/16
 * @author Daniel Posch
 * @author Jesper Rask
 * @author Sebastian Lind
 * @author Philip Laine
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
        this.south = loadImage(path + "-South" + ".png");
        this.north = loadImage(path + "-North" + ".png");
        this.west = loadImage(path + "-West" + ".png");
        this.east = loadImage(path + "-East" + ".png");

        currentImage = north;
    }

    /**
     * Gets an image from the selected path
     * @param path Gets the search path of the image
     * @return Returns the image if the search path is correct, returns null if it isn't.
     */
    private BufferedImage loadImage(String path)  {
        try {
            return ImageIO.read(getClass().getClassLoader().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    /**
     * Updates the image if depending on the direction
     * @param direction
     */
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