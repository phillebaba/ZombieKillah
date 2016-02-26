package com.chalmers.ZombieKillah;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Created by Philip Laine on 20/02/16.
 */
public class Input extends KeyAdapter {
    private HashMap<Integer, Boolean> keys;

    public Input() {
        this.keys = new DefaultHashMap<>(false);
    }

    public void keyPressed(KeyEvent evt) {
        keys.put(evt.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent evt) {
        keys.put(evt.getKeyCode(), false);
    }

    public HashMap<Integer, Boolean> getKeys() {
        return keys;
    }
}

