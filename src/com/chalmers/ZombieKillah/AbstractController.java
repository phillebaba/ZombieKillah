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
 * @version 1.0.0 19/02/16
 */
public abstract class AbstractController {
    private static int gridDimension;
    private static int width;
    private static int height;

    private Window window;
    private Engine engine;

    private ArrayList<GameObject> all;
    private ArrayList<MovableObject> movable;
    private ArrayList<GameObject> foreground;
    private ArrayList<GameObject> background;
    private ArrayList<Text> texts;

    /**
     * Constructor to be used by the subclass so the needed
     * instance variables are created before start is called
     * @param gridDimension Size of the sides of the grid
     * @param columnCount Amount of objects horizontally
     * @param rowCount Ammount of objects vertically
     * @param title Title for the main JFrame
     */
    public AbstractController(int gridDimension, int columnCount, int rowCount, String title) {
        this.gridDimension = gridDimension;
        this.width = gridDimension*columnCount;
        this.height = gridDimension*rowCount;

        this.window = new Window(this.width, this.height, title);
        this.engine = new Engine();

        this.all = new ArrayList<>();
        this.movable =  new ArrayList<>();
        this.foreground =  new ArrayList<>();
        this.background =  new ArrayList<>();
        this.texts = new ArrayList<>();
    }

    /**
     * Starts a new thread if the engine is not running
     * and will unpause the game if the engine is running
     */
    protected void start() {
        if (!engine.isRunning()) {
            Thread thread = new Thread(engine);
            thread.run();
        } else {
            engine.setPaused(false);
        }
    }

    /**
     * Will pause the game which suspends the
     * update loop until further
     */
    protected void pause() {
        engine.setPaused(true);
    }

    /**
     * Stops the game completly which means that
     * no process will be running anymore
     */
    protected void stop() {
        engine.setRunning(false);
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

    /**
     * Clears the movable list
     */
    public void clearMovables() {
        all.removeAll(movable);
        foreground.removeAll(movable);
        movable.clear();
    }

    /**
     * Adds a given GameObject to the foreground list which
     * allows for collision of objects
     * @param gameObject GameObject to be added
     */
    public void addForeground(GameObject gameObject) {
        all.add(gameObject);
        foreground.add(gameObject);
    }

    /**
     * Adds a multiple GameObjects to the foreground list
     * @param gameObjects List of GameObjects to be added
     */
    public void addForegrounds(ArrayList<GameObject> gameObjects) {
        all.addAll(gameObjects);
        foreground.addAll(gameObjects);
    }

    /**
     * Clears the foreground list
     */
    public void clearForeground() {
        all.removeAll(foreground);
        foreground.clear();
    }

    /**
     * Adds a GameObject to the background list, which results
     * in no collision being done, but it will be drawn
     * @param gameObject GameObject to be added
     */
    public void addBackground(GameObject gameObject) {
        all.add(gameObject);
        background.add(gameObject);
    }

    /**
     * Adds multiple GameObjects to the background list
     * @param gameObjects GameObject list to be added
     */
    public void addBackgrounds(ArrayList<GameObject> gameObjects) {
        all.addAll(gameObjects);
        background.addAll(gameObjects);
    }

    /**
     * Clears the background
     */
    public void clearBackground() {
        all.removeAll(background);
        background.clear();
    }

    /**
     * Adds a text object to the text list, which will be drawn
     * in the next draw update
     * @param text Text object to be added
     */
    public void addText(Text text) {
        texts.add(text);
    }

    /**
     * Removes a text object from the text list
     * @param text Text object to be removed
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
        private boolean running = false;
        private boolean paused = false;
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
            running = true;

            double firstTime = 0;
            double lastTime = System.nanoTime() / 1000000000.0;
            double passedTime  = 0;
            double unprocessedTime = 0;
            double frameTime = 0;
            int frameCount = 0;

            while (running) {
                if (!paused) {
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


        public boolean isRunning() {
            return running;
        }

        public boolean isPaused() {
            return paused;
        }

        public void setPaused(boolean paused) {
            this.paused = paused;
        }

        public void setRunning(boolean running) {
            this.running = running;
        }
    }
}
