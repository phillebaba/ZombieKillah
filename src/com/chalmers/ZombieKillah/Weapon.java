package com.chalmers.ZombieKillah;

import java.awt.geom.Point2D;
import java.awt.event.*;
import javax.swing.*;


/**
 * Created by Sebastian Lind on 2016-02-23.
 */
public class Weapon {
    private double cooldownTime;
    private boolean canFire;
    private Timer timer;

    public Weapon (){
        this.cooldownTime = 0.5;
        this.canFire = true;

        ActionListener actionListener = e -> {
            canFire = true;
            timer.stop();
        };
        this.timer = new Timer((int)(cooldownTime * 1000), actionListener);
    }

    public Bullet getBullets(GameObject.Direction direction, Point2D.Double origin) throws Exception {
        if (canFire) {
            canFire = false;
            timer.start();

            Bullet bullet = new Bullet(direction, origin.getX(), origin.getY());
            return bullet;
        }

        throw new Exception("Gun cant fire");
    }
}
