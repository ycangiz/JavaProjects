package assignment02;

public class WeirdSorterBook {
	private Book[] arrays;

	public WeirdSorterBook(Book[] anArray){
		arrays=anArray;
	}
	
	public Book[] sorted(){
		for(int i=0; i<arrays.length; i++){
			OneChangeBook two = new OneChangeBook(arrays);
			two.modify(i);
		}
		 return arrays; 
	}
}

