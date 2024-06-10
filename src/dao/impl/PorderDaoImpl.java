package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.PorderDao;
import model.Porder;

public class PorderDaoImpl implements PorderDao {

	public static void main(String[] args) {
		//Porder p = new Porder("test01",1,2,3);
		//new PorderDaoImpl().add(p);
		List<Porder> l=new PorderDaoImpl().selectAll();
		for(Porder p2:l) 
		{
			System.out.println(p2.getId() + "\t" + p2.getName() +"\t"+p2.getA() +"\t"+p2.getB() +"\t"+p2.getC());
		}
		System.out.println("================================");
		Porder p3=new PorderDaoImpl().selectById(1);
		System.out.println(p3.getId() + "\t" + p3.getName() +"\t"+p3.getA() +"\t"+p3.getB() +"\t"+p3.getC());

	}

	@Override
	public void add(Porder p) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="insert into porder(name,a,b,c) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());			
			ps.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<Porder> selectAll() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from porder";
		List<Porder> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Porder p = new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setA(rs.getInt("a"));
				p.setB(rs.getInt("b"));
				p.setC(rs.getInt("c"));				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Porder selectById(int id) {
		Connection conn=DbConnection.getDb();
		System.out.println(conn);
		String SQL="select * from porder where id=?";
		Porder p=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p=new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setA(rs.getInt("a"));
				p.setB(rs.getInt("b"));
				p.setC(rs.getInt("c"));			
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
