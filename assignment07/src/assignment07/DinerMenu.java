package assignment07;

import java.util.ArrayList;

public class DinerMenu implements Menu {
	
	private ArrayList<MenuEntry> menuEntries = new ArrayList<MenuEntry>();
	
	public void addItem(String n, String d, boolean v, Price p){
		menuEntries.add(new MenuEntry(n,d,v,p));
	}
	
	public DinerMenuIterator createIterator(){
		DinerMenuIterator it =  new DinerMenuIterator( menuEntries.toArray(new MenuEntry[]{}));
		return it; 
	}
	
	public DinerMenu(){
		addItem("Chicken","Grilled Chicken", false,new Price(18,25));
		addItem("Bacon","Grilled bacon", false,new Price(12,30));
		addItem("Fish","Grilled fish", false,new Price(20,0));
		addItem("Patato","Oven baked potato", true,new Price(3,5));
		addItem("Salad","Lettuce, tomatoes, lemon juice, olive oil", true,new Price(6,0));
		addItem("Rice","Boiled rice", true ,new Price(5,0));
	}
	
}
