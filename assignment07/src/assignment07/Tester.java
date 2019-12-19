package assignment07;

public class Tester {

	public static void main(String[] args) {
		PancakeMenu pancakeMenu = new PancakeMenu();
		DinerMenu dinerMenu = new DinerMenu();
		Server server = new Server(pancakeMenu, dinerMenu);
		server.printMenu();
		server.printVegetarianMenu();

		System.out.println("\nCustomer asks, is the Strawberry vegetarian?"); 
		// use the name of a lunch item that is not vegetarian in place of Item 3
		System.out.print("Server says: ");
		System.out.println(server.isEntryVegetarian("Strawberry")?"Yes":"No");
		System.out.println("\nCustomer asks, are the chicken vegetarian?");
		// use the name of a pancake item that is vegetarian in place of Item 7
		System.out.print("Server says: ");
		System.out.println(server.isEntryVegetarian("Chicken")?"Yes":"No");
		
		changePrices(pancakeMenu);
		changePrices(dinerMenu);
		
		server.printMenu();
		server.printVegetarianMenu();		
		

	}
	
	public static void changePrices(Menu menu){
		for(MenuEntry menuEntry : menu.createIterator().toIterable()){
			if(menuEntry.isVegetarian()) menuEntry.changeDown(5);
			menuEntry.changeUp(10);
		}
	}

}
