package assignment02;

import java.util.Arrays;

public class Book {
	private String title;
	private int numPages;
	
	public Book (String aTitle, int aNumPages) {
			
		title=aTitle;
		numPages=aNumPages;
	}
	public String getTitle(){
		return title;
	}
	public int getNumPages(){
		return numPages;
	}
	public void setNumPages(int aNumPages){
		numPages=aNumPages;
	}
	public String toString(){
		return "\n"+title+","+numPages+"pages";
	}
	
	public static void main(String[] args){
		Book[] books={new Book("book1",100),new Book("book2",200),new Book("book3",300)};
		System.out.println(Arrays.toString(books));
	}
}

