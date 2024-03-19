package ecom.pojo;

public class Product {
private int id;
private String productName;
private double price;
private String Description;
private int Category_id;
private int Vendor_id;
private String VendorName ;
private String CategoryName ;
private Vendor vendor;
private Category category;
private String image;

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image=image;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public int getCategory_id() {
	return Category_id;
}
public void setCategory_id(int category_id) {
	Category_id = category_id;
}
public int getVendor_id() {
	return Vendor_id;
}
public void setVendor_id(int vendor_id) {
	Vendor_id = vendor_id;
}
public String getVendorName() {
	return VendorName;
}
public void setVendorName(String vendorName) {
	VendorName = vendorName;
}
public String getCategoryName() {
	return CategoryName;
}
public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}
public Vendor getVendor() {
	return vendor;
}
public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}




}
