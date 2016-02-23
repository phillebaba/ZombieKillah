package com.chalmers.ZombieKillah;

import java.util.Set;

/**
 * Created by Philip Laine on 19/02/16.
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
        this.window = new Window((int)(width * scale), (int)(height * scale), title);
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
        int frameCount = 0;

        while (isRunning) {
            boolean render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= frameCap) {
                game.update(window.getInput().getKeys());
                game.checkCollisions();

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
                window.draw(game.getObjects());
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

    public void stop() {
        if (!isRunning)
            return;

        isRunning = false;
    }

    public void logFrameRate(int frameRate) {
        System.out.println(frameRate);
    }

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
