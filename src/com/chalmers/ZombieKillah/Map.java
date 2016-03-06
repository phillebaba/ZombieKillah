package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Helping class to generate a new map by linking
 * colors with GameObject types, requires implementation of
 * a specific constructor to work, will otherwise exit.
 * @author Jesper Rask
 * @author Daniel Posch
 * @author Philip Laine
 * @version 1.0.0 26/02/16
 */
public class Map {
    private HashMap<Color, Class>  classMap;
    private BufferedImage mapImage;

    /**
     * Will load the map image from the image path
     * and instantiate the classMap
     * @param path The image path for the map
     */
    public Map(String path) {
        try {
            this.mapImage = ImageIO.read(new File(path + ".png"));
        } catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        this.classMap = new HashMap<>();
    }

    /**
     * Will add a Color and Class pair to the classMap, requires
     * the Class to be a subclass of GameObject
     * @param color Color to be used as the key
     * @param instanceClass Class The class to be used as the object
     */
    public void registerColorForClass(Color color, Class instanceClass){
        if (GameObject.class.isAssignableFrom(instanceClass)) {
            classMap.put(color, instanceClass);
        }
    }

    /**
     * Will iterate through all of the pixels in an image, and try
     * to convert the Color of the pixel to a class. Will then try to
     * create an instance of the given class at the translated pixel location
     * @return The list of created GameObjects to be added to the game
     */
    public ArrayList<GameObject> getObjects() {
        ArrayList<GameObject> objects = new ArrayList<>();

        for (int y = 0; y < Controller.getHeight(); y++) {
            for (int x = 0; x < Controller.getWidth(); x++) {
                Color color = new Color(mapImage.getRGB(x, y));
                if (color != Color.white && classMap.containsKey(color)) {
                    try {
                        Constructor constructor = classMap.get(color).getConstructor(double.class, double.class);
                        objects.add(((GameObject) constructor.newInstance(x * Controller.getGridDimension(), y * Controller.getGridDimension())));
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            }
        }
        return objects;
    }
}
