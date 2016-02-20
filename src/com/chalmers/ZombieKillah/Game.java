package com.chalmers.ZombieKillah;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Philip Laine on 19/02/16.
 */
public abstract class Game {
    protected Player player;
    protected List<GameObject> objects;

    protected abstract void update(Set<Integer> inputKeys);
    protected abstract void objectsDidCollide(GameObject object1, GameObject object2);

    public Game() {
        this.player = new Player();
        this.objects = new ArrayList<GameObject>();
    }

    public void checkCollisions() {

    }
}
