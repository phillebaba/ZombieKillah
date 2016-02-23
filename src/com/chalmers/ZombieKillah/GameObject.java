package com.chalmers.ZombieKillah;

import com.sun.deploy.ui.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Philip Laine on 20/02/16.
 */
public class GameObject {

    private BufferedImage image;

public GameObject(String path){
        try {
            image = ImageIO.read(ImageLoader.class.getResource(path));
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


}






}
