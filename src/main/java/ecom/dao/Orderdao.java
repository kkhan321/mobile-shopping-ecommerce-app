package ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ecom.DBConnection.DBConnection;

public class Orderdao {
	Connection con=DBConnection.getConnection();

	public boolean PlaceOrder(double totalprice, int customerId) {
		String sql="insert into place_order (total_price,customer_id) values (?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDouble(1, totalprice);
			ps.setInt(2, customerId);
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
