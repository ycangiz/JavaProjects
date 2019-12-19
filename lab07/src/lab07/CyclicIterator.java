package lab07;

public class CyclicIterator implements IntIterator{
	private int[] arr1;
	private int pos = 0;
	
	public CyclicIterator(int[] arr){
			arr1=arr;
	}
	public boolean hasNext(){
		return true;
	}
	public Integer next(){
		if(pos>=arr1.length) pos=pos%arr1.length;
		return arr1[pos++];
		
	}
}
