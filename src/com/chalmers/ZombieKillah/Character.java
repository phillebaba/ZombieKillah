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
        if (weapons.size() < 9) {
            weapons.add(weapon);

            if (currentWeapon == null) {
                currentWeapon = weapon;
            }
        }
    }

    public void changeWeapon(int index) {
        if (index > 0 && index <= weapons.size()) {
            currentWeapon = weapons.get(index-1);
        }
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
}
