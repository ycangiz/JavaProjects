package assignment02;

public class OneChangeBook {
	private Book[] array;
	
	public OneChangeBook(Book[] anArray){
		array=anArray;
	}
	public int smallestAfter(int start){
		int minAfter=Integer.MAX_VALUE;
		int minIndex=0;
		for(int i=start; i<array.length; i++){
			if(array[i].getNumPages()<minAfter){
				minAfter=array[i].getNumPages();
				if(minAfter==array[i].getNumPages()) minIndex=i;
			}
		}
		return minIndex;
	}
	public Book[] modify(int start){
		int k=smallestAfter(start);
		Book[] temp=new Book [array.length];
		for(int j=0; j<start; j++){
			temp[j]=array[j];
		}
		temp[start]=array[k];
		for(int j=start; j<k; j++){
			temp[j+1]=array[j];
		}
		for(int j=k+1; j<array.length; j++){
			temp[j]=array[j];
		}
		for(int i=0; i<array.length; i++) array[i]=temp[i]; //I made array itself changed because it should be changed
		return array;										//because we have to use array itself to return at "WeirdSorter".
	}
}


