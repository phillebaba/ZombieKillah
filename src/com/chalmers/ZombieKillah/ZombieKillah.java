package com.chalmers.ZombieKillah;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Philip Laine on 19/02/16.
 */
public class ZombieKillah extends Game {
    public ZombieKillah() {
        super(new Map("Map"));

        this.map.registerColorForClass(new Color(0x454242), Wall.class);
        this.objects.addAll(map.getObjects());

        for (int i = 0; i < 10; i++) {
            Zombie zombie = new Zombie((double)(100+(i*10)), (double)(i*25+50));
            objects.add(zombie);
        }
    }

    private void shoot() {
        Bullet bullet = new Bullet(player.direction, player.getFrame().getX(), player.getFrame().getY());
        objects.add(bullet);
    }

    protected void update() {
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

        for (GameObject object: objects) {
            if (object instanceof Zombie) {
                ((Zombie) object).move(player.frame);
            } else if (object instanceof Bullet) {
                ((Bullet)object).step();
            }
        }
    }

    protected void objectsDidCollide(GameObject object1, GameObject object2) {
        if (object1 instanceof Bullet) {
            object1.visible = false;
        } else if (object2 instanceof Bullet) {
            object2.visible = false;
        }
    }
}
