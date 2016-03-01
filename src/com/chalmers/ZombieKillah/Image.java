package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jesper Rask on 2016-03-01.
 */
<<<<<<< HEAD


public class Image {
    private BufferedImage PNORTH;
    private BufferedImage PSOUTH;
    private BufferedImage PWEST;
    private BufferedImage PEAST;
    private BufferedImage currentImage;

    public Image(String path) {
        PNORTH = getImage(path + "North");
        PSOUTH = getImage(path + "South");
        PEAST = getImage(path + "West");
        PWEST = getImage(path + "East");
    }

    public void uppdateImage(GameObject.Direction direction) {

        switch (direction) {
            case NORTH:
               currentImage = PNORTH;
                break;
            case SOUTH:
                currentImage = PSOUTH;
                break;
            case WEST:
                currentImage = PWEST;
                break;
            case EAST:
                currentImage = PEAST;
                break;

            default:
                currentImage = PNORTH;
                break;
        }
    }
=======
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
>>>>>>> 12a9aafa87146623013c14d01ef39f71d1e978d4

            case WEST:
                currentImage = west;
                break;

<<<<<<< HEAD
    public BufferedImage getImage(String path) {
        try {
            return ImageIO.read(new File(path + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
=======
            case EAST:
                currentImage = east;
                break;
        }
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
>>>>>>> 12a9aafa87146623013c14d01ef39f71d1e978d4
    }
}