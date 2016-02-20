package com.chalmers.ZombieKillah;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Philip Laine on 20/02/16.
 */
public class GameObject {
    protected Direction direction;
    protected int position;
    protected boolean collideable;
    protected Image image;


     public GameObject(Direction direction, int position, boolean collideable, Image image){

        this.direction = direction;
        this.position = position;
        this.collideable = collideable;
        this.image = image;

    }

    enum Direction
    {
        EAST,
        WEST,
        NORTH,
        NORTHWEST,
        NORTHEAST,
        SOUTH,
        SOUTHWEST,
        SOUTHEAST
    }

}
