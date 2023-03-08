package com.swett.midi;

import javax.sound.midi.*;
import javax.sound.midi.ShortMessage.*;


public class MusicTest1 {
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successfully got a sequencer");
        } catch (MidiUnavailableException e) {
            System.out.println("Bummer");
            e.printStackTrace();//experiment
        }
    }    

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
