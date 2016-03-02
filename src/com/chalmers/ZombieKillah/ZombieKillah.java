package com.chalmers.ZombieKillah;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Philip Laine on 19/02/16.
 */
public class ZombieKillah extends Game {
    protected Player player;

    public ZombieKillah() {
        super(20, 32, 32, "Zombie Killah");

        this.player = new Player(30, 100);
        addMovable(this.player);

        Map map = new Map("Map");
        map.registerColorForClass(new Color(0x454242), Wall.class);
        addWalls(map.getObjects());

        for (int i = 0; i < 10; i++) {
            Zombie zombie = new Zombie((double)(100+(i*10)), (double)(i*25+50));
            addMovable(zombie);
        }
    }

    @Override
    public void update() {
        super.update();

        movePlayer();

        for (GameObject object: getMovable()) {
            if (object instanceof Zombie) {
                ((Zombie) object).move(player.frame);
            } else if (object instanceof Bullet) {
                ((Bullet)object).step();
            }
        }
    }

    private void movePlayer() {
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
            shoot();
        }
    }

    private void shoot() {
        Bullet bullet = new Bullet(player.direction, player.getFrame().getCenterX(), player.getFrame().getCenterY());
        addMovable(bullet);
    }
}
