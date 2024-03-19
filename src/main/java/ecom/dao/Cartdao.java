package ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ecom.DBConnection.DBConnection;
import ecom.pojo.Cart;

public class Cartdao {
	Connection con=DBConnection.getConnection();

	public boolean addCart(int pid, int cid) {
		String sql="insert into cart (product_id,customer_id) values (?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, cid);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Cart> getAllCartbyCustomer(int customerId) {
		String sql ="select cr.id cart_id,product_name,p.price product_price,p.description from product p inner join cart cr on cr.product_id=p.id where cr.customer_id=?";
		List<Cart> clist=new ArrayList<>();
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, customerId);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Cart c = new Cart();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setPrice(rs.getDouble(3));
			c.setDescription(rs.getString(4));
			clist.add(c);
		}
		return clist;

		} catch (Exception e) {
			e.printStackTrace();		
			}
		return null;
	}
	public boolean clearCart(int customerId) {
		String sql="delete from  cart where customer_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, customerId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
