package com.chalmers.ZombieKillah;


/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class MovableObject extends GameObject {
    protected double speed;

    public MovableObject (String path, int posX, int posY) {
        super(path, posX, posY);
        this.speed = 1;
    }

    protected void step(){
        switch(direction){
            case NORTH:
                changeFramePosition(0, -speed);
                break;

            case NORTHEAST:
                changeFramePosition(speed, -speed);
                break;

            case NORTHWEST:
                changeFramePosition(-speed, -speed);
                break;

            case SOUTH:
                changeFramePosition(0, speed);
                break;

            case SOUTHEAST:
                changeFramePosition(speed, speed);
                break;

            case SOUTHWEST:
                changeFramePosition(-speed, speed);
                break;

            case EAST:
                changeFramePosition(speed, 0);
                break;

            case WEST:
                changeFramePosition(-speed, 0);
                break;

            default:
                break;
        }
    }

    private void changeFramePosition(double x, double y) {
        frame.setRect(frame.getX() + x, frame.getY() - y, frame.getWidth(), frame.getHeight());
    }
}
