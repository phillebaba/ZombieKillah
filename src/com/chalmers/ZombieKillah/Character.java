package com.chalmers.ZombieKillah;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class Character extends MovableObject {
    protected float health;
    /*
    protected hashMap<weapon> weapons;
    protected Weapon currentWeapon;

    weaponHashmap = new hashMap<weapn> weapns;

    */

    public Character(String path, int x, int y)/*,Weapon currentWeapon)*/{
        super(path, x, y);
        this.health = 100;
    }

    /*
    public void takeDamage(Weapon weapon){
        this.health = this.health - weapon.damage;
    }
    */

    public void changeWeapon(int weaponPosition){

    }
}
