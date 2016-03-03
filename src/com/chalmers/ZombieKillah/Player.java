package com.chalmers.ZombieKillah;

/**
 * Created by Philip Laine on 20/02/24.
 */
public class Player extends Character {
    public Player(double x, double y) {
        super("Player", x, y);
        this.speed = 2;

        addWeapon(new Gun());
    }

    public void turn(Direction direction) {
        if (this.direction == direction) {
            super.step();
        } else {
            this.direction = direction;
        }
    }

    @Override
    public void onCollision(GameObject object) {
        super.onCollision(object);

        if (object instanceof Zombie) {
            takeDamage(((Zombie) object).getCurrentWeapon().use());
        }
    }
}
