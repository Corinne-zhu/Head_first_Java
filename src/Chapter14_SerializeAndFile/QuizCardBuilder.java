package Chapter14_SerializeAndFile;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

//模擬flashcard 遊戲
public class QuizCardBuilder {
	private JTextArea question;
	private JTextArea answer;
	private JFrame frame;
	private ArrayList<QuizCard> cardList;

	// 遊戲入口
	public static void main(String[] args) {
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}

	// 創建並顯示GUI & 時間監聽的設計和註冊
	public void go() {
		// 創建GUI
		this.frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("Sanserif", Font.BOLD, 24);

		// question 屬性
		this.question = new JTextArea(6, 20);
		this.question.setLineWrap(true);
		this.question.setWrapStyleWord(true);
		this.question.setFont(bigFont);

		// question 滾動條
		JScrollPane qScroller = new JScrollPane(this.question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// answer 屬性
		this.answer = new JTextArea(6, 20);
		this.answer.setLineWrap(true);
		this.answer.setWrapStyleWord(true);
		this.answer.setFont(bigFont);

		// answer 滾動條
		JScrollPane aScroller = new JScrollPane(this.answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// next Button
		JButton nextButton = new JButton("Next Card");
		this.cardList = new ArrayList<QuizCard>();

		// label
		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");

		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());

		// menu
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());

		saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);

		// 加入到frame
		this.frame.setJMenuBar(menuBar);
		this.frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		this.frame.setSize(500, 600);
		this.frame.setVisible(true);



	}

	// button: nextcard
	private class NextCardListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			QuizCard card = new QuizCard(QuizCardBuilder.this.question.getText(),
					QuizCardBuilder.this.answer.getText());
			QuizCardBuilder.this.cardList.add(card);
			QuizCardBuilder.this.clearCard();
		}
	}

	// 清空card
	public void clearCard() {
		this.question.setText("");
		this.answer.setText("");
		this.question.requestFocus();
	}

	// menu : save
	private class SaveMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			QuizCard card = new QuizCard(QuizCardBuilder.this.question.getText(),
					QuizCardBuilder.this.answer.getText());
			QuizCardBuilder.this.cardList.add(card);

			// show 出保存路徑的對話框
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(QuizCardBuilder.this.frame);
			QuizCardBuilder.this.saveFile(fileSave.getSelectedFile());
		}
	}

	// menu : new
	private class NewMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			QuizCardBuilder.this.cardList.clear();
			QuizCardBuilder.this.clearCard();
		}

	}

	// 把列表中的文字保存到文本文件中
	private void saveFile(File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (QuizCard card : this.cardList) {
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
			}

			writer.close();
		} catch (IOException e) {
			System.out.println("could not write the cardList out");
			e.printStackTrace();
		}

	}
}
