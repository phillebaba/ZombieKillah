package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jesper Rask on 2016-02-26.
 */
public class Map {
    private HashMap<Color, Class>  classMap;
    private BufferedImage mapImage;
    private int height;
    private int width;

    public Map(String path){
        try {
            this.mapImage = ImageIO.read(new File(path + ".png"));
        } catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        this.height = mapImage.getHeight();
        this.width = mapImage.getWidth();
        this.classMap = new HashMap<Color, Class>();
    }

    public void registerColorForClass(Color color, Class instanceClass){
        classMap.put(color, instanceClass);
    }

    public ArrayList<GameObject> getObjects() {
        ArrayList<GameObject> objects = new ArrayList<>();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = new Color(mapImage.getRGB(x, y));
                if (color != Color.white && classMap.containsKey(color)) {
                    //try {
                        objects.add(new Wall(x*Controller.getGridDimension(), y*Controller.getGridDimension()));
                        //objects.add((GameObject) classMap.get(color).newInstance());
                    /*} catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                        System.exit(1);
                    }*/
                }
            }
         }

        return objects;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
