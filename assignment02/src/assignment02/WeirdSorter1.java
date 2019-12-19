package assignment02;

public class WeirdSorter1 {
	private int[] array;
	public WeirdSorter1(int[] anArray){
		array=anArray;
	}
	
	public int[] sorted(){
		for(int i=0; i<array.length; i++){
			OneChange1 two = new OneChange1(array);
			two.modify(i);
			
		}
		 return array; 
	}
}