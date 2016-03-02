package com.chalmers.ZombieKillah;

import java.util.ArrayList;

/**
 * Created by Philip Laine on 02/03/16.
 */
public class CollisionDetector {
    public static void checkCollisions(ArrayList<GameObject> gameObjects) {
        int index = 1;

        for (GameObject object1: gameObjects) {
            if (object1.collidable) {
                for (GameObject object2 : gameObjects.subList(index, gameObjects.size())) {
                    if (object2.collidable && object1.frame.intersects(object2.frame)) {
                        if (object1 instanceof MovableObject && (object1.respondable && object2.respondable)) {
                            ((MovableObject)object1).avoidCollision(object2);
                        } else if (object2 instanceof MovableObject && (object1.respondable && object2.respondable)) {
                            ((MovableObject)object2).avoidCollision(object1);
                        }

                        object1.onCollision(object2);
                        object2.onCollision(object1);
                    }
                }
            }

            index++;
        }
    }
}
