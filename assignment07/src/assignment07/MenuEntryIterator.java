package assignment07;

import java.util.Iterator;

public interface MenuEntryIterator extends Iterator<MenuEntry> {
	
	default Iterable<MenuEntry> toIterable(){
		return () -> this;
	}
	
	static MenuEntryIterator adapt(Iterator<MenuEntry> iter){
		
		return new MenuEntryIterator(){
			public boolean hasNext(){
				return iter.hasNext();
			}
			public MenuEntry next(){
				return iter.next();
			}
		};
	 }
	
}
