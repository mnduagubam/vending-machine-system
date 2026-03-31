package myLastSemesterReview.VendingMachine;

public class Item {
	private int serialNumber;
	private String name;
	private double price;
	private int quantity;
	
	
	public Item(int serialNumber,String name,double price, int quantity) {
		this.serialNumber=serialNumber;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
	this.quantity=quantity;
	}
	public int getQuantity() {
		return quantity;
	}

	public void reduceQuantity() {
		if(quantity>0) {
		this.quantity--;
		}
	}
	
	public String toString() {
		String output="SerialNumber\t\t|\t\tName\t\t|\t\tPrice\t\t|\t\tQuantity     ";
		output= output+"\n"+ this.serialNumber +"\t\t\t\t  "+this.name+"\t\t\t\t"+this.price+"\t\t\t\t  "+this.quantity
				+"\n \t\t\t|\t\t\t\t|\t\t\t\t| "; 
		
		return output;
	}
}
