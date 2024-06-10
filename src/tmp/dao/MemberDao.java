package dao;

import java.util.List;

import model.Member;

//管理會員資料庫-->CRUD--->method名-->SQL
public interface MemberDao {
	// create
	void addMember(String name, String username,String password, String address,String phone);
	void addMember(Member m);
	
	// read
	List<Member> queryAll();
	String queryAll2();
	Member queryMemberById(int id);
	
	Member queryMember(String username, String password);
	Member queryUsername(String username);
	
	// update
	void updateMember(Member m);
	
	// delete
	void deleteMember(int id);
	
}
