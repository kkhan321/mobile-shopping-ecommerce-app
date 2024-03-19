package ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ecom.DBConnection.DBConnection;
import ecom.pojo.Vendor;

public class VendorDao {
	Connection con =DBConnection.getConnection();

	public boolean addVendor(Vendor vendor) {
		String sql="insert into vendor(name,email,contact,password) values (?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vendor.getName());
			ps.setString(2, vendor.getEmail());
			ps.setString(3,vendor.getContact() );
			ps.setString(4,vendor.getPassword());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean CheckIfExist(String email,String contact) {
		String sql="select * from vendor where email=? or contact=?";
		Vendor v=null;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, contact);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				v=new Vendor();
				v.setId(rs.getInt("id"));
				v.setContact(rs.getString("contact"));
				v.setEmail(rs.getString("email"));
				v.setName(rs.getString("name"));

			}
			if(v!=null) {
				if(v.getEmail().equals(email)||v.getContact().equals(contact)) {
					return  true;
				}
			}

		}catch (Exception e) {
			e.printStackTrace();		
		}
		return false;

	}
	public List<Vendor> selectAll(){
		String sql="select * from vendor";
		List<Vendor> vlist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Vendor vendor=new Vendor();
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setContact(rs.getString("contact"));
				vendor.setEmail(rs.getString("email"));
				vendor.setPassword(rs.getString("password"));
				vlist.add(vendor);

			}
			return vlist;
		}catch (Exception e) {
			e.printStackTrace();		}
		return null;

	}
	public boolean deleteVendor(int id) {
		String sql="delete from vendor where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}
	public  Vendor selectByid(int id) {
		Vendor vendor=new Vendor();
		String sql="select * from vendor where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setEmail(rs.getString("email"));
				vendor.setContact(rs.getString("contact"));
				vendor.setPassword(rs.getString("password"));
				return vendor;
			}

		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	public boolean updateVendor(Vendor vendor) {
		String sql="update vendor set name=?,email=?,contact=?,password=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vendor.getName());
			ps.setString(2, vendor.getEmail());
			ps.setString(3, vendor.getContact());
			ps.setString(4, vendor.getPassword());
			ps.setInt(5, vendor.getId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();		}
		return false;

	}
	public  Vendor vendorLogin(String email,String password) {
		Vendor vendor=null;
		String sql="select * from vendor where email=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				vendor=new Vendor();
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setEmail(rs.getString("email"));
				vendor.setContact(rs.getString("contact"));
				vendor.setPassword(rs.getString("password"));
				return vendor;
			}

		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}


}
