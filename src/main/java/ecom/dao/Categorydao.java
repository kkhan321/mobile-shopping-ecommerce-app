package ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ecom.DBConnection.DBConnection;
import ecom.pojo.Category;

public class Categorydao {
	Connection con=DBConnection.getConnection();
	public boolean addcategory(Category Category) {
		String sql="insert into category(name,description) values (?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Category.getName());
			ps.setString(2, Category.getDescription());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean updatecategory(Category Category) {
		String sql="update Category set name=?,description=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Category.getName());
			ps.setString(2, Category.getDescription());
			ps.setInt(3, Category.getId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public boolean deletecategory(int id) {
		String sql="delete from category where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();	}
		return false;
	}
	public List<Category> Selectcategory() {
		String sql="select * from category";
		List<Category> clist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Category Category=new Category();
				Category.setId(rs.getInt(1));
				Category.setName(rs.getString(2));
				Category.setDescription(rs.getString(3));
				clist.add(Category);
			}
			return clist;
		}catch (Exception e) {
			e.printStackTrace();	}
		return null;
	}
	public Category SelectbyId(int id) {
		String sql="select * from Category where id=?";
		Category category=new Category();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				category.setDescription(rs.getString("description"));
			}
			return category;
		}catch (Exception e) {

			e.printStackTrace();	
			}
		return null;
	}



}

