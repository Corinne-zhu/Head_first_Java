package Chapter12_GuiDemo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// 模擬一個用戶登錄的界面
public class LoginFrame {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Login");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 創建一個面板， 並在frame 中增加此面板。一個frame 中可以創建多個面板
		JPanel panel = new JPanel();
		frame.add(panel);

		placeComponents(panel);
		frame.setVisible(true);

	}

	// 設置面板中控件的佈局
	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);

		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(10, 20, 80, 25); // x,y坐標是距離左上角的位置
		panel.add(userLabel);

		JTextField userText = new JTextField();
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		// 登錄按鈕
		JButton loginBtn = new JButton("login");
		loginBtn.setBounds(10, 80, 80, 25);
		panel.add(loginBtn);

		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(100, 80, 80, 25);
		panel.add(exitBtn);

	}

}
