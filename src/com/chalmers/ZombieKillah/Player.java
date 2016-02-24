package com.chalmers.ZombieKillah;

/**
 * Created by Daniel Posch on 20/02/24.
 */
public class Player {

    public GameObject.Direction turn(Input input){

        switch (input){
            case VK_LEFT:
                MovableObject.step(WEST);
                break;
            case VK_DOWN:
                MovableObject.step(SOUTH);
                break;
            case VK_UP:
                MovableObject.step(NORTH);
                break;
            case VK_RIGHT:
                MovableObject.step(EAST);
                break;
            case VK_RIGHT|VK_UP:
                MovableObject.step(NORTHEAST);
                break;
            case VK_LEFT|VK_UP:
                MovableObject.step(NORTHWEST);
                break;
            case VK_RIGHT|VK_DOWN:
                MovableObject.step(SOUTHEAST);
                break;
            case VK_LEFT|VK_DOWN:
                MovableObject.step(SOUTHWEST);
                break;
    }



    }
}
