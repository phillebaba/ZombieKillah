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

    private ArrayList<GameObject> all;
    private ArrayList<MovableObject> movable;
    private ArrayList<GameObject> foreground;
    private ArrayList<GameObject> background;

    protected abstract void update();
    protected abstract void objectsDidCollide(GameObject object1, GameObject object2);

    public Game(int gridSize, int heightCount, int widthCount, String title) {
        this.height = heightCount * gridSize;
        this.width = widthCount * gridSize;
        this.title = title;
        this.gridSize = gridSize;

        this.all = new ArrayList<GameObject>();
        this.movable =  new ArrayList<MovableObject>();
        this.foreground =  new ArrayList<GameObject>();
        this.background =  new ArrayList<GameObject>();
    }

    public void checkCollisions() {
        int index = 1;

        for (GameObject object1: all) {
            if (object1.collidable) {
                for (GameObject object2 : all.subList(index, all.size())) {
                    if (object2.collidable && (object1.respondable && object2.respondable) && object1.frame.intersects(object2.frame)) {
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

    public void addMovable(MovableObject movableObject) {
        all.add(movableObject);
        movable.add(movableObject);
        foreground.add(movableObject);
    }

    public void addMovables(ArrayList<MovableObject> movableObjects) {
        all.addAll(movableObjects);
        movable.addAll(movableObjects);
        foreground.addAll(movableObjects);
    }

    public void addForeground(GameObject gameObject) {
        all.add(gameObject);
        foreground.add(gameObject);
    }

    public void addWalls(ArrayList<GameObject> gameObjects) {
        all.addAll(gameObjects);
        foreground.addAll(gameObjects);
    }

    public void addBackground(GameObject gameObject) {
        all.add(gameObject);
        background.add(gameObject);
    }

    public void addFloors(ArrayList<GameObject> gameObjects) {
        all.addAll(gameObjects);
        background.addAll(gameObjects);
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

    public ArrayList<MovableObject> getMovable() {
        return movable;
    }

    public ArrayList<GameObject> getForeground() {
        return foreground;
    }

    public ArrayList<GameObject> getBackground() {
        return background;
    }
}
