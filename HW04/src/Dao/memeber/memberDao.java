package Dao.memeber;

import java.util.ArrayList;
import java.util.List;

import Model.member;

public interface memberDao {
	
	//新增
	void add(member m);
	
	//查詢
	List<member> queryAll();
	//void tableMember();
	ArrayList queryUsername(String username);
	
	member queryId(int id);
	member queryMember(String username,String password);
	boolean queryUser(String username);
	//String queryidNumber(String idnumber);
	
	//修改
	void update(member m);
	
	//刪除
	void delete(int id);

}
