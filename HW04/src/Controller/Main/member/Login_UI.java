package Controller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Back.staffLogin;
import Dao.memeber.implMember;
import Model.member;
import Model.user;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class Login_UI extends JFrame {

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
					Login_UI frame = new Login_UI();
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
	public Login_UI() {
		setTitle("會員登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(90, 50, 55, 28);
		lblNewLabel.setFont(new Font("微軟正黑體 Light", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(90, 110, 55, 28);
		lblNewLabel_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 24));
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(170, 50, 120, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(170, 110, 120, 30);
		contentPane.add(password);
		
		JCheckBox showpassword = new JCheckBox("顯示密碼");
		showpassword.setBounds(170, 146, 97, 23);
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showpassword.isSelected())
				{
					password.setEchoChar((char)0);
				}
				else
				{
					password.setEchoChar('*');
				}
			}
		});
		showpassword.setFont(new Font("微軟正黑體 Light", Font.PLAIN, 14));
		contentPane.add(showpassword);
		
		JButton signup = new JButton("註冊");
		signup.setBounds(25, 200, 110, 30);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUP_UI su=new SignUP_UI();
				su.main(null);
				dispose();
			}
		});
		signup.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(signup);
		
		JButton login = new JButton("登入");
		login.setBounds(160, 200, 110, 30);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username= username.getText();
				String Password= password.getText();
				member m= new implMember().queryMember(Username,Password);
				user u= new user(Username);
				try {
					FileOutputStream fow= new FileOutputStream("member.txt");
					ObjectOutputStream oos=new ObjectOutputStream(fow);
					oos.writeObject(u);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(m!=null)
				{
					LoginSuccess s= new LoginSuccess();
					s.main(null);
					dispose();
				}
				else
				{
					LoginFailed f= new LoginFailed();
					f.main(null);
					dispose();
				}
			}
		});
		login.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		contentPane.add(login);
		
		JButton login_1 = new JButton("後台系統");
		login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffLogin sl= new staffLogin();
				sl.main(null);
				dispose();
			}
		});
		login_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		login_1.setBounds(318, 10, 110, 30);
		contentPane.add(login_1);
		
		JButton exit = new JButton("離開");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		exit.setBounds(298, 200, 110, 30);
		contentPane.add(exit);
	}
}
