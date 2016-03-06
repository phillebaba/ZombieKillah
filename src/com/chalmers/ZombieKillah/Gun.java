package com.chalmers.ZombieKillah;

import java.awt.geom.Point2D;

/**
 * Sub class which represent the weapontype "gun".
 * @author Philip Laine
 * @version 1.0.0 20/02/16
 */
public class Gun extends Weapon {
    public Gun() {
        super(0.5, 40);
    }

    /**
     * fires the gun in a certain direction
     * @param direction, origin
     * @return bullet
     * @throws Exception
     */

    public Bullet shoot(GameObject.Direction direction, Point2D.Double origin) throws Exception {
        if (isUsable()) {
            Bullet bullet = new Bullet(use(), direction, origin.getX(), origin.getY());
            return bullet;
        }

        throw new Exception("Gun cant fire");
    }
}
