package org.example.controls;

import lombok.Getter;
import lombok.Setter;
import org.example.gui.Canvas;
import org.example.shape.Line;
import org.example.shape.MyShape;
import org.example.shape.Plus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@Setter
@Getter
public class Logic extends UniversalAdapter{
    public static final String PLUS ="Plus";
    public static final String LINE ="Line";
    public static final String SELECT ="Select";
    private JLabel label = new JLabel("Color");
    private Canvas canvas;
    private ArrayList<Color> colorList;
    private Color currentColor ;
    private int chosenButton;

    public Logic(){
        this.initCanvas();
        this.currentColor = Color.GREEN;
        this.colorList = new ArrayList<>();
        this.getLabel().setOpaque(true);
        this.getLabel().setBackground(this.getCurrentColor());



    }

    private void initCanvas() {
        this.canvas = new Canvas();
        this.getCanvas().addMouseListener(this);
        this.getCanvas().addMouseMotionListener(this);

    }

    @Override
    public void mousePressed(MouseEvent e){
        if (getChosenButton() == 1){
            Plus plus = new Plus(e.getX(), e.getY(), 0, 0, getCurrentColor());
            this.getCanvas().getShapes().add(plus);
            this.getCanvas().setCurrentShape(plus);
        }
        else if( getChosenButton()== 2){
            Line line = new Line(e.getX(), e.getY(), e.getX(), e.getY(), getCurrentColor());
            this.getCanvas().getShapes().add(line);
            this.getCanvas().setCurrentShape(line);
        }
        else if (getChosenButton() ==3){
            if (this.getCanvas().getCurrentShape() != null){
                for (MyShape shape: canvas.getShapes()){
                    if (shape.contains(e.getX(), e.getY())){
                        this.getCanvas().setCurrentShape(shape);
                        this.getCanvas().getCurrentShape().setColor(this.getCurrentColor());
                        break;
                    }
                }

            }
        }
        this.getCanvas().setCurX(e.getX());
        this.getCanvas().setCurY(e.getY());
        this.getCanvas().repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e){
        if(getChosenButton() == 1){
            this.resizePlus(e);
        }
        else if (getChosenButton() == 2){
            this.resizeLine(e);
        }
        this.getCanvas().repaint();
    }

    private void resizeLine(MouseEvent e){
        MyShape currentShape = this.getCanvas().getCurrentShape();
        ((Line) currentShape).setEndX(e.getX());
        ((Line) currentShape).setEndY(e.getY());
    }
    private void resizePlus(MouseEvent e){
        int width = Math.abs(e.getX() - this.getCanvas().getCurX());
        int height = Math.abs(e.getY() - this.getCanvas().getCurY());
        MyShape currentShape = this.getCanvas().getCurrentShape();
        if (e.getX() > this.getCanvas().getCurX() && e.getY() > this.getCanvas().getCurY() ){
            ((Plus) currentShape).setWidth(width);
            ((Plus) currentShape).setHeight(height);
        }
        if (e.getX() < this.getCanvas().getCurX() && e.getY() > this.getCanvas().getCurY()) {
            currentShape.setX(this.getCanvas().getCurX() - width);
            ((Plus) currentShape).setWidth(width);
            ((Plus) currentShape).setHeight(height);
        }
        if (e.getX() > this.getCanvas().getCurX() && e.getY() < this.getCanvas().getCurY()) {
            currentShape.setY(this.getCanvas().getCurY() - height);
            ((Plus) currentShape).setWidth(width);
            ((Plus) currentShape).setHeight(height);
        }
        if (e.getX() < this.getCanvas().getCurX() && e.getY() < this.getCanvas().getCurY()) {
            currentShape.setX(this.getCanvas().getCurX() - width);
            currentShape.setY(this.getCanvas().getCurY() - height);
            ((Plus) currentShape).setWidth(width);
            ((Plus) currentShape).setHeight(height);
        }
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        String string = e.getItem().toString();
        switch (string){
            case "Green":
                this.getLabel().setBackground(Color.GREEN);
                this.setCurrentColor(Color.GREEN);
                break;
            case "Blue":
                this.getLabel().setBackground(Color.BLUE);
                this.setCurrentColor(Color.BLUE);
                break;
            case "Black":
                this.getLabel().setBackground(Color.BLACK);
                this.setCurrentColor(Color.BLACK);
                break;
        }
        this.getCanvas().repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(PLUS)){
            this.setChosenButton(1);
        }
        if (e.getActionCommand().equals(LINE)){
            this.setChosenButton(2);
        }
        if (e.getActionCommand().equals(SELECT)){
            this.setChosenButton(3);
        }

    }
}
