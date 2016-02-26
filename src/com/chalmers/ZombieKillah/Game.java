package com.chalmers.ZombieKillah;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Philip Laine on 19/02/16.
 */
public abstract class Game {
    protected Player player;
    protected ArrayList<GameObject> objects;

    protected abstract void update(HashMap<Integer, Boolean> keys);
    protected abstract void objectsDidCollide(GameObject object1, GameObject object2);

    public Game() {
        this.player = new Player(10, 10);
        this.objects = new ArrayList<GameObject>();

        this.objects.add(player);
    }

    public void checkCollisions() {
        int index = 1;

        for (GameObject object1: objects) {
            if (object1.collidable) {
                for (GameObject object2 : objects.subList(index, objects.size())) {
                    if (object2.collidable && object1.frame.intersects(object2.frame)) {
                        if (object1 instanceof MovableObject) {
                            ((MovableObject)object1).avoidCollision(object2);
                        } else if (object2 instanceof MovableObject) {
                            ((MovableObject)object2).avoidCollision(object1);
                        }
                    }
                }
            }

            index++;
        }
    }

    public void addObject(GameObject object) {

    }

    public void removeObject(GameObject object) {

    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }
}
