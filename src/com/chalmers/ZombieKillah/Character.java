package com.chalmers.ZombieKillah;

import java.awt.geom.Point2D;
import java.util.*;

/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class Character extends MovableObject {
    private ArrayList<Weapon> weapons;
    private Weapon currentWeapon;

    public Character(String path, double x, double y) {
        super(path, x, y);
        this.health = 100;
        this.weapons = new ArrayList<Weapon>();
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);

        if (currentWeapon == null) {
            currentWeapon = weapon;
        }
    }

    public Bullet shoot() throws Exception {
        return currentWeapon.getBullets(direction, new Point2D.Double(frame.getX(), frame.getY()));
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
}
