package com.chalmers.ZombieKillah;

import java.util.ArrayList;

/**
 * Created by Philip Laine on 19/02/16.
 */
public abstract class Game {
    private int width;
    private int height;
    private String title;
    private static int gridSize;

    protected ArrayList<GameObject> objects;

    protected abstract void update();
    protected abstract void objectsDidCollide(GameObject object1, GameObject object2);

    public Game(int gridSize, int heightCount, int widthCount, String title) {
        this.height = heightCount * gridSize;
        this.width = widthCount * gridSize;
        this.title = title;
        this.gridSize = gridSize;

        this.objects = new ArrayList<GameObject>();
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

                        objectsDidCollide(object1, object2);
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public static int getGridSize() {
        return gridSize;
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }
}
