package Dao.orderpizza;

import java.util.List;

import Model.orderpizza;

public interface orderpizzaDao {
	
	//crate
	void add(orderpizza p);
	
	//read
	List<orderpizza> selectAll();
	orderpizza selectId(int id);
	
	//update
	void update(orderpizza p);
	
	//delete
	void delete(int id);

}
