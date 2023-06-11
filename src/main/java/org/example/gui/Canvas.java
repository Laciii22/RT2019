package org.example.gui;

import lombok.Getter;
import lombok.Setter;
import org.example.shape.MyShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Canvas extends JPanel {
    private int curX;
    private int curY;
    private List<MyShape> shapes;
    private MyShape currentShape;

    public Canvas(){
        this.setBackground(Color.LIGHT_GRAY);
        this.shapes = new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (MyShape shape: shapes){
            shape.drawShape(g);
        }
        if (this.getCurrentShape() != null){
            this.getCurrentShape().drawShape(g);
        }
    }
}
