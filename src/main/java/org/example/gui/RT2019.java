package org.example.gui;

import org.example.controls.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class RT2019 {
    public RT2019(){
        JFrame frame = new JFrame("EXAM RT");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        frame.setSize(600,700);

        Logic logic = new Logic();
        JPanel header = new JPanel(new GridLayout(1,5));
        header.setPreferredSize(new Dimension(600,100));

        JButton plusButton = new JButton(Logic.PLUS);
        plusButton.addActionListener(logic);
        JButton lineButton = new JButton(Logic.LINE);
        lineButton.addActionListener(logic);
        JButton changeColorButton = new JButton(Logic.SELECT);
        changeColorButton.addActionListener(logic);

        Choice choice = new Choice();
        choice.add("Green");
        choice.add("Blue");
        choice.add("Black");
        choice.addItemListener(logic);

        header.add(plusButton);
        header.add(lineButton);
        header.add(changeColorButton);
        header.add(choice);
        header.add(logic.getLabel());

        frame.add(logic.getCanvas());
        frame.add(header, BorderLayout.NORTH);
        frame.setVisible(true);





    }
}
