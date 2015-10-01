package evnbill.com;

import java.text.DecimalFormat;

public class Invoice {
	private int Quantity;
	private int Price;
	
	public Invoice(int quantity, int price) {
		super();
		Quantity = quantity;
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	DecimalFormat df = new DecimalFormat("#,###,###,##0");
	@Override
    public String toString() {
        return this.Quantity + "\t|\t" + this.Price + "\t|\t" +df.format(this.Price*this.Quantity);
    }
}
