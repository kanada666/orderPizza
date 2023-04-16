package Controller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFailed extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFailed frame = new LoginFailed();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFailed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入失敗");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(95, 45, 100, 25);
		contentPane.add(lblNewLabel);
		
		JButton backlogin = new JButton("註冊會員");
		backlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUP_UI su=new SignUP_UI();
				su.main(null);
				dispose();
			}
		});
		backlogin.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		backlogin.setBounds(34, 105, 100, 30);
		contentPane.add(backlogin);
		
		JButton resignin = new JButton("重新登入");
		resignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_UI l=new Login_UI();
				l.main(null);
				dispose();
			}
		});
		resignin.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		resignin.setBounds(155, 105, 100, 30);
		contentPane.add(resignin);
	}

}
