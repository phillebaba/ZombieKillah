package com.chalmers.ZombieKillah;

/**
 * Created by Philip on 19/02/16.
 */
public class Controller implements Runnable {
    private Game game;
    private Window window;
    private Thread thread;

    private String title = "Zombie Killah";
    private int width = 320, height = 240;
    private double scale = 2.0;

    private boolean isRunning = false;
    private double frameCap = 1.0 / 60.0;

    public Controller(Game game) {
        this.game = game;
        this.window = new Window();
    }

    // Game engine states

    public void start() {
        if (isRunning)
            return;

        thread = new Thread(this);
        thread.run();
    }

    public void run() {
        isRunning = true;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime  = 0;
        double unprocessedTime = 0;
        double frameTime = 0;
        int frames = 0;

        while (isRunning) {
            boolean render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= frameCap) {
                // Update game logic
                // Check collisions

                unprocessedTime -= frameCap;
                render = true;

                if (frameTime >= 1) {
                    logFrameRate(frames);
                    frameTime = 0;
                    frames = 0;
                }
            }

            if (render) {
                // Clear and draw window
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stop() {
        if (!isRunning)
            return;

        isRunning = false;
    }

    public void logFrameRate(int frameRate) {
        System.out.println(frameRate);
    }

    // Getters

    public Window getWindow() {
        return window;
    }

    public double getScale() {
        return scale;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
