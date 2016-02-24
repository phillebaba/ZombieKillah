package com.chalmers.ZombieKillah;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class Character extends MovableObject {
    protected float health;
    protected Weapon currentWeapon;
    protected ArrayList<Weapon> weapons;

    public Character(String path, double x, double y){
        super(path, x, y);
        this.health = 100;
        this.weapons = new ArrayList<Weapon>();
    }

    public void takeDamage(Weapon weapon){
        this.health -= weapon.getDamage();
    }

    public void changeWeapon(int weaponPosition){
        if(!(weaponPosition > weapons.size())){
            currentWeapon.unEquipWeapon();
            currentWeapon = weapons.get(weaponPosition);
            currentWeapon.equipWeapon();
        }
    }
}
