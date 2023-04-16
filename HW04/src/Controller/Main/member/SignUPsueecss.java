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

public class SignUPsueecss extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUPsueecss frame = new SignUPsueecss();
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
	public SignUPsueecss() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊成功");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(95, 45, 100, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("返回登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_UI l=new Login_UI();
				l.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton.setBounds(85, 100, 120, 30);
		contentPane.add(btnNewButton);
	}

}
