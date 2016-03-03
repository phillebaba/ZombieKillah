package com.chalmers.ZombieKillah;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;

/**
 * Created by Philip Laine on 19/02/16.
 */
public class ZombieKillah extends Controller {
    private Player player;

    public ZombieKillah() {
        super(30, 30, 20, "Zombie Killah");

        this.player = new Player(30, 100);
        addMovable(this.player);

        Map map = new Map("Map");
        map.registerColorForClass(new Color(0x000000), Wall.class);
        addForegrounds(map.getObjects());

        for (int i = 0; i < 10; i++) {
            Zombie zombie = new Zombie((double)(100+(i*10)), (double)(i*25+50));
            addMovable(zombie);
        }

        Text text = new Text(new Point2D.Double(30, 50), "Hello World");
        addText(text);
    }

    @Override
    public void update() {
        super.update();

        checkInputs();

        for (GameObject object: getMovable()) {
            if (object instanceof Zombie) {
                ((Zombie) object).move(player.frame);
            } else if (object instanceof Bullet) {
                ((Bullet)object).step();
            }
        }
    }

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
                addMovable(player.shoot());
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
