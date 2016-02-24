package com.chalmers.ZombieKillah;

import javax.imageio.ImageIO;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sebastian Lind on 2016-02-24.
 */
public class Wall extends GameObject {

    public Wall (double x, double y){
        super("Wall",x,y);
    }

}
