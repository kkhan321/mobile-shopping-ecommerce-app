package ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ecom.DBConnection.DBConnection;
import ecom.pojo.Customer;

public class Customerdao {
	Connection con=DBConnection.getConnection();
	public boolean AddCustomer(Customer Customer) {
		String sql="insert into Customer(name,email,contact,password)values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Customer.getName());
			ps.setString(2, Customer.getEmail());
			ps.setString(3, Customer.getContact());
			ps.setString(4, Customer.getPassword());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}
	public boolean updateCustomer(Customer Customer) {
		String sql="update Customer set name=?,email=?,contact=?,password=? where id=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Customer.getName());
			ps.setString(2, Customer.getEmail());
			ps.setString(3, Customer.getContact());
			ps.setString(4, Customer.getPassword());
			ps.setInt(5, Customer.getId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();		
		}
		return false;
	}
	public List<Customer> selectCustomer() {
		String sql="select * from Customer";
		List<Customer> clist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setContact(rs.getString("contact"));
				clist.add(customer);
			}
			return clist;

		}catch (Exception e) {
			e.printStackTrace();		
		}
		return null;

	}
	public Customer getCustomer(int id) {
		String sql="select * from Customer where id=?";
		Customer customer=new Customer();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setContact(rs.getString("contact"));
			}
			return customer;


		}catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	public boolean deleteCustomer(int id) {
		String sql="delete from Customer where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();		}
		return false;
	}
	public boolean checkCustomerifExist(String email,String contact) {
		String sql="select * from Customer where email=? or contact=?";
		Customer c=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, contact);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setContact(rs.getString("contact"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
			}
				if(c!=null) {
					if(c.getEmail().equals(email)||c.getContact().equals(contact)) {
						return true;
					}
				}
			
		}catch (Exception e) {
			e.printStackTrace();		
			}
		return false;

	}
	public Customer CustomerLogin(String email,String password) {
		String sql="select * from customer where email=? and password=?";
		Customer c=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setContact(rs.getString("contact"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
			}
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();		}
		return null;
		
		
	}
}
