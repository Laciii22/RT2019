package org.example.shape;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
public class Plus extends MyShape{

    private int width;
    private int height;

    public Plus(int x, int y, int width, int height, Color color){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(color);

    }

    @Override
    public void drawShape(Graphics g){
        g.setColor(this.getColor());
        g.fillRect(getX(), getY()+getHeight()/3, getWidth(), getHeight()/3);
        g.fillRect(getX()+getWidth()/3 , getY(), getWidth()/3, getHeight());

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
        if (getX() < x && x < getX() + getWidth() && getY() < y && y < getY() + getHeight()){
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
