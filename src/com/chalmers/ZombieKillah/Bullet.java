package com.chalmers.ZombieKillah;

/**
 * Created by Jesper Rask on 2016-02-24.
 */
public class Bullet extends MovableObject {
    private int damage;

    public Bullet(Direction direction, double x, double y){
        super("Bullet", x, y);
        this.speed = 8;
        this.damage = 25;
        this.direction = direction;
        this.respondable = false;
    }

    @Override
    public void didCollide(GameObject object) {
        super.didCollide(object);

        if (object instanceof Player == false && object instanceof Bullet == false) {
            kill();
        }
    }

    public int getDamage() {
        return damage;
    }
}
