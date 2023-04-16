package Dao.memeber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import Dao.DbConnection;
import Model.member;

public class implMember implements memberDao {

	public static void main(String[] args) {
		//add
		/*member m=new member("test000", "admin", "a123", "test01", "8888", "a888@com");
		new implMember().add(m);*/
		
		//read
		//System.out.println(new implMember().queryAll());
		/*
		 * List<member> l= new implMember().queryAll();
		
		for(member o:l)
		{
			System.out.println(o.getId()+"\t"+o.getName());
		}
		System.out.println(l.size());
		*/
		
		//update
		/*
		member m =new implMember().queryId(1);
		m.setPassword("a8787");
		new implMember().update(m);
		*/
		
		//delete
		//new implMember().delete(1);
		
		//查詢是否有相同的username
		System.out.println(new implMember().queryUser("admin"));
		
		//查詢username, password
		//System.out.println(new implMember().queryMember("admin", "1234"));
		
		//查詢idnumber
		//System.out.println(new implMember().queryidNumber());
	}

	//新增資料
	@Override
	public void add(member m) {
		Connection conn=DbConnection.getDB();
		String sql="insert into member(idNumber,username,password,name,phone, mail)"
				+"values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, m.getIdNumber());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getName());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getMail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//read
	//查詢table
	@Override
	public List<member> queryAll() {
		Connection conn=DbConnection.getDB();
		String sql="select * from member";
		List<member> l= new ArrayList();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				member m=new member();
				m.setId(rs.getInt("id"));
				m.setIdNumber(rs.getString("idNumber"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setMail(rs.getString("mail"));
				l.add(m);
				
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	//查詢id
	@Override
	public member queryId(int id) {
		Connection conn=DbConnection.getDB();
		String sql="select * from member where id=?";
		member m=null;
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);;
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setIdNumber(rs.getString("idNumber"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}
	
	//查詢是否有相同的username
	@Override
	public boolean queryUser(String username) {
		Connection conn=DbConnection.getDB();
		String sql="select * from member where username=?";
		boolean m=false;
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				m=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	//查詢username
	@Override
	public ArrayList<member> queryUsername(String username) {
		Connection conn=DbConnection.getDB();
		String sql="select * from member where username=?";
		ArrayList<member> l= new ArrayList<member>();
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				member m=new member();
				m.setId(rs.getInt("id"));
				m.setIdNumber(rs.getString("idNumber"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setMail(rs.getString("mail"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	//查詢idnumber
	/*@Override
	public String queryidNumber(String idnumber) {
		Connection conn=DbConnection.getDB();
		String sql="SELECT idNumber FROM member ORDER BY id DESC LIMIT 0 , 1";
		member m=null;
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, idnumber);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				m= new member();
				m.setId(rs.getInt("id"));
				m.setIdNumber(rs.getString("idNumber"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setMail(rs.getString("mail"));		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}*/

	
	//查詢username, passwrod
	@Override
	public member queryMember(String username, String password) {
		Connection conn=DbConnection.getDB();
		String sql="select * from member where username=? and password=?";
		member m=null;
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				m= new member();
				m.setId(rs.getInt("id"));
				m.setIdNumber(rs.getString("idNumber"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setMail(rs.getString("mail"));		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	//更改資料
	@Override
	public void update(member m) {
		Connection conn=DbConnection.getDB();
		String sql="update member set idnumber=?, username=?, password=?, name=?, phone=?, mail=?"+"where id=?";
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,m.getIdNumber());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getName());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getPhone());
			ps.setInt(7, m.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//刪除資料
	@Override
	public void delete(int id) {
		Connection conn= DbConnection.getDB();
		String sql="delete from member where id=?";
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	/*
	 * add data_table
	@Override
	public void tableMember() {
		
		Connection conn=DbConnection.getDB();
		String sql="select * from member";
		try {
			//PreparedStatement ps= conn.prepareStatement(sql);
			Statement st=conn.createStatement();
			ResultSet rs= st.executeQuery(sql);
			ResultSetMetaData rsmd= rs.getMetaData();
		    //DefaultTableModel model=(DefaultTableModel) table.getModel();
			
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
				
				//model.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


}
