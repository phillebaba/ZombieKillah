package com.chalmers.ZombieKillah;

import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Created by Philip Laine on 19/02/16.
 */
public class ZombieKillah extends Game {

    protected void update(Set<Integer> pressedKeys) {
        for (Integer key: pressedKeys) {
            switch (key) {
                case KeyEvent.VK_LEFT:

                    break;

                case KeyEvent.VK_RIGHT:

                    break;

                case KeyEvent.VK_UP:

                    break;

                case KeyEvent.VK_DOWN:

                    break;

                case KeyEvent.VK_SPACE:

                    break;
            }
        }

        // AI path calculations

    }

    protected void objectsDidCollide(GameObject object1, GameObject object2) {

    }

    private void shoot() {

    }
}
