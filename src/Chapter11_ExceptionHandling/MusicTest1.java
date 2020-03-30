package Chapter11_ExceptionHandling;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1 {
	public   void play() throws MidiUnavailableException {
		Sequencer sequencer  = MidiSystem.getSequencer();
	}

	public static void main(String[] args) throws MidiUnavailableException {
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}

}
