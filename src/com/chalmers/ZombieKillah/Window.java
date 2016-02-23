package com.chalmers.ZombieKillah;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Jesper Rask on 2016-02-19.
 */
public class Window {
    private Input input;
    private JFrame JR;
    private int width;
    private int height;
    private String name;
    private Canvas canvas;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;


    public Window(int width, int height, String name) {
        this.input = new Input();
        this.width = width;
        this.height = height;
        this.name = name;
        pic();
    }

    public void pic() {

        canvas = new Canvas();
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setPreferredSize(new Dimension(width, height));

        JR = new JFrame(name);
        JR.setSize(width, height);
        JR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JR.setVisible(true);
        JR.setLocationRelativeTo(null);
        JR.setResizable(false);

        JR.add(canvas);
        JR.pack();
    }

    public void clear() {
        graphics.clearRect(0, 0, width, height);
    }

    public void draw(List<GameObject> objects) {
        bufferStrategy = canvas.getBufferStrategy();
        if (bufferStrategy == null) {
            bufferStrategy = canvas.createBufferStrategy(2);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();              //Draws things to the canvas(paintbrush)

        for (GameObject obj : objects) {
            graphics.drawImage(obj.GetImage().getData(), (int) obj.getFrame().getX(), (int) object.getFrame().getY(), null);
        }
        bufferStrategy.show();
        graphics.dispose();
    }

}
