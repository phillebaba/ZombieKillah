package com.chalmers.ZombieKillah;

import java.awt.geom.Point2D;
import java.util.*;

/**
 * Created by Philip Laine on 20/02/16.
 */

/**
 * Creates a character object with health that can hold a weapon and change it.
 * Created 20/02/16
 * @author Philip Laine
 * @version 1.0.0 20/02/16
 */
public abstract class Character extends MovableObject {
    private ArrayList<Weapon> weapons;
    private Weapon currentWeapon;

    /**
     * Creates a constructor for a character object, which creates a character with
     * X and Y position and gives the character a image.
     * @param path x Gives the character object a location where its image file lies
     * @param x Gives the character object a X position
     * @param y x Gives the character object a Y position
     */
    public Character(String path, double x, double y) {
        super(path, x, y);
        this.health = 100;
        this.weapons = new ArrayList<Weapon>();
    }

    /**
     *  Adds the selected weapon to the character
     * @param weapon The selected weapon for the character
     */
    public void addWeapon(Weapon weapon) {
        if (weapons.size() < 9) {
            weapons.add(weapon);

            if (currentWeapon == null) {
                currentWeapon = weapon;
            }
        }
    }

    /**
     * Changes the weapon of the character on the selected position in the arrayList weapons
     * @param index The selected position in the arrayList
     */
    public void changeWeapon(int index) {
        if (index > 0 && index <= weapons.size()) {
            currentWeapon = weapons.get(index-1);
        }
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }
}
