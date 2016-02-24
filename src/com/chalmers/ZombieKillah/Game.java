package com.chalmers.ZombieKillah;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Philip Laine on 19/02/16.
 */
public abstract class Game {
    protected Player player;
    protected ArrayList<GameObject> objects;

    protected abstract void update(Set<Integer> pressedKeys);
    protected abstract void objectsDidCollide(GameObject object1, GameObject object2);

    public Game() {
        this.player = new Player(10, 10);
        this.objects = new ArrayList<GameObject>();
    }

    public void checkCollisions() {
        for (GameObject object1: objects) {
            if (object1.collidable) {
                for (GameObject object2 : objects) {
                    if (object2.collidable && object1.frame.intersects(object2.getFrame())) {
                        System.out.println("collision");
                    }
                }
            }
        }
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }


}
