package com.chalmers.ZombieKillah;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Philip Laine
 * @author Jesper Rask
 * @author Daniel Posch
 * @author Sebastian Lind
 * @version 1.0.0 19/02/16
 */

/**
 * Has all the game logic and handle key input
 * and the game setup
 * @author Philip Laine
 * @author Daniel Posch
 * @author Jesper Rask
 * @author Sebastian Lind
 * @version 1.0.0 19/02/16
 */
public class ZombieKillah extends Controller {
    private Player player;
    private Text infoText;
    private boolean spawnedZombie2;
    private boolean spawnedZombie1;
    private Random randomNumber;

    /**
     * Sets up the game
     */
    public ZombieKillah() {
        super(30, 30, 20, "Zombie Killah");

        this.player = new Player(30, 100);
        addMovable(this.player);

        Map map = new Map("Map");
        map.registerColorForClass(new Color(0x000000), Wall.class);
        addForegrounds(map.getObjects());

        this.infoText = new Text(new Point2D.Double(10, 23), "");
        this.infoText.setTextColor(Color.white);
        this.infoText.setTextFont(new Font("Arial", Font.PLAIN, 25));
        addText(infoText);

        this.spawnedZombie1 = false;
        this.spawnedZombie2 = false;
        this.randomNumber = new Random();
        Stats.getInstance().startTimer();

        start();
    }

    /**
     * Overrides the main update method to implement
     * custom game functionality for ZombieKillah,
     * all object updates are done here
     */
    @Override
    public void update() {
        super.update();

        if (player.health <= 0) {
            stop();

            // show end game screen
            // quit restart?

            return;
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
<<<<<<< HEAD
     * Spawns a zombie at a random location within the map
=======
     * Creates a new zombie at a random location of the scree
>>>>>>> cab4e4c5fd4b1f24f9a23620a45265da717b9d12
     */
    private void spawnZombie() {
        int x = randomNumber.nextInt (Controller.getWidth() +5);
        int y = randomNumber.nextInt (Controller.getHeight() +5);
        Point2D.Double spawnPoint = new Point2D.Double(x, y);

        Zombie zombie = new Zombie(spawnPoint.getX(), spawnPoint.getY());
        addMovable(zombie);

        spawnedZombie1 = true;
    }

    /**
<<<<<<< HEAD
     * Handles key input
=======
     * Checks for any input events and will react appropriatly
     * for any of the events
>>>>>>> cab4e4c5fd4b1f24f9a23620a45265da717b9d12
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
