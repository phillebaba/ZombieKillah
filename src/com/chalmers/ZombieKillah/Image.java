package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jeppe on 2016-03-01.
 */
public class Image {

    private BufferedImage NORTH;
    private BufferedImage SOUTH;
    private BufferedImage WEST;
    private BufferedImage EAST;

    public Image(String path){


    }






    public BufferedImage getImage(String path) {

        try {
            this.image = ImageIO.read(new File(path + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return image;
    }
}


