package com.chalmers.ZombieKillah;

import java.awt.event.*;
import javax.swing.*;


/**
 * Created by Sebastian Lind on 2016-02-23.
 */
public abstract class Weapon {
    private Timer timer;
    private boolean usable;
    private double damage;
    private double coolDownTime;

    public Weapon (double coolDownTime, double damage){
        this.usable = true;
        this.coolDownTime = coolDownTime;
        this.damage = damage;

        ActionListener actionListener = e -> {
            usable = true;
            timer.stop();
        };
        this.timer = new Timer((int)(coolDownTime * 1000), actionListener);
    }

    protected double use() {
        if (usable) {
            usable = false;
            timer.start();
            return damage;
        }

        return 0;
    }

    public boolean isUsable() {
        return usable;
    }
}
