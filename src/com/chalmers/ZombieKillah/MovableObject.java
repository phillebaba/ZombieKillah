package com.chalmers.ZombieKillah;


/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class MovableObject extends GameObject {
    protected float speed;

    public MovableObject (String path, int posX, int posY, float speed) {
        super(path, posX, posY);
        this.speed = speed;
    }

    protected void step(GameObject gameObject){

        switch(gameObject.getDirection()){
            case NORTH:
                gameObject.setPosY(-(int)speed);
                break;
            case NORTHEAST:
                gameObject.setPosY(-(int)speed);
                gameObject.setPosX((int)speed);
                break;
            case NORTHWEST:
                gameObject.setPosX(-(int)speed);
                gameObject.setPosY(-(int)speed);
                break;
            case SOUTH:
                gameObject.setPosY((int)speed);
                break;
            case SOUTHEAST:
                gameObject.setPosY((int)speed);
                gameObject.setPosX((int)speed);
                break;
            case SOUTHWEST:
                gameObject.setPosX((int)speed);
                gameObject.setPosY(-(int)speed);
                break;
            case EAST:
                gameObject.setPosX((int)speed);
                break;
            case WEST:
                gameObject.setPosX(-(int)speed);
                break;
            default:
                break;
        }

    }
}
