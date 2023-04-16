package Controller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.memeber.implMember;
import Model.member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SignUP_UI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField phone;
	private JTextField mail;
	private static String idnumber="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int maxStr =26;
		int maxNum =10;
		int conut =0;
		
		char[] str= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',};
		
		char[] num= {'0','1','2','3','4','5','6','7','8','9'};
		
		StringBuffer pwd= new StringBuffer("");
		Random e= new Random();
		while(conut<3)
		{
			int i=Math.abs(e.nextInt(maxStr));
			if(i>=0 && i<str.length)
			{
				pwd.append(str[i]);
				conut++;
			}
		}
		
		Random r= new Random();
		while(conut<8)
		{
			int i=Math.abs(r.nextInt(maxNum));
			if(i>=0 && i<num.length)
			{
				pwd.append(num[i]);
				conut++;
			}
		}
		idnumber=pwd.toString();
				
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP_UI frame = new SignUP_UI();
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
	public SignUP_UI() {
		setTitle("註冊會員");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("註冊會員");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_1.setBounds(93, 10, 99, 37);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel(" 會員編號");
		lblNewLabel.setFont(new Font("微軟正黑體 Light", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 69, 63, 20);
		contentPane.add(lblNewLabel);
		
		JTextArea idNumber = new JTextArea();
		idNumber.setForeground(new Color(128, 128, 128));
		idNumber.setBounds(114, 69, 135, 25);
		contentPane.add(idNumber);
		idNumber.setText(idnumber);
		
		JLabel lblNewLabel_2 = new JLabel("*帳號");
		lblNewLabel_2.setFont(new Font("微軟正黑體 Light", Font.BOLD, 14));
		lblNewLabel_2.setBounds(36, 109, 63, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*密碼");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(36, 149, 63, 20);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel(" 姓名");
		lblNewLabel_2_1_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(36, 189, 63, 20);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel(" 電話");
		lblNewLabel_2_1_1_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(36, 229, 63, 20);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel(" 信箱");
		lblNewLabel_2_1_1_1_1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(36, 269, 63, 20);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(114, 109, 135, 25);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(114, 149, 135, 25);
		contentPane.add(password);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(114, 189, 135, 25);
		contentPane.add(name);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(114, 229, 135, 25);
		contentPane.add(phone);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(114, 269, 135, 25);
		contentPane.add(mail);
		
	
		JButton btnNewButton = new JButton("新增會員");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//UI getText
				String Username=username.getText();
				String Password=password.getText();
				String Name=name.getText();
				String Phone=phone.getText();
				String Mail=mail.getText();
				boolean strU = Username.isEmpty();
				boolean strP = Password.isEmpty();
				
				String temp="[A-Za-z0-9]{1,30}@\\w{1,20}";
				
				if(new implMember().queryUser(Username)==true)
				{
					//JOptionPane.showInputDialog(null,"此帳號已被使用");
					JOptionPane.showMessageDialog(getContentPane(), 
							"此帳號已被使用", "資訊提示框", JOptionPane.WARNING_MESSAGE);
				}
				else if(strU==true)
				{
					JOptionPane.showMessageDialog(getContentPane(), 
							"未輸入帳號", "資訊提示框", JOptionPane.WARNING_MESSAGE);
				}
				else if(strP==true)
				{
					JOptionPane.showMessageDialog(getContentPane(), 
							"未輸入密碼", "資訊提示框", JOptionPane.WARNING_MESSAGE);
				}
				else
				{

					if(Mail.matches(temp))
					{
						member m= new member(idnumber, Username, Password, Name,Phone, Mail);
						new implMember().add(m);
						SignUPsueecss sus=new SignUPsueecss();
						sus.main(null);
						dispose();
					}
					else
					{
						//JOptionPane.showInputDialog("信箱格式錯誤，要有@");		
						JOptionPane.showMessageDialog(getContentPane(), 
				                "信箱格式錯誤\n要有@", "資訊提示框", JOptionPane.WARNING_MESSAGE);
					}
				}
			
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		btnNewButton.setBounds(150, 364, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消註冊");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_UI l=new Login_UI();
				l.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		btnNewButton_1.setBounds(36, 364, 99, 23);
		contentPane.add(btnNewButton_1);
		

	}
}
