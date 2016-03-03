package com.chalmers.ZombieKillah;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Philip Laine on 19/02/16.
 */
public abstract class Controller {
    private static int gridDimension;
    private static int width;
    private static int height;

    private Window window;
    private Engine engine;
    private Thread thread;

    private ArrayList<GameObject> all;
    private ArrayList<MovableObject> movable;
    private ArrayList<GameObject> foreground;
    private ArrayList<GameObject> background;
    private ArrayList<Text> texts;

    public Controller(int gridDimension, int rowCount, int columnCount, String title) {
        this.gridDimension = gridDimension;
        this.width = gridDimension*rowCount;
        this.height = gridDimension*columnCount;

        this.window = new Window(height, width, title);
        this.engine = new Engine();


        this.all = new ArrayList<>();
        this.movable =  new ArrayList<>();
        this.foreground =  new ArrayList<>();
        this.background =  new ArrayList<>();
        this.texts = new ArrayList<>();
    }

    public void start() {
        if (engine.isRunning)
            return;

        thread = new Thread(engine);
        thread.run();
    }

    public void update() {
        Iterator iterator = all.iterator();
        while (iterator.hasNext()) {
            GameObject gameObject = (GameObject)iterator.next();
            if (!gameObject.isAllive()) {
                iterator.remove();
            }
        }

        CollisionDetector.checkCollisions(foreground);
    }

    public void stop() {
        if (!engine.isRunning)
            return;

        engine.isRunning = false;
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

    public void addForegrounds(ArrayList<GameObject> gameObjects) {
        all.addAll(gameObjects);
        foreground.addAll(gameObjects);
    }

    public void addBackground(GameObject gameObject) {
        all.add(gameObject);
        background.add(gameObject);
    }

    public void addBackgrounds(ArrayList<GameObject> gameObjects) {
        all.addAll(gameObjects);
        background.addAll(gameObjects);
    }

    public void clearAllObjects() {
        all.clear();
        movable.clear();
        foreground.clear();
        background.clear();
    }

    public void addText(Text text) {
        texts.add(text);
    }

    public void removeText(Text text) {
        texts.remove(text);
    }


    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static int getGridDimension() {
        return gridDimension;
    }

    public ArrayList<GameObject> getAll() {
        return all;
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

    public ArrayList<Text> getTexts() {
        return texts;
    }

    public Window getWindow() {
        return window;
    }

    class Engine implements Runnable {
        private boolean isRunning = false;
        private double frameCap = 1.0 / 60.0;

        @Override
        public void run() {
            isRunning = true;

            double firstTime = 0;
            double lastTime = System.nanoTime() / 1000000000.0;
            double passedTime  = 0;
            double unprocessedTime = 0;
            double frameTime = 0;
            int frameCount = 0;

            while (isRunning) {
                boolean render = false;

                firstTime = System.nanoTime() / 1000000000.0;
                passedTime = firstTime - lastTime;
                lastTime = firstTime;

                unprocessedTime += passedTime;
                frameTime += passedTime;

                while (unprocessedTime >= frameCap) {
                    update();

                    unprocessedTime -= frameCap;
                    render = true;

                    if (frameTime >= 1) {
                        logFrameRate(frameCount);
                        frameTime = 0;
                        frameCount = 0;
                    }
                }

                if (render) {
                    window.clear();
                    window.draw(getAll(), getTexts());
                    frameCount++;
                } else {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void logFrameRate(int frameRate) {
            System.out.println(frameRate);
        }
    }
}
