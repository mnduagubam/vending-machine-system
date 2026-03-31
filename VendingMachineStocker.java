package myLastSemesterReview.VendingMachine;

import java.util.ArrayList;
public class VendingMachineStocker {
	private ArrayList <Item> fullStock;
	
	public VendingMachineStocker() {
		fullStock=new ArrayList<>();
		loadItems();
	}
	
	private void loadItems() {
	Item item1=new Item(101,"Lays Classic",3.89,1);
	Item item2=new Item(103,"Nestle Water",2.93,1);
	Item item3=new Item(105,"Oreo Cookies",1.45,1);
	Item item4=new Item(107,"  Skittles  ",1.58,1);
	Item item5=new Item(110,"  Red Bull  ",4.35,1);
	Item item6=new Item(102,"   Kitkat   ",2.26,1);
	Item item7=new Item(108,"  Orbit Gum ",0.99,1);
	Item item8=new Item(104," Iced Coffee",4.89,1);
	Item item9=new Item(109," Lemon Sprite",3.77,1);
	Item item10=new Item(106," Coca Cola  ",5.00,1);
	
	fullStock.add(item1);
	fullStock.add(item2);
	fullStock.add(item3);
	fullStock.add(item4);
	fullStock.add(item5);
	fullStock.add(item6);
	fullStock.add(item7);
	fullStock.add(item8);
	fullStock.add(item9);
	fullStock.add(item10);
	}
	
    public ArrayList<Item> getItems(){
    	return fullStock;
    }
	
	
}
