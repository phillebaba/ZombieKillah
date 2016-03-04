package com.chalmers.ZombieKillah;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The main controller which runs and keeps track of
 * all of the components to keep the game running. This class
 * is meant to be subclassed so that game logic can be implemented,
 * but it will handle all of the game loop method calling for the
 * subclass.
 * @author Philip Laine
 * Created on 19/02/16
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

    public Controller(int gridDimension, int columnCount, int rowCount, String title) {
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

    /**
     * Starts a new thread if the game is not allready running,
     * will only be needed to be called at the beginning of a game.
     */
    protected void start() {
        if (engine.isRunning)
            return;

        thread = new Thread(engine);
        thread.run();
    }

    /**
     * Called at every game loop to update the games logic,
     * this method is required to be called by the subclass which
     * overrides it if collision detection and object killing will
     * be done.
     */
    protected void update() {
        Iterator iterator = all.iterator();
        while (iterator.hasNext()) {
            GameObject gameObject = (GameObject)iterator.next();
            if (!gameObject.isAlive()) {
                iterator.remove();
            }
        }

        CollisionDetector.checkCollisions(foreground);
    }

    /**
     * Will stop the game but not kill the thread.
     */
    protected void stop() {
        if (!engine.isRunning)
            return;

        engine.isRunning = false;
    }

    /**
     * This method adds a new movable object to the
     * movable list.
     * @param movableObject The object to be added to the lists
     */
    public void addMovable(MovableObject movableObject) {
        all.add(movableObject);
        movable.add(movableObject);
        foreground.add(movableObject);
    }

    /**
     * This method adds a list of movable objects to the
     * movable list.
     * @param movableObjects The objects to be added to the lists
     */
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

    /**
     * Removes all of the objects from all of the object
     * lists. This will result in the objects being cleared
     * from the screen in the next draw update.
     */
    public void clearAllObjects() {
        all.clear();
        movable.clear();
        foreground.clear();
        background.clear();
    }

    /**
     *
     * @param text
     */
    public void addText(Text text) {
        texts.add(text);
    }

    /**
     *
     * @param text
     */
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

    /**
     * The internal class which will handles the run loop
     * which is required for the game to be able to update
     * both its view and game logic. Implements the Runnable
     * interface so that it can use the run method called by
     * the thread.
     */
    class Engine implements Runnable {
        private boolean isRunning = false;
        private double frameCap = 1.0 / 60.0;

        /**
         * This method is called as part of the Runnable
         * interface and will handle both the game update calling
         * and the view update calling. Will do frame calculations
         * so that frames can be dropped in favor of keeping game
         * logic updates at a constant rate.
         */
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

        /**
         * Logs the frame rate for debug purposes
         * @param frameRate The current frame rate to be outputted
         */
        public void logFrameRate(int frameRate) {
            System.out.println(frameRate);
        }
    }
}
