package Controller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Main.orderpizza.Orderpizza_UI;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(95, 45, 100, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("準備點餐");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orderpizza_UI o=new Orderpizza_UI();
				o.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 20));
		btnNewButton.setBounds(85, 100, 120, 30);
		contentPane.add(btnNewButton);
	}

}
