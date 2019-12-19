package assignment02;

public class WeirdSorter {
	private int[] array;
	public WeirdSorter(int[] anArray){
		array=anArray;
	}
	
	public int[] sorted(){
		for(int i=0; i<array.length; i++){
			OneChange two = new OneChange(array);
			two.modify(i);
			
		}
		 return array; 
	}
}
