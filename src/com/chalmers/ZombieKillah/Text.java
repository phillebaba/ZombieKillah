package com.chalmers.ZombieKillah;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Philip Laine on 03/03/16.
 */
public class Text {
    private Point2D.Double position;
    private String text;
    private Color textColor;

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

    public Color getTextColor() {
        return textColor;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
