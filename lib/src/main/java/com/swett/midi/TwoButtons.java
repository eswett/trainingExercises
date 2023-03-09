package com.swett.midi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {
    private JFrame frame;
    private JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this makes the window exit when I click close button

        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(event -> label.setText("Ouch!"));

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(event -> frame.repaint());

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(500,400);
        frame.setVisible(true);

    }

    //The lambda inside of the addEventListener replaces these class definitions
    //BUT REMEMBER THAT OLD CODE STILL USES BELOW IMPLEMENTATION
    // class LabelListener implements ActionListener { 
    //     public void actionPerformed(ActionEvent event) {
    //         label.setText("Ouch!");
    //     }
    // }

    // class ColorListener implements ActionListener {
    //     public void actionPerformed(ActionEvent event) {
    //         frame.repaint();
    //     }
    // }
}

class MyDrawPanel extends JPanel {

    public void paintComponent(Graphics g) { //the gui calls this so I need to override and implement this method
        Graphics2D g2d = (Graphics2D) g; //casted so that we can call something graphics2d can do but graphics cannot

        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);

        g2d.setPaint(gradient);

        g2d.fillOval(70, 70, 100, 100);
    }
}
