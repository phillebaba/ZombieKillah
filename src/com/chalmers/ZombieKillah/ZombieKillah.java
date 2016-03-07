package com.chalmers.ZombieKillah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Random;

/**
 * Game logic
 * @author Philip Laine
 * @author Jesper Rask
 * @author Daniel Posch
 * @author Sebastian Lind
 * @version 1.0.1 19/02/16
 */
public class ZombieKillah extends AbstractController {
    private Player player;
    private Text infoText;
    private boolean spawnedZombie2;
    private boolean spawnedZombie1;
    private Random randomNumber;

    public ZombieKillah() {
        super(30, 30, 20, "Zombie Killah");

        Map map = new Map("Map");
        map.registerColorForClass(new Color(0x000000), Wall.class);
        addForegrounds(map.getObjects());

        this.infoText = new Text(new Point2D.Double(10, 23), "");
        this.infoText.setTextColor(Color.white);
        this.infoText.setTextFont(new Font("Arial", Font.PLAIN, 25));
        addText(infoText);

        newGame();
    }

    /**
     * Overrides the main update method to implement
     * custom game functionality for ZombieKillah,
     * all object updates are done here
     */
    @Override
    public void update() {
        super.update();

        if (player.health == 0) {
            pause();

            JFrame frame = new JFrame("Game Over");
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);

            JLabel label = new JLabel("<html>You Lost!<br>Kills:" + Stats.getInstance().getKills() + "<br>Time:"  + Stats.getInstance().getTime() + "</html>");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);

            JButton button = new JButton("Play Again");
            button.addActionListener(ActionEvent -> {
                frame.setVisible(false);
                frame.dispose();

                clearMovables();
                newGame();
            });

            Container container = frame.getContentPane();
            GridLayout layout = new GridLayout(2, 1, 15, 10);
            container.setLayout(layout);
            container.add(label);
            container.add(button);
            frame.pack();
        }

        // Text
        String string = new String("Health: " + new Integer((int)player.health).toString() + " Kills: " + new Integer((int)Stats.getInstance().getKills()).toString() + " Time: " + new Integer((int)Stats.getInstance().getTime()).toString());
        infoText.setText(string);

        // Movement
        checkInputs();
        for (GameObject object: getMovable()) {
            if (object instanceof Zombie) {
                ((Zombie) object).move(player.frame);
            } else if (object instanceof Bullet) {
                ((Bullet)object).step();
            }
        }

        // Game logic
        int currentTime = Stats.getInstance().getTime();
        int kills = Stats.getInstance().getKills();

        int modulus = 10;
        if (kills < 3) {
            modulus = 8;
        } else if (kills < 5) {
            modulus = 6;
        } else if (kills < 10) {
            modulus = 4;
        } else if (kills < 15) {
            modulus = 3;
        } else if (kills < 2000) {
            modulus = 2;
        }

        if (currentTime%modulus == 0 && spawnedZombie1 == false && modulus != 2) {
            spawnZombie();
        }
        else if(currentTime%modulus == 0 && spawnedZombie1 == false && modulus == 2 && spawnedZombie2 == false ){
            spawnZombie();
            spawnZombie();
        }


        else if (currentTime%modulus == 1) {
            spawnedZombie1 = false;
            spawnedZombie2 = false;
        }
    }

    /**
     * Sets up the minimum requirements to play the game
     */
    private void newGame() {
        this.player = new Player(30, 100);
        addMovable(this.player);

        this.spawnedZombie1 = false;
        this.spawnedZombie2 = false;
        this.randomNumber = new Random();
        Stats.getInstance().reset();

        start();
    }

    /**
     * Creates a new zombie at a random location of the scree
     */
    private void spawnZombie() {
        int x = randomNumber.nextInt (AbstractController.getWidth());
        int y = randomNumber.nextInt (AbstractController.getHeight());
        Point2D.Double spawnPoint = new Point2D.Double(x, y);

        Zombie zombie = new Zombie(spawnPoint.getX(), spawnPoint.getY());
        addMovable(zombie);

        spawnedZombie1 = true;
    }

    /**
     * Checks for any input events and will react appropriatly
     * for any of the events
     */
    private void checkInputs() {
        HashMap<Integer, Boolean> keys = Input.getInstance().getKeys();
        if (keys.get(KeyEvent.VK_UP)) {
            player.turn(GameObject.Direction.NORTH);
        } else if (keys.get(KeyEvent.VK_DOWN)) {
            player.turn(GameObject.Direction.SOUTH);
        } else if (keys.get(KeyEvent.VK_LEFT)) {
            player.turn(GameObject.Direction.WEST);
        } else if (keys.get(KeyEvent.VK_RIGHT)) {
            player.turn(GameObject.Direction.EAST);
        }

        if (keys.get(KeyEvent.VK_SPACE)) {
            try {
                addMovable(((Gun)player.getCurrentWeapon()).shoot(player.getDirection(), new Point2D.Double(player.getFrame().getX(), player.getFrame().getY())));
            } catch (Exception e) {

            }
        }

        if (keys.get(KeyEvent.VK_1)) {
            player.changeWeapon(1);
        } else if (keys.get(KeyEvent.VK_2)) {
            player.changeWeapon(2);
        } else if (keys.get(KeyEvent.VK_3)) {
            player.changeWeapon(3);
        } else if (keys.get(KeyEvent.VK_4)) {
            player.changeWeapon(4);
        } else if (keys.get(KeyEvent.VK_5)) {
            player.changeWeapon(5);
        } else if (keys.get(KeyEvent.VK_6)) {
            player.changeWeapon(6);
        } else if (keys.get(KeyEvent.VK_7)) {
            player.changeWeapon(7);
        } else if (keys.get(KeyEvent.VK_8)) {
            player.changeWeapon(8);
        } else if (keys.get(KeyEvent.VK_9)) {
            player.changeWeapon(9);
        }
    }
}
