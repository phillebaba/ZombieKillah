package com.chalmers.ZombieKillah;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Creates a HUD of how much health the player have left, how many zombies the player have killed
 *  and how much time have passed since the game started.
 *  @author Philip Laine
 *  @version 1.0.0
 *  Created 02/03/16.
 */
public class Stats {
    private static Stats stats = new Stats();
    private Timer timer;
    private int kills;
    private int time;
    private int shots;

    public static Stats getInstance( ) {
        return stats;
    }

    /**
     * Starts a timer that increase every second
     */
    private Stats(){
        ActionListener actionListener = e -> {
            time++;
        };
        this.timer = new Timer(1000, actionListener);
    }

    /**
     * Resets the values and starts the timer
     */
    public void reset() {
        timer.stop();

        time = 0;
        shots = 0;
        kills = 0;

        timer.start();
    }

    /**
     * Adds a kill at the kill parameter in the HUD
     */
    public void addKill() {
        kills++;
    }

    public void addShot() {
        shots++;
    }

    public int getKills() {
        return kills;
    }

    public int getTime() {
        return time;
    }

    public int getShots() {
        return shots;
    }
}
