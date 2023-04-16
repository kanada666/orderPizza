package Controller.Main.orderpizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.Main;

import Controller.Main.member.Login_UI;
import Dao.memeber.implMember;
import Dao.orderpizza.implOrderpizza;
import Model.member;
import Model.orderpizza;
import Model.user;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Orderpizza_UI extends JFrame {

	private JPanel contentPane;
	private JTextField pay;
	private static String serial="";
	private static String Username="";
	private static String Name="";
	private static int clickChe, clickPep, clickMush, clickSoda=0;
	private static int sumChe, sumPep, sumMush, sumSoda=0;
	private static int priceChe=700;
	private static int pricePep=500;
	private static int priceMush=600;
	private static int priceSoda=100;
	private FileInputStream fis=null;
	private ObjectInputStream ois=null;
	

	/**
	 * Launch the application.
	 */
	
	static String serialnum()
	{
		int maxNum =36;
		int conut =0;
		
		
		char[] str= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','4','5','6','7','8','9'};
		
		StringBuffer pwd= new StringBuffer("");
		Random r= new Random();
		while(conut<6)
		{
			int i=Math.abs(r.nextInt(maxNum));
			if(i>=0 && i<str.length)
			{
				pwd.append(str[i]);
				conut++;
			}
		}
		serial=pwd.toString();
		return serial;
		
	}
	
	public static void main(String[] args) {
		/*
		int maxNum =36;
		int conut =0;
		
		
		char[] str= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','4','5','6','7','8','9'};
		
		StringBuffer pwd= new StringBuffer("");
		Random r= new Random();
		while(conut<6)
		{
			int i=Math.abs(r.nextInt(maxNum));
			if(i>=0 && i<str.length)
			{
				pwd.append(str[i]);
				conut++;
			}
		}
		serial=pwd.toString();*/
		
		serialnum();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orderpizza_UI frame = new Orderpizza_UI();
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
	public Orderpizza_UI() {
		setTitle("披薩訂購");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel serialno = new JPanel();
		serialno.setBackground(new Color(192, 192, 192));
		serialno.setBounds(10, 10, 561, 45);
		contentPane.add(serialno);
		serialno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("訂購人");
		lblNewLabel.setBounds(10, 16, 46, 15);
		serialno.add(lblNewLabel);
		
		JTextArea name = new JTextArea();
		name.setForeground(new Color(128, 128, 128));
		name.setBounds(49, 10, 73, 25);
		serialno.add(name);
		
		try {
			fis=new FileInputStream("member.txt");
			ois=new ObjectInputStream(fis);
			if(ois!=null)
			{
				user u=(user)ois.readObject();
				Username=u.getUsername();
				ArrayList<member> l= new implMember().queryUsername(Username);
				member[] m=l.toArray(new member[l.size()]);	
				for(member M:m)
				{
					Name=String.valueOf(M.getName());
					name.setText(Name);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_2 = new JLabel("訂單編號");
		lblNewLabel_2.setBounds(147, 16, 56, 15);
		serialno.add(lblNewLabel_2);
		
		JTextArea serialNo = new JTextArea();
		serialNo.setForeground(new Color(128, 128, 128));
		serialNo.setBounds(199, 10, 73, 25);
		serialno.add(serialNo);
		serialNo.setText(serial);
		
		JCheckBox memberD = new JCheckBox("鑽石會員");
		memberD.setBounds(303, 12, 85, 23);
		serialno.add(memberD);
		
		JComboBox address = new JComboBox();
		address.setModel(new DefaultComboBoxModel(new String[] {"台北", "台中", "高雄"}));
		address.setMaximumRowCount(3);
		address.setBounds(487, 12, 64, 23);
		serialno.add(address);
		
		JLabel lblNewLabel_4 = new JLabel("地區");
		lblNewLabel_4.setBounds(456, 16, 35, 15);
		serialno.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 64, 561, 432);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(234, 234, 255));
		panel_5.setBounds(8, 10, 270, 200);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		
		
		//海鮮起司---------------------------------------------------------------
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Orderpizza_UI.class.getResource("/image/cheese.jpg")));
		lblNewLabel_3.setBounds(0, 0, 160, 120);
		panel_5.add(lblNewLabel_3);
		
		JLabel chenum = new JLabel("0");
		chenum.setFont(new Font("新細明體", Font.PLAIN, 22));
		chenum.setHorizontalAlignment(SwingConstants.CENTER);
		chenum.setBounds(54, 132, 55, 23);
		panel_5.add(chenum);
		
		JLabel chesum = new JLabel("0");
		chesum.setHorizontalAlignment(SwingConstants.RIGHT);
		chesum.setFont(new Font("新細明體", Font.PLAIN, 22));
		chesum.setBounds(85, 167, 65, 23);
		panel_5.add(chesum);
		
		JLabel lblNewLabel_4_2 = new JLabel("$");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblNewLabel_4_2.setBounds(44, 167, 46, 23);
		panel_5.add(lblNewLabel_4_2);
		
		JButton cheplus = new JButton("＋");
		cheplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickChe++;
				String cc= Integer.toString(clickChe);
				chenum.setText(cc);	
				sumChe=priceChe*clickChe;
				String sc= Integer.toString(sumChe);
				chesum.setText(sc);	
			}
		});
		cheplus.setBounds(105, 130, 55, 25);
		panel_5.add(cheplus);
		
		JButton chemin = new JButton("—");
		chemin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickChe>0)
				{
					clickChe--;
					String c= Integer.toString(clickChe);
					chenum.setText(c);
					sumChe=priceChe*clickChe;
					String sc= Integer.toString(sumChe);
					chesum.setText(sc);	
				}

			}
		});
		chemin.setBounds(0, 130, 55, 25);
		panel_5.add(chemin);
		
		JLabel lblNewLabel_1 = new JLabel("海鮮起司");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1.setBounds(170, 0, 95, 30);
		panel_5.add(lblNewLabel_1);
		
		
		//美式臘腸---------------------------------------------------------------
				
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(221, 244, 255));
		panel_5_1.setBounds(283, 10, 270, 200);
		panel_1.add(panel_5_1);
		panel_5_1.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setIcon(new ImageIcon(Orderpizza_UI.class.getResource("/image/pepperoni.jpg")));
		lblNewLabel_3_1.setBounds(0, 0, 160, 120);
		panel_5_1.add(lblNewLabel_3_1);
		
		JLabel pepnum = new JLabel("0");
		pepnum.setHorizontalAlignment(SwingConstants.CENTER);
		pepnum.setFont(new Font("新細明體", Font.PLAIN, 22));
		pepnum.setBounds(54, 132, 55, 23);
		panel_5_1.add(pepnum);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("$");
		lblNewLabel_4_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_2.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblNewLabel_4_2_2.setBounds(44, 167, 46, 23);
		panel_5_1.add(lblNewLabel_4_2_2);
		
		JLabel pepsum = new JLabel("0");
		pepsum.setHorizontalAlignment(SwingConstants.RIGHT);
		pepsum.setFont(new Font("新細明體", Font.PLAIN, 22));
		pepsum.setBounds(85, 167, 65, 23);
		panel_5_1.add(pepsum);
		
		JButton pepplus = new JButton("＋");
		pepplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickPep++;
				String cp= Integer.toString(clickPep);
				pepnum.setText(cp);	
				sumPep=pricePep*clickPep;
				String sp= Integer.toString(sumPep);
				pepsum.setText(sp);	
			}
		});
		pepplus.setBounds(105, 130, 55, 25);
		panel_5_1.add(pepplus);
		
		JButton pepmin = new JButton("—");
		pepmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickPep>0)
				{
					clickPep--;
					String cp= Integer.toString(clickPep);
					pepnum.setText(cp);	
					sumPep=pricePep*clickPep;
					String sp= Integer.toString(sumPep);
					pepsum.setText(sp);	
				}

			}
		});
		pepmin.setBounds(0, 130, 55, 25);
		panel_5_1.add(pepmin);
		
		JLabel lblNewLabel_1_2 = new JLabel("美式臘腸");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(170, 0, 95, 30);
		panel_5_1.add(lblNewLabel_1_2);
		
		
		//彩蔬蘑菇---------------------------------------------------------------
				
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(new Color(221, 244, 255));
		panel_5_2.setBounds(8, 222, 270, 200);
		panel_1.add(panel_5_2);
		panel_5_2.setLayout(null);

		JLabel lblNewLabel_3_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(Orderpizza_UI.class.getResource("/image/mushroom.jpg")));
		lblNewLabel_3_1_1.setBounds(0, 0, 160, 120);
		panel_5_2.add(lblNewLabel_3_1_1);
		
		JLabel mushnum = new JLabel("0");
		mushnum.setHorizontalAlignment(SwingConstants.CENTER);
		mushnum.setFont(new Font("新細明體", Font.PLAIN, 22));
		mushnum.setBounds(54, 134, 55, 23);
		panel_5_2.add(mushnum);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("$");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblNewLabel_4_2_1.setBounds(44, 167, 46, 23);
		panel_5_2.add(lblNewLabel_4_2_1);
		
		JLabel mushsum = new JLabel("0");
		mushsum.setHorizontalAlignment(SwingConstants.RIGHT);
		mushsum.setFont(new Font("新細明體", Font.PLAIN, 22));
		mushsum.setBounds(85, 167, 65, 23);
		panel_5_2.add(mushsum);
		
		JButton mushplus = new JButton("＋");
		mushplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickMush++;
				String cm= Integer.toString(clickMush);
				mushnum.setText(cm);	
				sumMush=priceMush*clickMush;
				String sm= Integer.toString(sumMush);
				mushsum.setText(sm);	
			}
		});
		mushplus.setBounds(105, 130, 55, 25);
		panel_5_2.add(mushplus);
		
		JButton mushmin = new JButton("—");
		mushmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickMush>0)
				{
					clickMush--;
					String cm= Integer.toString(clickMush);
					mushnum.setText(cm);	
					sumMush=priceMush*clickMush;
					String sm= Integer.toString(sumMush);
					mushsum.setText(sm);
				}

			}
		});
		mushmin.setBounds(0, 130, 55, 25);
		panel_5_2.add(mushmin);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("彩蔬蘑菇");
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_2_1.setBounds(170, 0, 95, 30);
		panel_5_2.add(lblNewLabel_1_2_1);
		
		
		//碳酸飲料---------------------------------------------------------------
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBackground(new Color(234, 234, 255));
		panel_5_1_1.setBounds(283, 222, 270, 200);
		panel_1.add(panel_5_1_1);
		panel_5_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(Orderpizza_UI.class.getResource("/image/coke.jpg")));
		lblNewLabel_3_1_1_1.setBounds(0, 0, 160, 120);
		panel_5_1_1.add(lblNewLabel_3_1_1_1);
		
		JLabel sodanum = new JLabel("0");
		sodanum.setHorizontalAlignment(SwingConstants.CENTER);
		sodanum.setFont(new Font("新細明體", Font.PLAIN, 22));
		sodanum.setBounds(54, 132, 55, 23);
		panel_5_1_1.add(sodanum);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("$");
		lblNewLabel_4_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_3.setFont(new Font("新細明體", Font.PLAIN, 22));
		lblNewLabel_4_2_3.setBounds(44, 167, 46, 23);
		panel_5_1_1.add(lblNewLabel_4_2_3);
		
		JLabel sodasum = new JLabel("0");
		sodasum.setHorizontalAlignment(SwingConstants.RIGHT);
		sodasum.setFont(new Font("新細明體", Font.PLAIN, 22));
		sodasum.setBounds(85, 169, 65, 23);
		panel_5_1_1.add(sodasum);	
		
		JButton sodaplus = new JButton("＋");
		sodaplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSoda++;
				String cs= Integer.toString(clickSoda);
				sodanum.setText(cs);	
				sumSoda=priceSoda*clickSoda;
				String ss= Integer.toString(sumSoda);
				sodasum.setText(ss);	
			}
		});
		sodaplus.setBounds(105, 130, 55, 25);
		panel_5_1_1.add(sodaplus);
		
		JButton sodamin = new JButton("—");
		sodamin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickSoda>0)
				{
					clickSoda--;
					String cs= Integer.toString(clickSoda);
					sodanum.setText(cs);	
					sumSoda=priceSoda*clickSoda;
					String ss= Integer.toString(sumSoda);
					sodasum.setText(ss);
				}

			}
		});
		sodamin.setBounds(0, 130, 55, 25);
		panel_5_1_1.add(sodamin);		
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("百事可樂");
		lblNewLabel_1_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_2_1_1.setBounds(170, 0, 95, 30);
		panel_5_1_1.add(lblNewLabel_1_2_1_1);
		
		
		//check---------------------------------------------------------------
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(166, 226, 255));
		panel_2.setBounds(10, 506, 561, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("餐點總數");
		lblNewLabel_1_1_2_1.setBounds(10, 19, 55, 15);
		panel_2.add(lblNewLabel_1_1_2_1);
		
		JTextArea total = new JTextArea();
		total.setText("0");
		total.setFont(new Font("Monospaced", Font.PLAIN, 16));
		total.setBounds(65, 13, 45, 25);
		panel_2.add(total);
		
		
		JLabel lblNewLabel_1_1_2 = new JLabel("總金額");
		lblNewLabel_1_1_2.setBounds(135, 19, 40, 15);
		panel_2.add(lblNewLabel_1_1_2);
		
		JTextArea sum = new JTextArea();
		sum.setFont(new Font("Monospaced", Font.PLAIN, 16));
		sum.setText("0");
		sum.setBounds(175, 13, 80, 25);
		panel_2.add(sum);
		
		//buy---------------------------------------------------------------
		//che
		JButton buyche = new JButton("加入購物車");
		buyche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		buyche.setBounds(165, 165, 100, 30);
		panel_5.add(buyche);
		
		JButton clearche = new JButton("刪除");
		clearche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickChe=0;
				String c= Integer.toString(clickChe);
				chenum.setText(c);
				sumChe=priceChe*clickChe;
				String sc= Integer.toString(sumChe);
				chesum.setText(sc);	
				
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		clearche.setBounds(195, 130, 70, 30);
		panel_5.add(clearche);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1 = new JLabel("20吋 $700");
		lblNewLabel_1_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_1_1.setBounds(165, 29, 95, 30);
		panel_5.add(lblNewLabel_1_2_1_1_1_1_1);
		
		//pep
		JButton buypep = new JButton("加入購物車");
		buypep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		buypep.setBounds(165, 164, 100, 30);
		panel_5_1.add(buypep);		

		JButton clearpep = new JButton("刪除");
		clearpep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickPep=0;
				String cp= Integer.toString(clickPep);
				pepnum.setText(cp);	
				sumPep=pricePep*clickPep;
				String sp= Integer.toString(sumPep);
				pepsum.setText(sp);	
				
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		clearpep.setBounds(195, 130, 70, 30);
		panel_5_1.add(clearpep);
		
		JLabel lblNewLabel_1_2_1_1_1_1 = new JLabel("20吋 $500");
		lblNewLabel_1_2_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_1.setBounds(165, 29, 95, 30);
		panel_5_1.add(lblNewLabel_1_2_1_1_1_1);
		
		//mush
		JButton buymush = new JButton("加入購物車");
		buymush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		buymush.setBounds(165, 165, 100, 30);
		panel_5_2.add(buymush);
		
		JButton clearmush = new JButton("刪除");
		clearmush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickMush=0;
				String cm= Integer.toString(clickMush);
				mushnum.setText(cm);	
				sumMush=priceMush*clickMush;
				String sm= Integer.toString(sumMush);
				mushsum.setText(sm);
				
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		clearmush.setBounds(195, 130, 70, 30);
		panel_5_2.add(clearmush);
		
		JLabel lblNewLabel_1_2_1_1_1_1_1_1 = new JLabel("20吋 $600");
		lblNewLabel_1_2_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1_1_1_1.setBounds(165, 29, 95, 30);
		panel_5_2.add(lblNewLabel_1_2_1_1_1_1_1_1);
		
		//soda
		JButton buySoda = new JButton("加入購物車");
		buySoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		buySoda.setBounds(165, 165, 100, 30);
		panel_5_1_1.add(buySoda);
		
		JButton clearsoda = new JButton("刪除");
		clearsoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSoda=0;
				String cs= Integer.toString(clickSoda);
				sodanum.setText(cs);	
				sumSoda=priceSoda*clickSoda;
				String ss= Integer.toString(sumSoda);
				sodasum.setText(ss);
				
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				if(memberD.isSelected())
				{
					boolean memberD= Boolean.valueOf(true);
					orderpizza p= new orderpizza(Che, Pep, Mush, Soda, memberD, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p.getTotal()));
					sum.setText(Integer.toString(p.getSum()));
				}
				else
				{
					boolean member= Boolean.valueOf(false);
					orderpizza p1= new orderpizza(Che, Pep, Mush, Soda, member, cheSum, pepSum, mushSum, sodaSum);
					total.setText(Integer.toString(p1.getTotal()));
					sum.setText(Integer.toString(p1.getSum()));
				}
			}
		});
		clearsoda.setBounds(195, 130, 70, 30);
		panel_5_1_1.add(clearsoda);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("6罐 $100");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1_1.setBounds(165, 29, 95, 30);
		panel_5_1_1.add(lblNewLabel_1_2_1_1_1);
		
		
		//output---------------------------------------------------------------
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(581, 64, 291, 432);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JTextArea detail = new JTextArea();
		detail.setBounds(0, 0, 291, 265);
		panel_4.add(detail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 271, 291, 161);
		panel_4.add(scrollPane);
		
		JTextArea changeD = new JTextArea();
		scrollPane.setViewportView(changeD);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(581, 506, 293, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		//time---------------------------------------------------------------

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(581, 10, 293, 45);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel time = new JLabel("time");
		time.setBounds(0, 14, 110, 15);
		panel_3.add(time);
		
		JButton read = new JButton("讀取明細");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader fr= new FileReader("detail.txt");
					BufferedReader br= new BufferedReader(fr);
					detail.setText("");
					String Content=" ";
					while(br.ready())
					{
						Content= br.readLine();
						detail.append(Content+"\n");//+"\n"讀取完整格式
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		read.setBounds(120, 10, 85, 23);
		panel_3.add(read);
		
		JButton write = new JButton("儲存明細");
		write.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File name=new File("detail.txt");
				try {
					name.createNewFile();
					BufferedWriter exp= new BufferedWriter(new FileWriter(name));
					exp.write(detail.getText());
					exp.close();
					JOptionPane.showMessageDialog(getContentPane(), 
			                "儲存成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		write.setBounds(208, 10, 85, 23);
		panel_3.add(write);
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		public void run() {
		   	Date date = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		    time.setText(ft.format(date));       
		    };
		};
		t.schedule(tt, 0, 1000);

		
		//pay
		JLabel lblNewLabel_1_1 = new JLabel("付款");
		lblNewLabel_1_1.setBounds(343, 16, 46, 15);
		panel_2.add(lblNewLabel_1_1);
		
		pay = new JTextField();
		pay.setFont(new Font("新細明體", Font.PLAIN, 16));
		pay.setColumns(10);
		pay.setBounds(374, 13, 80, 25);
		panel_2.add(pay);
		
		JButton cash = new JButton("結帳");
		cash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Che= Integer.parseInt(chenum.getText());
				int Pep= Integer.parseInt(pepnum.getText());
				int Mush= Integer.parseInt(mushnum.getText());
				int Soda= Integer.parseInt(sodanum.getText());	
				
				int cheSum= sumChe;
				int pepSum= sumPep;
				int mushSum= sumMush;
				int sodaSum= sumSoda;
				
				int Total= Integer.parseInt(total.getText());
				int Sum= Integer.parseInt(sum.getText());
				String Address= (String) address.getSelectedItem();
				String Time=time.getText();
				int Pay;
				
				boolean strPay = pay.getText().isEmpty();
				if(strPay==false)
				{
					Pay= Integer.parseInt(pay.getText());		
					if(memberD.isSelected())
					{
						boolean memberD= Boolean.valueOf(true);
						orderpizza p= new orderpizza(serial, Username, Name, Address, Che, Pep, Mush, Soda, memberD, 
							cheSum, pepSum, mushSum, sodaSum, Total, Sum, Pay, Time);
						detail.setText(p.showDetail());
						changeD.setText(p.showChange());
					}
					else
					{
						boolean memberD= Boolean.valueOf(false);
						orderpizza p1= new orderpizza(serial, Username, Name, Address, Che, Pep, Mush, Soda, memberD, 
							cheSum, pepSum, mushSum, sodaSum, Total, Sum, Pay, Time);
						detail.setText(p1.showDetail());
						changeD.setText(p1.showChange());
					}
					
					Sum= Integer.parseInt(sum.getText());
					
					if(strPay==false)
					{
						if(Pay>0 && Pay>=Sum)
						{
							orderpizza p2= new orderpizza(serial, Username, Name, Address, Che, Pep, Mush, Soda, Total, Sum);
							new implOrderpizza().add(p2);
							JOptionPane.showMessageDialog(getContentPane(), 
						                "訂單完成！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(getContentPane(), 
					                "訂單不成立\n請重新輸入金額！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(getContentPane(), 
				                "訂單不成立\n請重新輸入金額！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(getContentPane(), 
			                "請輸入金額！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
				}				
			}
		});
		cash.setFont(new Font("新細明體", Font.PLAIN, 16));
		cash.setBounds(481, 11, 70, 30);
		panel_2.add(cash);
		
		
		//other
		JButton clear = new JButton("清除");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberD.setSelected(false);
				address.setSelectedIndex(0);
				
				clickChe=0;
				clickPep=0;
				clickMush=0;
				clickSoda=0;
				sumChe=0;
				sumPep=0;
				sumMush=0;
				
				String c= Integer.toString(clickChe);
				chenum.setText(c);
				sumChe=priceChe*clickChe;
				String sc= Integer.toString(sumChe);
				chesum.setText(sc);	
				
				String cp= Integer.toString(clickPep);
				pepnum.setText(cp);	
				sumPep=pricePep*clickPep;
				String sp= Integer.toString(sumPep);
				pepsum.setText(sp);	
				
				String cm= Integer.toString(clickMush);
				mushnum.setText(cm);	
				sumMush=priceMush*clickMush;
				String sm= Integer.toString(sumMush);
				mushsum.setText(sm);
				
				sumSoda=0;
				String cs= Integer.toString(clickSoda);
				sodanum.setText(cs);	
				sumSoda=priceSoda*clickSoda;
				String ss= Integer.toString(sumSoda);
				sodasum.setText(ss);
				
				total.setText("0");
				sum.setText("0");
				pay.setText("");
				detail.setText("");
				changeD.setText("");
				serialnum();
				serialNo.setText(serial);
			}
		});
		clear.setBounds(10, 10, 80, 23);
		panel.add(clear);
		
		JButton output = new JButton("列印");
		output.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					detail.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		output.setBounds(105, 10, 80, 23);
		panel.add(output);
		
		JButton exit = new JButton("離開");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_UI l=new Login_UI();
				l.main(null);
				dispose();
			}
		});
		exit.setBounds(203, 10, 80, 23);
		panel.add(exit);
	}
}
