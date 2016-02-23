package com.chalmers.ZombieKillah;

/**
 * Created by Philip Laine on 20/02/16.
 */
public class GameObject {
    private BufferedImage image;

    public GameObject(String path) {
        try {
            image = ImageIO.read(ImageLoader.class.getResource(path));
            catch(IOException e){
                e.printStackTrace();
                System.exit(1);
            }

        }
    }
}
