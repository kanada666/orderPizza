package Dao.orderpizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DbConnection;
import Model.orderpizza;

public class implOrderpizza implements orderpizzaDao {

	public static void main(String[] args)
	{
		//connection test
		//System.out.println(DbConnection.getDB());
		
		//add
		/*orderpizza p= new orderpizza("K9BH8U", "911", "5566", "台中", 1, 2, 1, 2, 6, 1600);
		new implOrderpizza().add(p);
		*/
		
		//查詢資料庫
		//System.out.println(new implOrderpizza().selectAll());
		
		//資料庫內，搜尋id
		//System.out.println(new implOrderpizza().selectId(1));
		
		//更新資料庫
		/*orderpizza p= new implOrderpizza().selectId(2);
		p.setSum(5000);
		new implOrderpizza().update(p);
		*/
		
		//delete
		//new implOrderpizza().delete(1);
	}
	
	//add
	@Override
	public void add(orderpizza p) {
		Connection conn=DbConnection.getDB();
		String sql="insert into orderpizza(serialno, username, name, address, che, pep, mush, soda, total, sum)"
				+"values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, p.getSerialNo());
			ps.setString(2, p.getUsername());
			ps.setString(3, p.getName());
			ps.setString(4, p.getAddress());
			ps.setInt(5, p.getChe());
			ps.setInt(6, p.getPep());
			ps.setInt(7, p.getMush());
			ps.setInt(8, p.getSoda());
			ps.setInt(9, p.getTotal());
			ps.setInt(10, p.getSum());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	//read
	@Override
	public List<orderpizza> selectAll() {
		Connection conn=DbConnection.getDB();
		String sql="select * from orderpizza";
		List<orderpizza> l=new ArrayList();
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				orderpizza p1=new orderpizza();
				p1.setId(rs.getInt("id"));
				p1.setSerialNo(rs.getString("serialNo"));
				p1.setUsername(rs.getString("username"));
				p1.setName(rs.getString("name"));
				p1.setAddress(rs.getString("address"));
				p1.setChe(rs.getInt("che"));
				p1.setPep(rs.getInt("pep"));
				p1.setMush(rs.getInt("mush"));
				p1.setSoda(rs.getInt("soda"));
				p1.setTotal(rs.getInt("total"));
				p1.setSum(rs.getInt("sum"));
				
				l.add(p1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	//search id
	@Override
	public orderpizza selectId(int id) {
		Connection conn= DbConnection.getDB();
		String sql="select * from orderpizza where id=?";
		orderpizza p= null;
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				p=new orderpizza();
				p.setId(rs.getInt("id"));
				p.setSerialNo(rs.getString("serialNo"));
				p.setUsername(rs.getString("username"));
				p.setName(rs.getString("name"));
				p.setAddress(rs.getString("address"));
				p.setChe(rs.getInt("che"));
				p.setPep(rs.getInt("pep"));
				p.setMush(rs.getInt("mush"));
				p.setSoda(rs.getInt("soda"));
				p.setTotal(rs.getInt("total"));
				p.setSum(rs.getInt("sum"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	//update
	@Override
	public void update(orderpizza p) {
		Connection conn= DbConnection.getDB();
		String sql="update orderpizza set name=?, address=?, che=?, pep=?, mush=?, soda=?, total=?, sum=? where id=?";
				
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getAddress());
			ps.setInt(3, p.getChe());
			ps.setInt(4, p.getPep());
			ps.setInt(5, p.getMush());
			ps.setInt(6, p.getSoda());
			ps.setInt(7, p.getTotal());
			ps.setInt(8, p.getSum());
			ps.setInt(9, p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDB();
		String sql="delete from orderpizza where id=?";
		
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
