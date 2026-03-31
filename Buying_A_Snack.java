package myLastSemesterReview.VendingMachine;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Buying_A_Snack {
	public static void main(String[]args) {
		//create scanner object
		Scanner input=new Scanner(System.in);

		//create an empty Vending Machine
		VendingMachine machine1=new VendingMachine();
		machine1.turnOn();

		//create a full stock of items (by default all items are in it)
		VendingMachineStocker originalStock=new VendingMachineStocker();

		//add stock to Vending Machine
		for(Item items: originalStock.getItems()) {
			machine1.addItem(items);
		}

		//list out items in the machine
		System.out.println(machine1);
		System.out.println("\t\t[NOTICE: Only $5,$2 and $1 are accepted. Also, press enter every time you type something.]");

		int i=0;
		do {
			String answer=""; //user input on whether to cash out or continue shopping
			int serialNumber=0; //holds the id of the item
			double total=0; //holds the total Price 
			String selectedItem="";  //holds the names of the items bought
			int amount=0;
			double balance=0;
			String powerAnswer="";
			LocalTime timeUserBoughtItem;
			LocalDate dateUserBoughtItem=LocalDateTime.now().toLocalDate();
			DateTimeFormatter formatter= DateTimeFormatter.ofPattern("MM/dd/yy");
			DateTimeFormatter formatter2= DateTimeFormatter.ofPattern("hh:mm a");


			System.out.println("\nUser#"+(i+1)+"\t\t\t\t\t\t\t\t\t\t\t\t\tDate: "+dateUserBoughtItem.format(formatter));
			while(true) { //keep looping until the user wants to cash out
				//prompt user for the serial number he/she wants to buy
				System.out.print("Select item number: ");

				try {
					serialNumber=input.nextInt();
					input.nextLine();
				}catch(InputMismatchException e) {
					System.out.print("(Error...type in an ACTUAL number please)");
					continue;
				}

				//validate serial number (the serial number user typed must be among those in available items
				if(!(machine1.selectItem(serialNumber)==null)) {
					
					if((machine1.checkStock(serialNumber)==false)) {
					System.out.print("Item selected: "+ machine1.selectItem(serialNumber).getName()+" - $"+machine1.selectItem(serialNumber).getPrice()+" (press enter)");
					
					//total price of each item selected
					total+= machine1.selectItem(serialNumber).getPrice(); 
					input.nextLine();

					//Names of all items selected
					selectedItem+=machine1.selectItem(serialNumber).getName()+", "; 
					}
					else {
						System.out.print("Sorry "+machine1.selectItem(serialNumber).getName()+" is out of stock!");
						input.nextLine();
					}
					machine1.selectItem(serialNumber).reduceQuantity();
					
					//ask if they want to continue buying or cash out
					System.out.print("Do you want to cash out or keep shopping? (type answer): ");
					answer=input.nextLine();
                  
                   
				}else {
					System.out.println("(Error... Item number does not exist)");
				}

				//display money and items if user requested to cash out
				if(answer.equalsIgnoreCase("Cash out")) {
					System.out.printf("Total amount: $%.2f\n",total);

					//Keep asking for input until the total amount/money equals the total price
					while(true) {
						System.out.print("Enter amount: $");
						try {
							amount=input.nextInt();
						}catch(InputMismatchException e) {
							System.out.print("Error...that's not a number GENIUS!");
							continue;
						}
						machine1.addMoney(amount);
						if(machine1.getMoney()>=total) {
							break;
						}
						System.out.printf("Remaining money... $%.2f\n",(total-machine1.getMoney()));
					}

					//Vend the item
					machine1.vendItem(serialNumber);

					//Print money, give item(s) and bid farewell
					balance=machine1.getMoney()-total; 
					if(!(balance==0.0)) {
						System.out.printf("Here's your change: $%.2f\n",balance);
					}
					timeUserBoughtItem=LocalDateTime.now().toLocalTime();
					System.out.println("Vending..."+selectedItem+" \t\t Time: "+timeUserBoughtItem.format(formatter2));
					System.out.println("Enjoy!");	
					break;
				}
			}
			System.out.println("\n\t\t\t\t\t\t........\n\n\t\t\t\t\t  Anyone else? Yes/No");
			powerAnswer=input.next();
			if(!(powerAnswer.equalsIgnoreCase("Yes"))){
				System.out.println("Powering down...");
				machine1.switchOff();
			}
			i++;
			machine1.setMoney();
		}while(machine1.getPower()==true);
		input.close();
	}

}
