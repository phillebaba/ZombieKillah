package com.chalmers.ZombieKillah;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Philip Laine on 20/02/16.
 */
public class Character extends MovableObject {

    protected float health;
    /*
    protected hashMap<weapon> weapons;
    protected Weapon currentWeapon;

    weaponHashmap = new hashMap<weapn> weapns;

    */

    public Character(Direction direction, int position, boolean collideable, Image image, float speed,
                                float health )/*,Weapon currentWeapon)*/{
        super(direction, position, collideable, image, speed);
        this.health = health;

    }
    /*
    public void takeDamage(Weapon weapon){
        this.health = this.health - weapon.damage;
    }
    */
    public void changeWeapon(int weaponPosition){

    }
}
