package myLastSemesterReview.VendingMachine;

import java.util.ArrayList;
public class VendingMachine {
	private ArrayList <Item> items;
	private double money;
	private boolean power;
	private boolean isOutOfStock;
	
	public VendingMachine() {
	items=new ArrayList<>();
	money=0;
	power =false;
	isOutOfStock=false;
	}
	
	public void turnOn() {
		power=true;
	}
	
	public void switchOff() {
		power=false;
	}
	
	public boolean getPower() {
		return power;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void addMoney(double amount) {
		if(power=true) {
		if(amount==1|| amount==2 ||amount==5) {
		this.money+=amount;
		
		}
		else {
			System.out.println("Invalid bill. Only $5, $2, and $1 are accepted.");
			
		}
		}
	}

	public double getMoney() {
		return money;
	}
	
	public void setMoney() {
		money=0;
	}
	
	public Item selectItem(int serialNumber) {
		for(Item product: items) {
			if(product.getSerialNumber()==serialNumber) {
				return product;
			}
		}
        return null;
	}
	
        public boolean checkStock(int serialNumber) {
        	Item chosen =selectItem(serialNumber);
        	if(chosen.getQuantity()<=0) {
        		isOutOfStock=true;
        		return isOutOfStock;
        	}else {
        		isOutOfStock=false;
        		return false;
        	}
			
        	
        }
	
	public void vendItem(int serialNumber) {
		Item chosen=selectItem(serialNumber);
		double price=0;
		if(chosen==null) {
			System.out.println("Invalid selection");
			return;
		}
		price+=chosen.getPrice();
		int quantity=chosen.getQuantity();
		
			chosen.reduceQuantity();
		
	}
	public String toString() {
		String output="\t\t\t\t\t\tAVAILABLE ITEMS\n";
		for(Item snack: items) {
	    output=output+""+snack.toString()+"\n";
		}
		
		return output;
	}
}

