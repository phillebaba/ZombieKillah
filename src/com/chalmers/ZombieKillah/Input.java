package com.chalmers.ZombieKillah;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Philip Laine on 20/02/16.
 */
public class Input extends KeyAdapter {
    private Set<Integer> keys;

    public Input() {
        keys = new HashSet<Integer>();
    }

    public void keyPressed(KeyEvent evt) {
        keys.add(evt.getKeyCode());
    }

    public void keyReleased(KeyEvent evt) {
        keys.remove(evt.getKeyCode());
    }

    public Set<Integer> getKeys() {
        return keys;
    }
}
