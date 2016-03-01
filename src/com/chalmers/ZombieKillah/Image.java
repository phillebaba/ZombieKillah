package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jesper Rask on 2016-03-01.
 */

public class Image {
    private BufferedImage north;
    private BufferedImage south;
    private BufferedImage west;
    private BufferedImage east;
    private BufferedImage currentImage;

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