package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Jesper Rask on 2016-02-26.
 */

public class Map {

    private int height;
    private int width;
    private HashMap<Integer, Class>  map ;
    private BufferedImage image;


    public Map(String path){
        try {
            this.image = ImageIO.read(new File(path + ".png"));
        } catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        this.height = image.getHeight();
        this.width = image.getWidth();
        map = new HashMap<Integer, Class>();
    }



    public void registerClassForValueClass(Integer value,Class class){
        map.put(value,class);
    }

    public HashMap<Integer, Class> getObjects() {
        for(int y = 0;  y< height; y++){
            for(int x = 0; x < width; x++){
                    if (image.getRGB(x,y) != 0){
                        registerClassForValueClass(image.getRGB(x,y), Wall);
                    }
            }
         }
        return map;
    }



}
