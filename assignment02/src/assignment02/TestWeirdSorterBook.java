package assignment02;

import java.util.Arrays;

public class TestWeirdSorterBook {

	public static void main(String[] args) {
		Book[] test1 = {
				new Book("Book A", 3), 
				new Book("Book B", 7),
				new Book("Book C", 9),
				new Book("Book D", 10),
				new Book("Book E", 2),
				new Book("Book F", 6),
				new Book("Book G", 3),
				new Book("Book H", 1)
			};
			WeirdSorterBook ws2 = new WeirdSorterBook(test1);
			System.out.println(Arrays.toString(ws2.sorted()));
			
			
			System.out.println("Average number of pages over all the books is: "+avgPagesInLibrary(test1));

	}
	 public static double avgPagesInLibrary(Book[] books) {
		 double sum=0;
		 for(int i=0; i<books.length; i++){
			 sum+=books[i].getNumPages();
		 }
		 return sum/books.length;
	 }

}
