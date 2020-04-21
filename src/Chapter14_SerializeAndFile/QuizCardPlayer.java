package Chapter14_SerializeAndFile;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

//card 遊戲精進版
public class QuizCardPlayer {
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;

	// 入口
	public static void main(String[] args) {
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.go();
	}

	// 創建GUI 畫面 & 事件監聽實現與註冊
	public void go() {
		// 創建GUI
		this.frame = new JFrame("Quiz  Card Player");
		JPanel mainPanel = new JPanel();
		Font bigfont = new Font("sanserif", Font.BOLD, 24);

		this.display = new JTextArea(10, 20);
		this.display.setFont(bigfont);

		this.display.setLineWrap(true);
		this.display.setEditable(false);

		// JTextArea & Button
		JScrollPane qScroller = new JScrollPane(this.display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		this.nextButton = new JButton("Show Question");
		mainPanel.add(qScroller);
		mainPanel.add(this.nextButton);
		this.nextButton.addActionListener(new NextCardListener());

		// menu
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);

		//
		this.frame.setJMenuBar(menuBar);
		this.frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		this.frame.setSize(640, 500);
		this.frame.setVisible(true);

	}

	// 如果是問題顯示出相應的答案，反之則顯示下一題
	class NextCardListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (QuizCardPlayer.this.isShowAnswer) {
				// 顯示答案
				QuizCardPlayer.this.display.setText(QuizCardPlayer.this.currentCard.getAnswer());
				QuizCardPlayer.this.nextButton.setText("Next Card");
				QuizCardPlayer.this.isShowAnswer = false;
			} else {
				// 顯示問題
				if (QuizCardPlayer.this.currentCardIndex < QuizCardPlayer.this.cardList.size() ) {
					QuizCardPlayer.this.showNextCard();
				}else {
					//沒有卡片了
					QuizCardPlayer.this.display.setText("That was last card");
					QuizCardPlayer.this.nextButton.setEnabled(false);
				}
			}
		}
	}

	// Menu: open
	class OpenMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileOpen  = new JFileChooser();
			fileOpen.showOpenDialog(QuizCardPlayer.this.frame);
			QuizCardPlayer.this.loadFile(fileOpen.getSelectedFile());
		}
	}

	//載入遊戲內容
	private void loadFile(File file) {
		this.cardList = new ArrayList<QuizCard>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				this.makeCard(line); //每讀一行就新增一個QuizCard 對象
			}
			reader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 每一行是一張卡片，需要拆解為Q&A
	private void makeCard(String lineToParse) {
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		this.cardList.add(card);
		System.out.println("made a card");
	}

	//
	private void showNextCard() {
		this.currentCard = this.cardList.get(this.currentCardIndex);
		this.currentCardIndex++;
		this.display.setText(this.currentCard.getQuestion());
		this.nextButton.setText("Show Answer");
		this.isShowAnswer = true;
	}
}
