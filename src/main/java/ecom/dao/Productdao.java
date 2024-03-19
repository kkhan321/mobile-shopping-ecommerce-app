package ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ecom.DBConnection.DBConnection;
import ecom.pojo.Category;
import ecom.pojo.Product;
import ecom.pojo.Vendor;

public class Productdao {
	Connection con=DBConnection.getConnection();
	public boolean addProduct(Product product) {
		String sql="insert into product(product_name,price,description,category_id,vendor_id,addImage) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getCategory_id());
			ps.setInt(5, product.getVendor_id());
			ps.setString(6, product.getImage());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean updateProduct(Product product) {
		String sql="update product set product_name=?,price=?,description=?,category_id=?,vendor_id=?,addImage=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setInt(4, product.getCategory_id());
			ps.setInt(5, product.getVendor_id());
			ps.setString(6, product.getImage());
			ps.setInt(7, product.getId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean deleteProduct(int id) {
		String sql="delete from product where id=?";
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
	public List<Product> getAll(){
		String sql="select p.id,p.price,p.product_name,p.description,p.addImage,c.name category,v.name vendor from product p inner join category c on c.id=p.category_id inner join vendor v on v.id=p.vendor_id";
		List<Product> plist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setProductName(rs.getString("product_name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("addImage"));
				p.setVendorName(rs.getString("vendor"));
				p.setCategoryName(rs.getString("category"));
				plist.add(p);
			}
			return plist;

		} catch (Exception e) {
			e.printStackTrace();		}
		return null;
	}
	public List<Product> getAllbyObject(){
		String sql="select id,product_name,price,description,category_id,vendor_id from product";
		String sql1="select * from category where id=?";
		String sql2="select * from vendor where id =?";
		List<Product> plist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setProductName(rs.getString("product_name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescription(rs.getString("description"));
				//p.setImage(rs.getString("addImage"));
				int category_id=rs.getInt("category_id");
				System.out.println("------>"+category_id);
				p.setCategory_id(category_id);
				try {
					ps=con.prepareStatement(sql1);
					ps.setInt(1, category_id);
					ResultSet rs1=ps.executeQuery();
					Category c= new Category();
					while(rs1.next()) {
						c.setId(rs1.getInt("id"));
						c.setName(rs1.getString("name"));
						c.setDescription(rs1.getString("description"));
					}
					p.setCategory(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
				int vendor_id=rs.getInt("vendor_id");
				p.setVendor_id(vendor_id);
				try {
					ps=con.prepareStatement(sql2);
					ps.setInt(1, vendor_id);
					ResultSet rs2=ps.executeQuery();
					Vendor v=new Vendor();
					while(rs2.next()) {
						v.setId(rs2.getInt("id"));
						v.setName(rs2.getString("name"));
						v.setEmail(rs2.getString("email"));
						v.setContact(rs2.getString("contact"));
						v.setPassword(rs2.getString("password"));
					}
					p.setVendor(v);
				} catch (Exception e) {
					e.printStackTrace();
				}
				plist.add(p);
				System.out.println("succes2");
			}
			return plist;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Product getAllbyObjectThroughId(int id){
		String sql="select * from product where id=?";
		Product p=new Product();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setDescription(rs.getString(4));
				
				p.setCategory_id(rs.getInt(5));
				p.setVendor_id(rs.getInt(6));
				p.setImage(rs.getString(7));
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public List<Product> getAllbyVendorId(int vendorId){
		String sql="select p.id,p.price, p.product_name,p.description,p.addImage,c.name category,v.name vendor from product p inner join category c on c.id=p.category_id inner join vendor v on v.id=p.vendor_id where vendor_id=?";
		List<Product> plist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, vendorId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setProductName(rs.getString("product_name"));
				p.setPrice(rs.getDouble("price"));
				p.setDescription(rs.getString("description"));
				p.setImage(rs.getString("addImage"));
				p.setVendorName(rs.getString("vendor"));
				p.setCategoryName(rs.getString("category"));
				plist.add(p);
			}
			return plist;

		} catch (Exception e) {
			e.printStackTrace();		}
		return null;
	}
	public List<Product> searchProduct(String searchproduct) {
		String sql="select p.id,p.product_name,p.price,p.description,p.addImage,c.id,c.name,c.description from product p inner join category c on c.id=p.category_id where p.product_name like '%"+searchproduct+"%'";
		List<Product> plist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);   
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setDescription(rs.getString(4));
				p.setImage(rs.getString(5));
				int i=rs.getInt(6);
				p.setCategory_id(i);
				Category c=new Category();
				c.setId(i);
				c.setName(rs.getString(7));
				c.setDescription(rs.getString(8));
				p.setCategory(c);
				plist.add(p);
			}
			return plist;
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	public List<Product> searchProductthroughvendor(String searchproduct,int vendorid) {
		String sql="select p.id,p.product_name,p.price,p.description,p.addImage,c.id,c.name,c.description, v.id,v.name from product p inner join category c on c.id=p.category_id inner join vendor v on v.id=p.vendor_id where p.product_name like '%"+searchproduct+"%'and v.id=?";

		List<Product> plist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, vendorid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setDescription(rs.getString(4));
				p.setImage(rs.getString(5));
				int i=rs.getInt(6);
				Category c=new Category();
				c.setId(i);
				c.setName(rs.getString(7));
				c.setDescription(rs.getString(8));
				p.setCategory(c);
				int k=rs.getInt(9);
				Vendor v=new Vendor();
				v.setId(k);
				v.setName(rs.getString(10));
				p.setVendor(v);
				plist.add(p);

			}
			return plist;
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}


}
