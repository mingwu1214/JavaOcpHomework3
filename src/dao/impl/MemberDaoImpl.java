package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		/*
		// TODO Auto-generated method stub
		//new MemberDaoImpl().addMember("abc", "ppp", "88", "台北", "444");
		Member m=new Member();
		m.setName("test1");
		m.setUsername("test11");
		m.setPassword("password");
		m.setAddress("address");
		m.setPhone("1234567890");
		new MemberDaoImpl().addMember(m);
		*/
		/*
		List<Member> l=new MemberDaoImpl().queryAll();
		for(Member m:l)
		{
			System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getUsername());
		}
		System.out.println(new MemberDaoImpl().queryAll2());
		*/
		//System.out.println(new MemberDaoImpl().queryMemberById(1));
		/*
		Member m=new MemberDaoImpl().queryMemberById(6);
		m.setName("teacher");
		m.setPassword("000000");
		m.setAddress("高雄");
		m.setPhone("777777");		
		new MemberDaoImpl().updateMember(m);
		*/
		new MemberDaoImpl().deleteMember(10);

	}

	@Override
	public Member queryMember(String username, String password) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where username=? and password=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return m;
	}

	@Override
	public Member queryUsername(String username) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where username=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return m;
	}

	@Override
	public void addMember(String name, String username, String password, String address, String phone) {
		// TODO Auto-generated method stub
		/*
		 * 1.先連線
		 * 2.SQL
		 * 3.PreparedStatement-->set..
		 * 4.executeupdate
		 */
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(name,username,password,address,phone) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, address);
			ps.setString(5, phone);
			
			ps.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(name,username,password,address,phone) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());	
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateMember(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="update company.member set name=?,password=?,address=?,phone=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getAddress());
			ps.setString(4, m.getPhone());
			ps.setInt(5, m.getId());
			
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void deleteMember(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from member where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Member> queryAll() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));	
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String queryAll2() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				show=show+"id:"+rs.getInt("id")+
						"\tName:"+rs.getString("name")+
						"\tUsername:"+rs.getString("username")+
						"\tPassword:"+rs.getString("password")+
						"\tAddress:"+rs.getString("address")+
						"\tPhone:"+rs.getString("phone")+"\n";		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public Member queryMemberById(int id) {
		Connection conn=DbConnection.getDb();
		System.out.println(conn);
		String SQL="select * from member where id=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));			
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
}
