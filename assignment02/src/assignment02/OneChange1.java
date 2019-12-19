package assignment02;

public class OneChange1 {
private int[] array;
	
	public OneChange1(int[] anArray){
		array=anArray;
	}
	public int biggestAfter(int start){
		int maxAfter=Integer.MIN_VALUE;
		int maxIndex=0;
		for(int i=start; i<array.length; i++){
			if(array[i]>maxAfter){
				maxAfter=array[i];
				if(maxAfter==array[i]) maxIndex=i;
			}
		}
		return maxIndex;
	}
	public int[] modify(int start){
		int k=biggestAfter(start);
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
		for(int i=0; i<array.length; i++) array[i]=temp[i]; 
		return array;										
	}
}

