package com.chalmers.ZombieKillah;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Philip Laine on 03/03/16.
 */

/**
 * Creates textObject's
 * @author Philip Laine
 * @version 1.0.0 03/03/16
 */
public class Text {
    private Point2D.Double position;
    private String text;
    private Color textColor;
    private Font textFont;

    /**
     * Creates a text
     * @param position The position of the textObject
     * @param text The text that will be written to the object
     */
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

    public Font getTextFont() {
        return textFont;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public void setTextFont(Font textFont) {
        this.textFont = textFont;
    }
}
