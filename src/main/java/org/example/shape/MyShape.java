package org.example.shape;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter
public abstract class MyShape implements Shape {
    private int x;
    private int y;
    private Color color;
    public MyShape(){
    }

    public void drawShape(Graphics g){

    }
}
