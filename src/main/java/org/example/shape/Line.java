package org.example.shape;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@Setter
@Getter
public class Line extends MyShape{

    private int endX;
    private int endY;

    public Line(int x, int y, int endX, int endY, Color color){
        setX(x);
        setY(y);
        setEndX(endX);
        setEndY(endY);
        setColor(color);
    }


    @Override
    public void drawShape(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(this.getColor());
        g2d.setStroke(new BasicStroke(3));
        g.drawLine(getX(), getY(), getEndX(), getEndY());


    }
    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        if (getX() < x && x < getX() + getEndX() && getY() < y && y < getY() + getEndY()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean contains(Point2D p) {
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}
