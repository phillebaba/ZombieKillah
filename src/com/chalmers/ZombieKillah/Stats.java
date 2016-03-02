package com.chalmers.ZombieKillah;

/**
 * Created by Philip Laine on 02/03/16.
 */
public class Stats {
    private static Stats stats = new Stats();
    private int kills;
    private int time;
    private int shots;

    private Stats(){
    }

    public static Stats getInstance( ) {
        return stats;
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
