package com.chalmers.ZombieKillah;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Created by Jesper Rask on 2016-02-19.
 */
public class Window {
    private Input input;
    private JFrame frame;
    private Canvas canvas;
    private BufferStrategy bufferStrategy;

    public Window(int width, int height, String title) {
        this.input = new Input();

        this.canvas = new Canvas();
        this.canvas.setMaximumSize(new Dimension(width, height));
        this.canvas.setMinimumSize(new Dimension(width, height));
        this.canvas.setPreferredSize(new Dimension(width, height));

        this.frame = new JFrame(title);
        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.add(canvas);
        this.frame.pack();

        // Create buffer strategy, must be called after setting frame
        this.canvas.createBufferStrategy(2);
        this.bufferStrategy = canvas.getBufferStrategy();
    }

    public void clear() {
        bufferStrategy.getDrawGraphics().clearRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    public void draw(ArrayList<GameObject> objects) {
        Graphics graphics = bufferStrategy.getDrawGraphics();

        for (GameObject object: objects) {
            graphics.drawImage(object.getImage(), (int)object.getFrame().getX(), (int)object.getFrame().getY(), null);
        }

        bufferStrategy.show();
        graphics.dispose();
    }

    public Input getInput() {
        return input;
    }
}
