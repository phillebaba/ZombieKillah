package com.chalmers.ZombieKillah;

import java.awt.geom.Point2D;

/**
 * Created by Philip Laine on 03/03/16.
 */
public class Text {
    private Point2D.Double position;
    private String text;

    public Text(Point2D.Double position, String text) {
        this.position = position;
        this.text = text;
    }

    public Point2D.Double getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }
}
