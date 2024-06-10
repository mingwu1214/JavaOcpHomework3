package dao;

import java.util.List;

import model.Porder;

// CRUD
public interface PorderDao {
// create
	void add(Porder p);
// read
	List<Porder> selectAll();
	Porder selectById(int id);
// update
	
// delete
}
