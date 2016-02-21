package com.chalmers.ZombieKillah;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Philip Laine on 20/02/16.
 */
public class MovableObject extends GameObject {
    protected float speed;

    public MovableObject (Direction direction, int position, boolean collideable, Image image, float speed){
            super(direction, position, collideable, image);
            this.speed = speed;
    }


    protected void step(){




    }
}
