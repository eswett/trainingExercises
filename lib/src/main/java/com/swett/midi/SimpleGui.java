package com.swett.midi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui implements ActionListener{
    private JFrame frame;

    public static void main(String[] args) {
        SimpleGui sg = new SimpleGui();
        sg.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this makes the window exit when I click close button

        JButton button = new JButton("Change colors");
        button.addActionListener(this); //confused about 'this'

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel {

    public void paintComponent(Graphics g) { //the gui calls this so I need to override and implement this method
        Graphics2D g2d = (Graphics2D) g; //casted so that we can call something graphics2d can do but graphics cannot

        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);

        g2d.setPaint(gradient);

        g2d.fillOval(70, 70, 100, 100);
    }
}
