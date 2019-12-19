package lab09pink;

public class Top {
	private int[] arr = new int[0];
	public Top(int[] arr1){
		arr=arr1;
	}
	public double average(){
		double sum=0;
		if(arr==null || arr.length==0) return 0;
		for(int i=0; i<arr.length; i++){
			sum+=arr[i]; 
		}
		return sum/arr.length;
	}
	
	public int max(){
		int maximum= Integer.MIN_VALUE;
		if(arr==null || arr.length==0) return maximum;
		for(int i=0; i<arr.length; i++){
			if(arr[i]>maximum) maximum= arr[i];
		}
		return maximum;
	}
}
