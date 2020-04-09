package Chapter13_Swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BeatBox {
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;

	// 16種樂器的名稱
	String[] insturmentNames = { "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
			"Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
			"Low-mid Tom", "High Agogo", "Open Hi Conga" };

	// 16 種樂器對應的代號
	int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };

	public static void main(String[] args) {
		new BeatBox().buildGUI();

	}

	// 初始化GUI界面
	public void buildGUI() {
		this.theFrame = new JFrame("Cyber BeatBox");
		this.theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		// 設定面板上擺設組件時的空白邊緣
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		this.checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		// 註冊start 事件
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		// 註冊stop 事件
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		// 註冊Tempo Up 事件
		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		// 註冊Tempo Down 事件
		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);

		//
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 16; i++) {
			nameBox.add(new JLabel(this.insturmentNames[i]));
		}

		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		// 把面板panel 加入到frame 中
		this.theFrame.getContentPane().add(background);

		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		this.mainPanel = new JPanel(grid);

		background.add(BorderLayout.CENTER, this.mainPanel);

		// 創建checkbox 群組， 並設置為未選中狀態
		for (int i = 0; i < 256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			this.checkboxList.add(c);
			this.mainPanel.add(c);
		}

		this.setUpMidi();
		this.theFrame.setBounds(50, 50, 300, 300);
		this.theFrame.pack();
		this.theFrame.setVisible(true);

	}

	//
	public void setUpMidi() {
		try {
			this.sequencer = MidiSystem.getSequencer();
			this.sequencer.open();
			this.sequence = new Sequence(Sequence.PPQ, 4);
			this.track = this.sequence.createTrack();
			this.sequencer.setTempoInBPM(120);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 將複選框狀態轉換為MIDI
	public void buildTrackAndStart() {
		// 創造出一個數組存儲樂器的值，若要演奏會是關鍵值，反之為0
		int[] trackList = null;

		// 清空舊的track並做一個新的
		this.sequence.deleteTrack(this.track);
		this.track = this.sequence.createTrack();

		for (int i = 0; i < 16; i++) {
			trackList = new int[16];

			// 設定代表樂器的關鍵字
			int key = this.instruments[i];

			// 對每一拍執行一次 : 判斷當前的checkbox 是否選中“ 選中則賦值樂器的關鍵字
			for (int j = 0; j < 16; j++) {
				JCheckBox jc = this.checkboxList.get(j + (16 * i));
				if (jc.isSelected()) {
					trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
			}

			//
			this.makeTracks(trackList);
			this.track.add(this.makeEvent(176, 1, 127, 0, 16));
		}

		this.track.add(this.makeEvent(192, 9, 1, 0, 15));

		try {
			this.sequencer.setSequence(this.sequence);
			this.sequencer.setLoopCount(this.sequencer.LOOP_CONTINUOUSLY);
			this.sequencer.start();
			this.sequencer.setTempoInBPM(120);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 將樂器的關鍵字賦值給track
	public void makeTracks(int[] list) {
		for (int i = 0; i < 16; i++) {
			int key = list[i];

			if (key != 0) {
				this.track.add(this.makeEvent(144, 9, key, 100, i));
				this.track.add(this.makeEvent(128, 9, key, 100, i + 1));
			}
		}
	}

	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

	// start 按鈕觸發的事件
	public class MyStartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	// stop 按鈕觸發的事件
	public class MyStopListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BeatBox.this.sequencer.stop();
		}
	}

	// Tempo Up 按鈕觸發的事件
	public class MyUpTempoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			float tempoFactor = BeatBox.this.sequencer.getTempoFactor();
			BeatBox.this.sequencer.setTempoFactor((float) (tempoFactor * 1.03));
		}
	}

	// Tempo Down 按鈕觸發的事件
	public class MyDownTempoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			float tempoFactor = BeatBox.this.sequencer.getTempoFactor();
			BeatBox.this.sequencer.setTempoFactor((float) (tempoFactor * 0.97));
		}
	}

}
