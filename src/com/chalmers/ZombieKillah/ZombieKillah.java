package com.chalmers.ZombieKillah;

import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Created by Philip Laine on 19/02/16.
 */
public class ZombieKillah extends Game {

    public ZombieKillah() {
        super();

        for (int i = 0; i < 10; i++) {
            Zombie zombie = new Zombie((double)(100+(i*10)), (double)(i*25+30));
            objects.add(zombie);
        }
    }

    private void shoot() {
        Bullet bullet = new Bullet(player.direction, player.getFrame().getX(), player.getFrame().getY());
        objects.add(bullet);
    }

    protected void update(Set<Integer> pressedKeys) {
        for (Integer key: pressedKeys) {
            switch (key) {
                case KeyEvent.VK_LEFT:
                    player.turn(GameObject.Direction.WEST);
                    break;

                case KeyEvent.VK_DOWN:
                    player.turn(GameObject.Direction.SOUTH);
                    break;

                case KeyEvent.VK_UP:
                    player.turn(GameObject.Direction.NORTH);
                    break;

                case KeyEvent.VK_RIGHT:
                    player.turn(GameObject.Direction.EAST);
                    break;

                case KeyEvent.VK_SPACE:
                    shoot();
                    break;

                /*case KeyEvent.VK_RIGHT | KeyEvent.VK_UP:
                    player.turn(GameObject.Direction.NORTHEAST);
                    break;
                case KeyEvent.VK_LEFT | KeyEvent.VK_UP:
                    player.turn(GameObject.Direction.NORTHWEST);
                    break;
                case KeyEvent.VK_RIGHT | KeyEvent.VK_DOWN:
                    player.turn(GameObject.Direction.SOUTHEAST);
                    break;
                case KeyEvent.VK_LEFT | KeyEvent.VK_DOWN:
                    player.turn(GameObject.Direction.SOUTHWEST);
                    break;*/
            }
        }

        // AI path calculations

        for (GameObject object: objects) {
            if (object instanceof Zombie) {
                ((Zombie) object).move(player.frame);
            } else if (object instanceof Bullet) {
                ((Bullet)object).step();
            }
        }
    }

    protected void objectsDidCollide(GameObject object1, GameObject object2) {

    }
}
