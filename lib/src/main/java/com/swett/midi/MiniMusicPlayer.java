package com.swett.midi;

import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayer {
    public static void main(String[] args) {
        MiniMusicPlayer mini = new MiniMusicPlayer();
        mini.go();
    }

    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] eventsIWant = {127}; //tf is this | an event label?
            sequencer.addControllerEventListener(event -> System.out.println("la"), eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for(int i = 5; i < 60; i++) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(NOTE_OFF, 1, i, 100, i + 2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
}
