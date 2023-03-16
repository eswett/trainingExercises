package com.swett.midi;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.sound.midi.ShortMessage.*;

/****************************************************************************
 * <b>Title:</b> MiniMusicPlayer.java
 * <b>Project:</b> Project from Heads Up Chaper 14
 * <b>Description:</b> Registering and getting controller events
 * 
 * 
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
public class MiniMusicPlayer {
    private MyDrawPanel panel;
    private Random random = new Random();

    public static void main(String[] args) {
        MiniMusicPlayer mini = new MiniMusicPlayer();
        mini.go();
    }

    public void setUpGui() {
        JFrame frame = new JFrame("Music video"); // instantiate gui window view
        panel = new MyDrawPanel(); // the central animation panel inside the view
        frame.setContentPane(panel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go() {
        setUpGui();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(panel, new int[] { 127 });

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int note;
            for (int i = 0; i < 60; i += 4) {
                note = random.nextInt(50) + 1;

                track.add(makeEvent(NOTE_ON, 1, note, 100, i));
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(NOTE_OFF, 1, note, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This is a static utility method that makes building messages much cleaner
     * 
     * @param cmd
     * @param chn1
     * @param one
     * @param two
     * @param tick
     * @return MidiEvent
     */
    public static MidiEvent makeEvent(int cmd, int chn1, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chn1, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener {
        private boolean msg = false;

        public void controlChange(ShortMessage event) {

            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {

                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);
                g.setColor(new Color(r, gr, b));

                int height = random.nextInt(120) + 10;
                int width = random.nextInt(120) + 10;
                int xPos = random.nextInt(40) + 10;
                int yPos = random.nextInt(40) + 10;
                g.fillRect(xPos, yPos, width, height);

                msg = false;
            }
        }
    }
}