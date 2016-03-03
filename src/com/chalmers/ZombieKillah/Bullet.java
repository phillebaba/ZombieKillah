package com.chalmers.ZombieKillah;

/**
 * Created by Jesper Rask on 2016-02-24.
 */
public class Bullet extends MovableObject {
    private double damage;

    public Bullet(double damage, Direction direction, double x, double y){
        super("Bullet", x, y);
        this.speed = 8;
        this.damage = damage;
        this.direction = direction;
        this.respondable = false;
    }

    @Override
    public void onCollision(GameObject object) {
        super.onCollision(object);

        if (object instanceof Player == false && object instanceof Bullet == false) {
            kill();
        }
    }

    public double getDamage() {
        return damage;
    }
}
