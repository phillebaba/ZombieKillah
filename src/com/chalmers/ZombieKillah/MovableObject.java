package com.chalmers.ZombieKillah;


import java.awt.geom.Rectangle2D;

/**
 * Created by Philip Laine on 20/02/16.
 */
public abstract class MovableObject extends GameObject {
    protected double speed;

    public MovableObject (String path, double x, double y) {
        super(path, x, y);
        this.speed = 1;
    }

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

    protected void step(){
        image.updateImage(direction);

        switch(direction){
            case NORTH:
                changeFramePosition(0, -speed);
<<<<<<< HEAD
<<<<<<< HEAD
                images.uppdateImage(direction);
=======
>>>>>>> 12a9aafa87146623013c14d01ef39f71d1e978d4
=======
>>>>>>> 12a9aafa87146623013c14d01ef39f71d1e978d4
                break;

            case SOUTH:
                changeFramePosition(0, speed);
<<<<<<< HEAD
<<<<<<< HEAD
                images.uppdateImage(direction);
=======
>>>>>>> 12a9aafa87146623013c14d01ef39f71d1e978d4
=======
>>>>>>> 12a9aafa87146623013c14d01ef39f71d1e978d4
                break;

            case EAST:
                changeFramePosition(speed, 0);
                images.uppdateImage(direction);
                break;

            case WEST:
                changeFramePosition(-speed, 0);
                images.uppdateImage(direction);
                break;

            default:
                break;
        }
    }

    private void changeFramePosition(double x, double y) {
        frame.setRect(frame.getX() + x, frame.getY() + y, frame.getWidth(), frame.getHeight());
    }
}
