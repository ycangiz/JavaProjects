package assignment02;

public class OneChange {
	
	private int[] array;
	
	public OneChange(int[] anArray){
		array=anArray;
	}
	public int smallestAfter(int start){
		int minAfter=Integer.MAX_VALUE;
		int minIndex=0;
		for(int i=start; i<array.length; i++){
			if(array[i]<minAfter){
				minAfter=array[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	public int[] modify(int start){
		int k=smallestAfter(start);
		int[] temp=new int [array.length];
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
		return array;										//to use array itself to return at "WeirdSorter".
	}
}
