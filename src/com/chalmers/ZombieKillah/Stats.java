package com.chalmers.ZombieKillah;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Philip Laine on 02/03/16.
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

    private Stats(){
        ActionListener actionListener = e -> {
            time++;
        };
        this.timer = new Timer(1000, actionListener);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

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
