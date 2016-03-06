package com.chalmers.ZombieKillah;


import java.awt.geom.Rectangle2D;

/**
 * A abstract class which extends GameObject and is a base class for all
 * movable objects in the game.
 * Takes care of so not the same type of objects stack on top of each other.
 * Does all of the movement in the game.
 * @author Philip Laine
 * @version 1.0.0 20/02/16.
 */
public abstract class MovableObject extends GameObject {
    protected double speed;

    /**
     * Initializes a new object with movement
     * @param path
     * @param x
     * @param y
     */

    public MovableObject (String path, double x, double y) {
        super(path, x, y);
        this.speed = 1;
        this.respondable = true;
    }

    /**
     * Method which checks if the same type of objects tries to stack on top of
     * each other, and take care of it so they get pushed back.
     * @param object
     */
    public void avoidCollision(GameObject object) {
        Rectangle2D.Double coveredFrame = (Rectangle2D.Double)frame.createIntersection(object.frame);

        if (coveredFrame.getWidth() > coveredFrame.getHeight()) {
            if (frame.getY() == coveredFrame.getY()) { // Bottom
                changeFramePosition(0, coveredFrame.getHeight());
            } else { // Top
                changeFramePosition(0, -coveredFrame.getHeight());
            }
        } else {
            if (frame.getX() == coveredFrame.getX()) { // Right
                changeFramePosition(coveredFrame.getWidth(), 0);
            } else { // Left
                changeFramePosition(-coveredFrame.getWidth(), 0);
            }
        }
    }

    /**
     * Calls for a method @changeFramePosition which change the position of an object
     * depending on the value of speed and direction.
     */
    protected void step(){
        image.updateImage(direction);

        switch(direction){
            case NORTH:
                changeFramePosition(0, -speed);
                break;

            case SOUTH:
                changeFramePosition(0, speed);
                break;

            case EAST:
                changeFramePosition(speed, 0);
                break;

            case WEST:
                changeFramePosition(-speed, 0);
                break;
        }
    }

    /**
     * Method that changes the frame position of an object gets parameters from @step
     * @param x
     * @param y
     */
    private void changeFramePosition(double x, double y) {
        frame.setRect(frame.getX() + x, frame.getY() + y, frame.getWidth(), frame.getHeight());
    }
}
