package com.chalmers.ZombieKillah;

import com.sun.deploy.ui.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Window {

    private Input input;
    private JFrame JR;


    private JFrame frame;
    private int width;
    private int height;
    private String name;
    private Canvas canvas;

    private BufferStrategy bs;
    private Graphics g;


    public Window(int width, int height, String name) {
        this.input = new Input();
        this.width = width;
        this.height = height;
        this.name = name;
        createDisplay();
    }
    public void createDisplay() {
        this.frame = new JFrame(this.title);
        this.frame.setSize(this.width, this.height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo((Component)null);
        this.frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();

    }
    public void draw(List<gameObject> objects){


        bs = canvas.getBufferStrategy();
        if(bs == null){
           bs = canvas.createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        for(GameObject object : objects) {
             g.drawImage(object.GetImage().getData(), object.getFrame().getX(), object.getFrame().getY, null);
        }
        //end drawing
        bs.show();
        g.dispose();
    }


    public Input getInput() {
        return input;
    }
}
