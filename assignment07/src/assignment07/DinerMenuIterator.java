package assignment07;

public class DinerMenuIterator implements MenuEntryIterator{
	private MenuEntry[] list;
	private int pos=0;
	public DinerMenuIterator(MenuEntry listSet){
		list[pos]=listSet;
	}
	public DinerMenuIterator(MenuEntry[] array) {
		list=array;
	}
	public MenuEntry next(){
		return list[pos++];
	}
	public boolean hasNext(){
		if(pos>=list.length||list==null || list[pos]==null  ) return false;
		return true;
	}
	public void remove() {
		if (pos <= 0) {
			throw new IllegalStateException
				("You can't remove an Entry until you've done at least one next()");
		}
		if (list[pos-1] != null) {
			for (int i = pos-1; i < (list.length-1); i++) {
				list[i] = list[i+1];
			}
			list[list.length-1] = null;
		}
	}
}
