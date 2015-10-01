package Entities;

public class Invoice {

	public static final int VATRate = 10;

	public Invoice() {

	}

	public int InvoiceID;
	public int ProductID;
	public String ProductName;
	public int UnitPrice = 0;
	public int Quantity = 0;
	public int Amount = 0;

	public void CanculateAmount() {
		this.Amount = this.UnitPrice * this.Quantity;
	}
}
