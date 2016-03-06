package com.chalmers.ZombieKillah;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * Wraps an input listener into a singleton
 * to make key inputs available everywhere without
 * needing to keep reference or pass an instance variable
 * @author Daniel Posch
 * @version 1.0.0 20/02/16
 */
public class Input extends KeyAdapter {
    private static Input input = new Input();
    private HashMap<Integer, Boolean> keys;

    private Input(){
        this.keys = new DefaultHashMap<>(false);
    }

    /**
     * Adds the given key event key code to the map
     * @param evt The related key event
     */
    @Override
    public void keyPressed(KeyEvent evt) {
        keys.put(evt.getKeyCode(), true);
    }

    /**
     * Removes the given key event key code from the map
     * @param evt The related key event
     */
    @Override
    public void keyReleased(KeyEvent evt) {
        keys.put(evt.getKeyCode(), false);
    }

    public static Input getInstance( ) {
        return input;
    }

    public HashMap<Integer, Boolean> getKeys() {
        return keys;
    }
}

