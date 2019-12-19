package lab09pink;

public class Lower extends Top {
	private int[] arr1;
	
	public Lower (int[] arr2, int[] arr3){
		super(arr2);
		arr1=arr3;
	}
	
	@Override
	public double average(){
		return new Top(arr1).average();
	}
	
	@Override
	public int max(){
		return Math.max(new Top(arr1).max(),super.max());
	}

}
