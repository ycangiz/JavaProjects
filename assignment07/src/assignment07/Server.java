package assignment07;

public class Server {
	private Menu pancakeMenu;
	private Menu dinerMenu;
	
	public Server(Menu a, Menu b){
		pancakeMenu = a;
		dinerMenu = b;
	}
	
	private void printMenu(MenuEntryIterator iterator){
		for(MenuEntry menuEntry : iterator.toIterable()){
			System.out.println(menuEntry);
		}
	}
	public void printMenu(){
		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeMenu.createIterator());
		System.out.println("\nLUNCH");
		printMenu(dinerMenu.createIterator());
	}

	private boolean isVegetarian(String name, MenuEntryIterator iterator){
		for(MenuEntry menuEntry : iterator.toIterable()){
			if(name==menuEntry.getName()){
				if(menuEntry.isVegetarian()) return true;
			}
		}
		return false;
	}
	
	private void printVegetarianMenu(MenuEntryIterator iterator){
		for(MenuEntry menuEntry : iterator.toIterable()){
			if(menuEntry.isVegetarian()){
				System.out.println(menuEntry);
			}
		}
	}
	
	public void printVegetarianMenu(){
		System.out.println("\nVEGETARIAN MENU\n----\nBREAKFAST");
		printVegetarianMenu(pancakeMenu.createIterator());
		System.out.println("\nLUNCH");
		printVegetarianMenu(dinerMenu.createIterator());
		
	}
	
	 public boolean isEntryVegetarian(String name){
		 if( isVegetarian(name, pancakeMenu.createIterator()) || isVegetarian(name, dinerMenu.createIterator()))
			 return true;
		 
		 return false;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
