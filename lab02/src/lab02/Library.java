package lab02;

public class Library {

	public static void main(String[] args) {

		Book[] myBooks={new Book("a-book",100),new Book("b-book",200),new Book("c-book",300)};
		
		for(int i=0;i<myBooks.length;i++)
			System.out.println("Normal for loop :"+myBooks[i].getTitle());
		
		for(Book currentTitle : myBooks)
			System.out.println("Enhanced for loop: "+currentTitle.getTitle());
		
		System.out.println("Expected number of total pages is 600");
		System.out.println("the number of pages:"+numPagesInLibrary(myBooks));
		
		System.out.println("The maximum page number is: "+mostPages(myBooks));
		
	}
	public static int numPagesInLibrary(Book[] books){
		int sum=0;
		for(int i=0; i<books.length; i++){
			
			sum += books[i].getNumPages();
		}
		for(Book currentPages : books){
			sum += currentPages.getNumPages();
		}
		
		return sum/2; // I wrote sum/2 because of you wanted 2 for loops and I used same variable for both. So if I write sum, it gives
					  //2 times of the total of pages.
	}
	public static int mostPages(Book[] books){
		int maxPage=0;
		int enhancedMaxPage=0;
		for(int i=0;i<books.length;i++){
				if(books[i].getNumPages()>maxPage){
					maxPage=books[i].getNumPages();
			}
		}
		for(Book currentpage : books){
			if(currentpage.getNumPages()>enhancedMaxPage){
				enhancedMaxPage=currentpage.getNumPages();
			}
		}
		return maxPage+enhancedMaxPage;
		
	}
}