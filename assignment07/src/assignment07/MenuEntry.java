package assignment07;

public class MenuEntry implements MenuEntryIterator {
	private String name;
	private String description;
	private boolean vegetarian;
	private Price price;
	public MenuEntry(String name, String description, boolean vegetarian, Price price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public Price getPrice() {
		return price;
	}
	
	public void changeUp(double percent) {
		price.changeUp(percent);
	}
	public void changeDown(double percent) {
		price.changeDown(percent);
	}
	@Override
	public boolean hasNext() {
		return false;
	}
	@Override
	public MenuEntry next() {
		return null;
	}
	public String toString(){
		return name + "," + price + "--" + description;
	}
	
	
	
}
