package com.chalmers.ZombieKillah;

import java.awt.geom.Point2D;
import java.awt.event.*;
import javax.swing.*;


/**
 * Created by Sebastian Lind on 2016-02-23.
 */
public abstract class Weapon {
    private boolean canFire;
    private Timer timer;
    protected double coolDownTime;

    public Weapon (double coolDownTime){
        this.canFire = true;
        this.coolDownTime = coolDownTime;

        ActionListener actionListener = e -> {
            canFire = true;
            timer.stop();
        };
        this.timer = new Timer((int)(coolDownTime * 1000), actionListener);
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
