package Eshop;

public class Products {
	private String nameProducts;
	private int quantity;
	private int price;
	private int total;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getNameProducts() {
		return nameProducts;
	}
	public void setNameProducts(String nameProducts) {
		this.nameProducts = nameProducts;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
