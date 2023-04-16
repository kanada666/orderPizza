package Controller.Back;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.Main.member.Login_UI;
import Dao.DbConnection;
import Dao.memeber.implMember;
import Dao.orderpizza.implOrderpizza;
import Model.createXL;
import Model.createXLO;
import Model.member;
import Model.orderpizza;

import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class MemberAll extends JFrame {

	protected static final String DbUtils = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField findid;
	private JTextField newpassword;
	private JTextField newname;
	DefaultTableModel model;
	private JTextField deleteid;
	private JTable tableO;
	private JTextField findidO;
	private JTextField che;
	private JTextField mush;
	private JTextField pep;
	private JTextField soda;
	private JTextField deleteOid;
	private JLabel time;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAll frame = new MemberAll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
		
	public MemberAll() {
		setTitle("後台系統");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 864, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel time = new JLabel("New label");
		time.setBounds(10, 10, 175, 15);
		panel_2.add(time);
		
		JButton signout = new JButton("登出");
		signout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_UI l=new Login_UI();
				l.main(null);
				dispose();
			}
		});
		signout.setBounds(750, 10, 90, 23);
		panel_2.add(signout);
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
		public void run() {
		   	Date date = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		    time.setText(ft.format(date));       
		    };
		};
		t.schedule(tt, 0, 1000);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 70, 864, 480);
		contentPane.add(tabbedPane);
		
		
		//會員
		JPanel panel = new JPanel();
		tabbedPane.addTab("會員", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane tblData = new JScrollPane();
		tblData.setBounds(0, 0, 595, 451);
		panel.add(tblData);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		model= new DefaultTableModel();
		Object[] column= {"ID","會員編號","帳號","密碼","姓名","電話","信箱"};
		Object[] row=null;
		//String[] row;
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setSurrendersFocusOnKeystroke(true);
		tblData.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(605, 10, 244, 431);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton selectAll = new JButton("查詢會員");
		selectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<member> l=new implMember().queryAll();//搜尋擷取資料庫全部內容

				member[] m=l.toArray(new member[l.size()]);				
				for(member M:m)
				{
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					model.addRow(
							new Object[] { //addrow裡新增object[]丟資料進去
							M.getId(), 
							M.getIdNumber(), 
							M.getUsername(), 
							M.getPassword(),
							M.getName() ,
							M.getPhone(), 
							M.getMail()
						});
				}
				
				//直接連資料庫
				/*Connection conn=DbConnection.getDB();
				String sql="select * from member";
				try {
					PreparedStatement ps= conn.prepareStatement(sql);
					//Statement st=conn.createStatement();
					ResultSet rs= ps.executeQuery(sql);
					ResultSetMetaData rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName= new String[cols];
					for(int i=0; i<cols; i++)
					{
						colName[i]=rsmd.getColumnClassName(i+1);
					}
								
					String id, idnumber, username, password, name, phone, mail; 
					while(rs.next())
					{
						id=rs.getString(1);
						idnumber=rs.getString(2);
						username=rs.getString(3);
						password=rs.getString(4);
						name=rs.getString(5);
						phone=rs.getString(6);
						mail=rs.getString(7);
						String[] row= {id, idnumber, username, password, name, phone, mail};
						
						model.addRow(row);
					}
					ps.close();
					conn.close();					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
			}
		});
		selectAll.setBounds(10, 10, 90, 23);
		panel_1.add(selectAll);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(0, 49, 244, 216);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("指定ID");
		lblNewLabel.setBounds(10, 34, 46, 15);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("新姓名");
		lblNewLabel_1.setBounds(10, 109, 46, 15);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("新密碼");
		lblNewLabel_1_2.setBounds(10, 70, 46, 15);
		panel_3.add(lblNewLabel_1_2);
		
		findid = new JTextField();
		findid.setBounds(56, 31, 96, 21);
		panel_3.add(findid);
		findid.setColumns(10);
		
		newpassword = new JTextField();
		newpassword.setColumns(10);
		newpassword.setBounds(56, 67, 96, 21);
		panel_3.add(newpassword);
		
		newname = new JTextField();
		newname.setColumns(10);
		newname.setBounds(56, 106, 96, 21);
		panel_3.add(newname);
		
		JButton update = new JButton("修改資料");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//table.setModel(new DefaultTableModel());
				String password=newpassword.getText();
				String name=newname.getText();
				int id= Integer.parseInt(findid.getText());
				
				member m= new implMember().queryId(id);
				m.setPassword(password);
				m.setName(name);
				
				new implMember().update(m);
				model= new DefaultTableModel();
				Object[] column= {"ID","會員編號","帳號","密碼","姓名","電話","信箱"};
				model.setColumnIdentifiers(column);
				table.setModel(model);
				JOptionPane.showMessageDialog(getContentPane(), 
		                "修改成功，請重新載入資料！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
			}
		});
		update.setBounds(144, 168, 90, 23);
		panel_3.add(update);
		
		JButton clear = new JButton("清除");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newpassword.setText("");
				newname.setText(" ");
				findid.setText("");

			}
		});
		clear.setBounds(10, 168, 90, 23);
		panel_3.add(clear);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(0, 272, 244, 100);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		deleteid = new JTextField();
		deleteid.setColumns(10);
		deleteid.setBounds(56, 24, 96, 21);
		panel_4.add(deleteid);
		
		JLabel lblNewLabel_2 = new JLabel("指定ID");
		lblNewLabel_2.setBounds(10, 27, 49, 15);
		panel_4.add(lblNewLabel_2);
		
		JButton delete = new JButton("刪除會員");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Id=Integer.parseInt(deleteid.getText());
				new implMember().delete(Id);
				
				model= new DefaultTableModel();
				Object[] column= {"ID","會員編號","帳號","密碼","姓名","電話","信箱"};
				model.setColumnIdentifiers(column);
				table.setModel(model);

				JOptionPane.showMessageDialog(getContentPane(), 
		                "刪除成功，請重新載入資料！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
			}
		});
		delete.setBounds(144, 67, 90, 23);
		panel_4.add(delete);
		
		JButton export = new JButton("匯出Excel");
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_actionPreformed(e);
			}

			private void do_insertButton_actionPreformed(ActionEvent e) {
				List<member> l=new implMember().queryAll();//搜尋擷取資料庫全部內容
				member[] m=l.toArray(new member[l.size()]);				
				for(member M:m)
				{
					int id=M.getId();
					String idnumber=M.getIdNumber();
					String username=M.getUsername();
					String password=M.getPassword();
					String name=M.getName();
					String phone=M.getPhone();
					String mail=M.getPhone();
					createXL create = new createXL();
					File file = new File("member.xls");
			        if(!file.exists()){
			            create.createExcel();
			        }
			        create.insertvalue(id, idnumber, username, password, name, phone,mail);
				}
		        JOptionPane.showMessageDialog(getContentPane(), 
		                "資料匯出成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
			}
		});
		export.setBounds(134, 398, 90, 23);
		panel_1.add(export);

		
		//訂單==================================================================================
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("訂單", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 595, 451);
		panel_5.add(scrollPane);
		
		tableO = new JTable();
		model= new DefaultTableModel();
		Object[] columnO= {"ID","訂單編號","帳號","姓名","地區","起司","臘腸","野菇","汽水","總數","總金額"};
		Object[] rowO=null;
		//String[] row;
		model.setColumnIdentifiers(columnO);
		tableO.setModel(model);
		tableO.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(tableO);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(170, 227, 255));
		panel_6.setBounds(605, 49, 244, 230);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("指定ID");
		lblNewLabel_3.setBounds(10, 20, 46, 15);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("總數");
		lblNewLabel_3_1.setBounds(10, 140, 46, 15);
		panel_6.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("起司");
		lblNewLabel_3_1_1.setBounds(10, 59, 46, 15);
		panel_6.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("臘腸");
		lblNewLabel_3_1_1_1.setBounds(147, 59, 46, 15);
		panel_6.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("野菇");
		lblNewLabel_3_1_1_2.setBounds(10, 99, 46, 15);
		panel_6.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("可樂");
		lblNewLabel_3_1_1_1_1.setBounds(147, 99, 46, 15);
		panel_6.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel("總金額");
		lblNewLabel_3_1_1_2_1.setBounds(134, 140, 40, 15);
		panel_6.add(lblNewLabel_3_1_1_2_1);
		
		findidO = new JTextField();
		findidO.setBounds(55, 17, 51, 21);
		panel_6.add(findidO);
		findidO.setColumns(10);
		
		che = new JTextField();
		che.setColumns(10);
		che.setBounds(55, 53, 51, 21);
		panel_6.add(che);
		
		mush = new JTextField();
		mush.setColumns(10);
		mush.setBounds(55, 97, 51, 21);
		panel_6.add(mush);
		
		pep = new JTextField();
		pep.setColumns(10);
		pep.setBounds(184, 56, 51, 21);
		panel_6.add(pep);
		
		soda = new JTextField();
		soda.setColumns(10);
		soda.setBounds(184, 96, 51, 21);
		panel_6.add(soda);
		
		
		
		JLabel lblNewLabel_3_1_2 = new JLabel("地區");
		lblNewLabel_3_1_2.setBounds(147, 20, 46, 15);
		panel_6.add(lblNewLabel_3_1_2);
		
		JTextArea totalO = new JTextArea();
		totalO.setBounds(55, 134, 51, 21);
		panel_6.add(totalO);
		
		JTextArea sumO = new JTextArea();
		sumO.setBounds(184, 134, 51, 21);
		panel_6.add(sumO);
		
		JComboBox address = new JComboBox();
		address.setModel(new DefaultComboBoxModel(new String[] {"台北", "台中", "高雄"}));
		address.setMaximumRowCount(3);
		address.setBounds(184, 16, 50, 23);
		panel_6.add(address);
		
		JButton selectOrder = new JButton("全部訂單");
		selectOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<orderpizza> o= new implOrderpizza().selectAll();//搜尋擷取資料庫全部內容

				orderpizza[] p=o.toArray(new orderpizza[o.size()]);			
				for(orderpizza P:p)
				{
					DefaultTableModel model=(DefaultTableModel) tableO.getModel();
					model.addRow(
							new Object[] { //addrow裡新增object[]丟資料進去
							P.getId(), 
							P.getSerialNo(),
							P.getUsername(),
							P.getName(),
							P.getAddress(),
							P.getChe(),
							P.getPep(),
							P.getMush(),
							P.getSoda(),
							P.getTotal(),
							P.getSum()
						});
				}	
			}
		});
		
		JButton updateO = new JButton("修改資料");
		updateO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Address= (String)address.getSelectedItem();
				int Che=Integer.parseInt(che.getText());
				int Pep=Integer.parseInt(pep.getText());
				int Mush=Integer.parseInt(mush.getText());
				int Soda=Integer.parseInt(soda.getText());
				int newtoatl= Che+Pep+Mush+Soda;
				totalO.setText(Integer.toString(newtoatl));
				int Total=Integer.parseInt(totalO.getText());
				int newsum= Che*700+Pep*500+Mush*600+Soda*100; //新總額
				sumO.setText(Integer.toString(newsum));
				int Sum=Integer.parseInt(sumO.getText());
				int id= Integer.parseInt(findidO.getText());
				
				orderpizza p= new implOrderpizza().selectId(id);
				p.setAddress(Address);
				p.setChe(Che);
				p.setPep(Pep);
				p.setMush(Mush);
				p.setSoda(Soda);
				p.setTotal(Total);
				p.setSum(Sum);

				
				new implOrderpizza().update(p);
				model= new DefaultTableModel();
				Object[] columnO= {"ID","訂單編號","帳號","姓名","地區","起司","臘腸","野菇","汽水","總數","總金額"};
				model.setColumnIdentifiers(columnO);
				tableO.setModel(model);

				JOptionPane.showMessageDialog(getContentPane(), 
		                "修改成功，請重新載入資料！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
			}
		});
		updateO.setBounds(147, 197, 87, 23);
		panel_6.add(updateO);
		
		JButton clearO = new JButton("清除");
		clearO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findidO.setText("");
				address.setSelectedIndex(0);
				che.setText("");
				pep.setText("");
				mush.setText("");
				soda.setText("");
				totalO.setText("");
				sumO.setText("");
			}
		});
		clearO.setBounds(19, 197, 87, 23);
		panel_6.add(clearO);
		
		selectOrder.setBounds(605, 10, 87, 23);
		panel_5.add(selectOrder);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(170, 227, 255));
		panel_7.setBounds(605, 289, 244, 98);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("指定ID");
		lblNewLabel_3_2.setBounds(10, 24, 51, 15);
		panel_7.add(lblNewLabel_3_2);
		
		deleteOid = new JTextField();
		deleteOid.setBounds(56, 21, 51, 21);
		deleteOid.setColumns(10);
		panel_7.add(deleteOid);
		
		JButton deleteO = new JButton("刪除訂單");
		deleteO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Id=Integer.parseInt(deleteOid.getText());
				new implOrderpizza().delete(Id);
				
				model= new DefaultTableModel();
				Object[] columnO= {"ID","訂單編號","帳號","姓名","地區","起司","臘腸","野菇","汽水","總數","總金額"};
				model.setColumnIdentifiers(columnO);
				tableO.setModel(model);

				JOptionPane.showMessageDialog(getContentPane(), 
		                "刪除成功，請重新載入資料！", "資訊提示框", JOptionPane.WARNING_MESSAGE);
			}
		});
		deleteO.setBounds(147, 65, 87, 23);
		panel_7.add(deleteO);
		
		JButton exportExcelO = new JButton("匯出Eecel");
		exportExcelO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_actionPreformed(e);
			}

			private void do_insertButton_actionPreformed(ActionEvent e) {
				List<orderpizza> l=new implOrderpizza().selectAll();//搜尋擷取資料庫全部內容
				orderpizza[] o=l.toArray(new orderpizza[l.size()]);				
				for(orderpizza O:o)
				{
					int id= O.getId();
					String serialNo= O.getSerialNo();
					String username= O.getUsername();
					String name= O.getName();
					String address= O.getAddress();
					Integer che= O.getChe();
					Integer pep= O.getPep();
					Integer mush= O.getMush();
					Integer soda= O.getSoda();
					Integer total= O.getTotal();
					Integer sum= O.getSum();
					
					createXLO create = new createXLO();
					File file = new File("order.xls");
			        if(!file.exists()){
			            create.createExcel();
			        }
			        create.insertvalue(id, serialNo, username, name, address, che, pep, mush, soda, total, sum);
				}
		        JOptionPane.showMessageDialog(getContentPane(), 
		                "資料匯出成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);				
			}
		});
		exportExcelO.setBounds(739, 405, 100, 23);
		panel_5.add(exportExcelO);
		

	}
}

