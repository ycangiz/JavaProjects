package assignment03;

public class Assig3 {
		
		public static boolean hasNegative(double[] arr){
			boolean returnValue=false;
			for(int i=0; i<arr.length && !returnValue; i++){
				if(arr[i]<0){
					returnValue=true;
					break;
				}
			}return returnValue;
		}
		public static int indexOf(double value, double[] array){
			if(array==null) return -3;
			else if(array.length==0) return -2; 
			for(int i=0; i<array.length; i++){
					if(Math.abs(value-array[i])<1e-9) return i; 
			}
			for(int i=0; i<array.length; i++){
				if(array!=null && array.length>0 && Math.abs(value-array[i])>=1e-9){
					if(i==array.length-1) return -1;
				}
				else break;				
			}
			return 0;
		} 
		public static int indexOf2(double value, double[] array){
			if(array==null) return -3;
			if(array.length==0) return -2;
			
			for(int i=0; i<array.length; i++){
				for(int j=0; j<array.length-1;j++){
					if(array[j+1]<array[j]){
						double temp = array[j+1];
						array[j+1] = array[j];
						array[j] = temp;
					}
				}
			}
			for(int i=0; value>=array[i]; i++){
					if(Math.abs(value-array[i])<1e-9) return i; 
			}
			for(int i=0; i<array.length; i++){
				if(array!=null && array.length>0 && Math.abs(value-array[i])>=1e-9){
					if(i==array.length-1) return -1;
				}			
			}
			return 0;
		} 
		public static int indexOf3(int value, int[] arr){
			
			if(arr!=null && arr.length!=0){
				for(int i=0; i<arr.length; i++){
					for(int j=0; j<arr.length-1; j++){
						if(arr[j]>arr[j+1]){
							int temp=arr[j+1];
							arr[j+1]=arr[j];
							arr[j]=temp;
						}
					}
				}
				if(value<arr[0]) return -1;
				for(int i=0; i<arr.length; i++){
					if(value==arr[i]) return i;
				}
				int counter=0;
				for(int i=0; i<arr.length;i++){
					if(arr[i]>value) return -1*i;
					if(value>arr[i]) counter++;
					if(counter==arr.length) return -(arr.length);
				}
			}
			return 0;
		}
		public static int[] insertIfNeeded(int value, int[] arr){
			if(arr!=null && arr.length!=0){
				for(int i=0; i<arr.length; i++){
					for(int j=0; j<arr.length-1; j++){
						int temp=arr[j+1];
						arr[j+1]=arr[j];
						arr[j]=temp;						
					}
				}
				int k=indexOf3(value,arr);
				if(k>=0) return arr;
				if(k<0){
					int[]arr1=new int[arr.length+1];
					
					System.arraycopy(arr, 0, arr1, 0, -k);
					arr1[-k] = value;
					System.arraycopy(arr, -k, arr1, -k+1, arr.length+k);
					return arr1;
				}
			}
			return null;
		}
}
