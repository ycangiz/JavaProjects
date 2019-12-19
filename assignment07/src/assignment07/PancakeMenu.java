package assignment07;

import java.util.ArrayList;

public class PancakeMenu implements Menu {
	private ArrayList<MenuEntry> menuEntries = new ArrayList<MenuEntry>();
	
	 public void addItem(String n, String d, boolean v, Price p){
		 menuEntries .add(new MenuEntry(n,d,v,p));
	 }
	 
	 public MenuEntryIterator createIterator(){
		 return  MenuEntryIterator.adapt(menuEntries.iterator());
	 }
	 
	 public PancakeMenu(){
		 addItem("Strawberry","Strawberry pancake",true,new Price(3,50));
		 addItem("Buttermilk","ButterMilk pancake",false,new Price(4,50));
		 addItem("Sausage","Pancake with sausage",false,new Price(5,50));
		 addItem("Bacon","Pancake with bacon",false,new Price(7,00));
	 }
	 
	
}
