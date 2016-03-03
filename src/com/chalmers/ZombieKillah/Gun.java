package com.chalmers.ZombieKillah;

import java.awt.geom.Point2D;

/**
 * Created by Philip Laine on 02/03/16.
 */
public class Gun extends Weapon {
    public Gun() {
        super(0.5, 40);
    }

    public Bullet shoot(GameObject.Direction direction, Point2D.Double origin) throws Exception {
        if (isUsable()) {
            Bullet bullet = new Bullet(use(), direction, origin.getX(), origin.getY());
            return bullet;
        }

        throw new Exception("Gun cant fire");
    }
}
