package com.swett.midi;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;



/****************************************************************************
 * <b>Title:</b> SimpleAnimation.java
 * <b>Project:</b> Project from Heads Up Chaper 14
 * <b>Description:</b> Simple Animation
 * 
 * This was just to experiement with making a gui and
 * 
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Evan Swett
 * @version 3.0
 * @since 02/28/2023
 *        <b>updates:</b>
 * 
 ****************************************************************************/
public class SimpleAnimation {
    private int xPos = 70;
    private int yPos = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for(int i = 0; i < 130; i++) {
            xPos++;
            yPos++;

            drawPanel.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class MyDrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            g.setColor(Color.green);
            g.fillOval(xPos, yPos, 40, 40);
        }
    }
}

