package com.chalmers.ZombieKillah;

import java.awt.event.*;
import javax.swing.*;

/**
 * Is meant to encapsulate the use of all objects
 * which can damage other GameObjects, comes with
 * the needed cooldown so that instant kills dont
 * happen by misstake
 * @author Philip Laine
 * @version 1.0.2 6/3/16
 */
public abstract class Weapon {
    private Timer timer;
    private boolean usable;
    private double damage;
    private double coolDownTime;

    /**
     * Create a Weapon with a give ooldown time and damage
     * factor
     * @param coolDownTime The cooldown time in seconds
     * @param damage The damage inflicted by the weapon
     */
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

    /**
     * Registers a use and starts
     * the cool down process, to wait
     * for the next use
     * @return The damage made by the use of this weapon
     */
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
