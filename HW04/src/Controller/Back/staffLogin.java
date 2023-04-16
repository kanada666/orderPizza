package Controller.Back;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class staffLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffLogin frame = new staffLogin();
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
	public staffLogin() {
		setTitle("工作人員登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("工作人員     登入");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
		lblNewLabel.setBounds(62, 24, 305, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 24));
		lblNewLabel_1.setBounds(62, 90, 50, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(62, 141, 50, 30);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(131, 91, 120, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		JCheckBox showPassword = new JCheckBox("顯示密碼");
		showPassword.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		showPassword.setBounds(129, 173, 95, 23);
		contentPane.add(showPassword);
		
		JButton login = new JButton("登入");
		login.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		login.setBounds(282, 90, 85, 30);
		contentPane.add(login);
		
		JButton forgot = new JButton("忘記密碼");
		forgot.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		forgot.setBounds(282, 141, 85, 30);
		contentPane.add(forgot);
		
		password = new JPasswordField();
		password.setBounds(131, 141, 120, 30);
		contentPane.add(password);
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				if(Username.equals("admin") && Password.equals("a123"))
				{
					MemberAll m= new MemberAll();
					m.main(null);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(getContentPane(), 
							"帳號或密碼錯誤", "資訊提示框", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		forgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,"帳號:admin"+"\n密碼:a123");
				JOptionPane.showMessageDialog(getContentPane(), 
						"帳號:admin"+"\n密碼:a123", "資訊提示框", JOptionPane.WARNING_MESSAGE);
				username.setText("admin");
				password.setText("a123");
			}
		});
		
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPassword.isSelected())
				{
					password.setEchoChar((char)0);
				}
				else
				{
					password.setEchoChar('*');
				}
			}
		});
	}
}
