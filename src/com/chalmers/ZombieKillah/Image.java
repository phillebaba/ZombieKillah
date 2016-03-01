package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jeppe on 2016-03-01.
 */


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


    public BufferedImage getImage(String path) {
        try {
            return ImageIO.read(new File(path + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}