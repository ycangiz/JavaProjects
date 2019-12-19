package lab03;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class ArrayFromFile {
	private int[] array;
	
	public ArrayFromFile(String filename) {
	    // try-with-resources block (sc is the resource we are trying to use)
	    try (Scanner sc = new Scanner(new File(filename))) {
	    	int n=sc.nextInt();
	    	array=new int[n];
	    	for(int i=0; i<n; i++){
	    		array[i]=sc.nextInt();
	    	}
	    } catch (Exception e) {
	    	array =new int[0];
	    	}
	    }
	public int[] getArray(){
		return array;
	}
	public String toString(){
		return Arrays.toString(array);
	}
	public void removeOddElements(){
		int evenCount=0;
		for(int element : array){
			if(element%2==0) evenCount++;
		}
		int[] temp= new int[evenCount];
		
		int n = 0; 
		
		for (int i : array) {
		
		    if(i%2==0){ 
		    	temp[n]=i;
		   
		    	n++; // shorthand to increment by 1
		    }
		  }
			array=temp;
		
		}
		
}

	
	


