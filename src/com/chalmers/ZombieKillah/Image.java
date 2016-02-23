package com.chalmers.ZombieKillah;

import com.sun.deploy.ui.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Daniel on 2016-02-23.
 */
public class Image {

    public Image() {

    }

    public static BufferedImage imageLoader(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
}
