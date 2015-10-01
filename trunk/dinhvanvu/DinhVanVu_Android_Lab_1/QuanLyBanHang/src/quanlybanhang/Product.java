package quanlybanhang;

public class Product {
	private String Name = "";
	private int id = 0;
	private int Money = 0;
	private int Amount = 0;

	public Product(int _id, String name, int money, int amount) {
		// TODO Auto-generated constructor stub
		Name = name;
		id = _id;
		Money = money;
		Amount = amount;
	}

	public void setName(String _name) {
		Name = _name;
	}

	public String getName() {
		return Name;
	}

	public void setAmount(int _amount) {
		Amount = _amount;
	}

	public int getAmount() {
		return Amount;
	}
	
	public void setID(int _id) {
		id = _id;
	}

	public int getID() {
		return id;
	}
	
	public void setMoney(int _money) {
		Money = _money;
	}

	public int getMoney() {
		return Money;
	}
}
